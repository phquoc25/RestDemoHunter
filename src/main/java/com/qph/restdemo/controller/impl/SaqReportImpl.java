package com.qph.restdemo.controller.impl;

import com.google.common.collect.ImmutableMap;
import com.qph.restdemo.common.RestErrors;
import com.qph.restdemo.common.RestException;
import com.qph.restdemo.controller.SaqReport;
import com.qph.restdemo.service.report.SaqReportGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by quocphan on 10/13/2016.
 */
@RestController
@RequestMapping("/api/saq")
public class SaqReportImpl implements SaqReport {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaqReportImpl.class);

    @Autowired
    private List<SaqReportGenerator> saqReportGenerators;

    @Override
    @RequestMapping(value = "/sites/reports/{reportFormat}", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<byte[]> downloadSaqReport(@PathVariable("reportFormat") String reportFormat,
                                                    @RequestParam("language") String language) throws Exception {
        LOGGER.debug("Downloading in {} with format {}", language, reportFormat);
        byte[] bytes = null;
        boolean isSupportedFormat = false;
        try {
            for (SaqReportGenerator saqReportGenerator: saqReportGenerators) {
                if(saqReportGenerator.formatSupported(reportFormat)){
                    bytes = saqReportGenerator.generateReport(language);
                    isSupportedFormat = true;
                    break;
                }
            }
        } catch (Exception e) {
            String message = "Error when generating PDF";
            LOGGER.error(message);
            throw new Exception(message);
        }
        if (!isSupportedFormat){
            LOGGER.error(RestErrors.DOWNLOAD_FORMAT_NOT_SUPPORTED.getErrorMessage());
            throw new RestException(RestErrors.DOWNLOAD_FORMAT_NOT_SUPPORTED.toRestError(), ImmutableMap
                    .<String, Object> builder().put("reportFormat", reportFormat).build());
        }
        LOGGER.debug("Finish downloading in {} with format {}", language, reportFormat);
        if (bytes.length > 0){
            return new ResponseEntity<>(bytes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
