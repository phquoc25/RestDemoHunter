package com.qph.restdemo.service.report;

import com.qph.restdemo.common.Language;
import com.qph.restdemo.service.impl.ServiceTest;
import com.qph.restdemo.service.report.dto.ReportSvcDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by quocphan on 12/7/2016.
 */
public class SaqReportServiceImplTest extends ServiceTest{
    @Autowired
    private SaqReportService saqReportService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void extractXml() throws Exception {

    }

    @Test
    public void generateReportData() throws Exception {
        saqReportService.generateReportData("ZS000001", "ZQM00001", "ZU00001", "en");
        ReportSvcDTO saqReportData = saqReportService.getSaqReportData();
        Assert.assertNotNull(saqReportData);
        //Font should be Noto-sans
        Assert.assertEquals(Language.EN.getFontFamily(), saqReportData.getContentFont());
        Assert.assertEquals(1, saqReportData.getSaqResultsList().size());
        Assert.assertEquals("SAQ Results", saqReportData.getSaqResultsTitle());
        Assert.assertNotNull(saqReportData.getSiteDetail());
    }
}