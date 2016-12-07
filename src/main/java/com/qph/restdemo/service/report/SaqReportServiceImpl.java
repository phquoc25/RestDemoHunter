package com.qph.restdemo.service.report;

import com.qph.restdemo.common.Language;
import com.qph.restdemo.service.report.dto.Report;
import com.qph.restdemo.service.report.dto.ReportSvcDTO;
import com.qph.restdemo.service.report.dto.SaqResultsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.stereotype.Service;

import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quocphan on 12/7/2016.
 */
@Service
public class SaqReportServiceImpl implements SaqReportService{
    private ReportSvcDTO reportData;
    private final Marshaller marshaller;

    @Autowired
    public SaqReportServiceImpl(Marshaller marshaller) {
        this.marshaller = marshaller;
    }


    @Override
    public String extractXml() throws IOException {
        Report report = new Report();
        Writer xmlStringWriter = new StringWriter();
        marshaller.marshal(report, new StreamResult(xmlStringWriter));
        return xmlStringWriter.toString();
    }

    @Override
    public void generateReportData(String siteCode, String moduleCode, String userCode, String language) {
        reportData = new ReportSvcDTO();
        reportData.setContentFont(Language.getFontByLanguage(language));
        List<SaqResultsList> saqResultLists = new ArrayList();
        reportData.setSaqResultsList(saqResultLists);
    }

    @Override
    public ReportSvcDTO getSaqReportData() {
        return reportData;
    }
}
