package com.qph.restdemo.service.report;

import com.qph.restdemo.service.report.dto.ReportSvcDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by quocphan on 12/7/2016.
 */
public interface SaqReportService {
    String extractXml() throws IOException;
    void generateReportData(String siteCode, String moduleCode, String userCode, String language);
    ReportSvcDTO getSaqReportData();
}
