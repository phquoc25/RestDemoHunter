package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.Constant;
import com.qph.restdemo.service.FileReader;
import com.qph.restdemo.service.dto.QuestionConfigDTO;
import com.qph.restdemo.service.dto.QuestionConfigField;
import com.qph.restdemo.service.dto.QuestionConfigResultDTO;
import com.qph.restdemo.service.utils.ExcelParsingUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by quocphan on 9/11/2016.
 */
@Service
public class ExcelFileReader implements FileReader<List, Workbook> {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Workbook read(String fullFileName) throws Exception {
        Workbook workBook = null;
        if (fullFileName != null && !fullFileName.isEmpty()) {
            if (!fullFileName.endsWith(Constant.XLS_EXTENSION) && !fullFileName.endsWith(Constant.XLSX_EXTENSION)) {
                throw new Exception("Not an excel file");
            }
            try {
                Resource resource = applicationContext.getResource("classpath:" + fullFileName);
                if(resource.exists()) {
                    if (fullFileName.endsWith(Constant.XLS_EXTENSION)) {
                        workBook = WorkbookFactory.create(resource.getInputStream());
                    } else if (fullFileName.endsWith(Constant.XLSX_EXTENSION)) { // excel
                        // version
                        // 2008
                        // or
                        // above
                        workBook = (XSSFWorkbook) WorkbookFactory.create(resource.getInputStream());
                    }
                }
            } catch (Exception e) {
                throw new Exception("File Not Found");
            }
        }
        return workBook;
    }

    @Override
    public List<QuestionConfigDTO> process(Workbook workBook) {
        // get first sheet
        QuestionConfigResultDTO result = new QuestionConfigResultDTO();
        Sheet sheet = workBook.getSheetAt(0);
        List<QuestionConfigDTO> questionConfigDTOs = new ArrayList<QuestionConfigDTO>();
        try {
            Iterator<Row> rowIterator = sheet.iterator();
            List<String> headers = new ArrayList<String>();

            // read headers
            if (rowIterator.hasNext()) {
                headers = ExcelParsingUtils.getHeader(rowIterator.next());
            }
            // do parsing
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                QuestionConfigDTO dto = parseRow(row, headers, result);
                if(dto != null) {
                    questionConfigDTOs.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questionConfigDTOs;
    }

    private QuestionConfigDTO parseRow(Row row, List<String> headers, QuestionConfigResultDTO result) throws InvocationTargetException, IllegalAccessException {
        QuestionConfigDTO dto = new QuestionConfigDTO();
        if (!ExcelParsingUtils.checkIfRowIsEmpty(row)) {
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = row.getCell(i);
                if (cell != null) {
                    if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                        //TODO
                    } else {
                       QuestionConfigField field = QuestionConfigField.findByHeaderName(headers.get(i));
                        if (field != null) {
                            BeanUtils.setProperty(dto, field.getProperty(),
                                    ExcelParsingUtils.getCellValue(cell));
                        }
                    }
                }
            }
        } else {
            return null;
        }
        return dto;
    }
}
