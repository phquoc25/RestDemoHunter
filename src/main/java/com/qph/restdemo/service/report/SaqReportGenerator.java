package com.qph.restdemo.service.report;

/**
 * Created by quocphan on 10/22/2016.
 */
public interface SaqReportGenerator {
    byte[] generateReport(String language);
    boolean formatSupported(String formatType);
}
