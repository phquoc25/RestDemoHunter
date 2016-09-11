package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.FileReader;
import com.qph.restdemo.service.dto.QuestionConfigDTO;
import com.qph.restdemo.service.dto.QuestionType;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by quocphan on 9/11/2016.
 */
public class ExcelFileReaderTest extends ServiceTest{
    @Autowired
    private ExcelFileReader excelFileReader;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testRead() throws Exception {
        String fullFileName = "question.xlsx";
        Workbook workbook = excelFileReader.read(fullFileName);
        Assert.assertNotNull(workbook);
        List<QuestionConfigDTO> rowContent = excelFileReader.process(workbook);
        Assert.assertNotNull(rowContent);
        Assert.assertEquals(9, rowContent.size());
        for (int i = 0; i < 9; i++) {
            System.out.println(rowContent.get(i));
        }
    }

}