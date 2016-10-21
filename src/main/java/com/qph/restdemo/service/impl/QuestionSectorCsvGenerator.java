package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.dto.QuestionConfigDTO;
import com.qph.restdemo.service.dto.QuestionSectorDTO;
import com.qph.restdemo.service.dto.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quocphan on 9/11/2016.
 */
@Service
public class QuestionSectorCsvGenerator extends QuestioncsvGenerator{

    @Autowired
    public QuestionSectorCsvGenerator(ApplicationContext applicationContext) {
        super("question_code;sector_code;version;modified_by;modified_on", applicationContext);
    }

    @Override
    protected void writeContents(FileWriter fileWriter, List<QuestionConfigDTO> rowContents) throws IOException {
        for (QuestionConfigDTO rowContent : rowContents){
            List<QuestionSectorDTO> questionSectorDTOs = new ArrayList<>();
            QuestionSectorDTO questionSectorDTO = new QuestionSectorDTO();
            questionSectorDTO.setVersion(String.valueOf(0));
            questionSectorDTO.setModifiedOn(MODIFIED_ON);
            questionSectorDTO.setModifiedBy(MODIFIED_BY);
            questionSectorDTO.setQuestionCode(rowContent.getQuestionCode());
            processSector(fileWriter, questionSectorDTO, rowContent.getAgricultureLarge(), Sector.AGRI_LARGE);
            processSector(fileWriter, questionSectorDTO, rowContent.getIntermediate(), Sector.INTERME);
            processSector(fileWriter, questionSectorDTO, rowContent.getManufact(), Sector.MANUFACT);
            processSector(fileWriter, questionSectorDTO, rowContent.getServiceProvider(), Sector.SERVICE_P);
            processSector(fileWriter, questionSectorDTO, rowContent.getAgricultureSmall(), Sector.AGRI_SMALL);
            processSector(fileWriter, questionSectorDTO, rowContent.getHeavyEngineering(), Sector.HEAVY_EN);
            processSector(fileWriter, questionSectorDTO, rowContent.getOfficeHQ(), Sector.OFFICE_HQ);
        }
    }

    private void processSector(FileWriter fileWriter, QuestionSectorDTO questionSectorDTO, String sectorStr, Sector sector) throws IOException {
        if (!StringUtils.isEmpty(sectorStr)){
            QuestionSectorDTO newDto = new QuestionSectorDTO(questionSectorDTO);
            newDto.setSectorCode(sector.getCode());
            writeToFile(newDto, fileWriter);
        }
    }

    private void writeToFile(QuestionSectorDTO newDto, FileWriter fileWriter) throws IOException {
        fileWriter.append(newDto.getQuestionCode());
        fileWriter.append(DELIMITER);
        fileWriter.append(newDto.getSectorCode());
        fileWriter.append(DELIMITER);
        fileWriter.append(newDto.getVersion());
        fileWriter.append(DELIMITER);
        fileWriter.append(newDto.getModifiedBy());
        fileWriter.append(DELIMITER);
        fileWriter.append(newDto.getModifiedOn());
        fileWriter.append(NEW_LINE_SEPARATOR);
    }
}
