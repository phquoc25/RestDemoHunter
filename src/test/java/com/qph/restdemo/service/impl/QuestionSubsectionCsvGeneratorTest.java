package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.dto.QuestionConfigDTO;
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
public class QuestionSubsectionCsvGeneratorTest extends ServiceTest{

    @Autowired
    private QuestionSubsectionCsvGenerator questionSubsectionCsvGenerator;
    @Autowired
    private ExcelFileReader excelFileReader;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void writeContents() throws Exception {
        String fullFileName = "question.xlsx";
        Workbook workbook = excelFileReader.read(fullFileName);
        List<QuestionConfigDTO> rowContent = excelFileReader.process(workbook);
        String fileName = "question_subsection.csv";
        String generatedFile = questionSubsectionCsvGenerator.generate(rowContent, fileName);
        Assert.assertNotNull(fileName, generatedFile);
    }

}