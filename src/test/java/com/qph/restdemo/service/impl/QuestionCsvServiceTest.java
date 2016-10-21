package com.qph.restdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by quocphan on 9/11/2016.
 */
public abstract class QuestionCsvServiceTest extends ServiceTest {
    @Autowired
    protected ExcelFileReader excelFileReader;
}
