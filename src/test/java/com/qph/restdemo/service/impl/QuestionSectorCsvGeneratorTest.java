package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.dto.QuestionConfigDTO;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by quocphan on 9/11/2016.
 */
public class QuestionSectorCsvGeneratorTest extends QuestionCsvServiceTest{

    @Autowired
    private QuestionSectorCsvGenerator questionSectorCsvGenerator;
    public static final String INPUT_FILE_NAME = "question.xlsx";
    public static final String OUTPUT_FILE_NAME = "smst_19_question_sector.csv";

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void writeContents() throws Exception {
        Workbook workbook = excelFileReader.read(INPUT_FILE_NAME);
        List<QuestionConfigDTO> rowContent = excelFileReader.process(workbook);
        String generatedFile = questionSectorCsvGenerator.generate(rowContent, OUTPUT_FILE_NAME);
        Assert.assertNotNull(OUTPUT_FILE_NAME, generatedFile);
    }

}