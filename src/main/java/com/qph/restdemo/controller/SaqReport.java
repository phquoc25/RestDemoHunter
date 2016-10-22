package com.qph.restdemo.controller;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by quocphan on 10/13/2016.
 */
public interface SaqReport {
    ResponseEntity<byte[]> downloadSaqReport(String reportFormat, String language) throws Exception;
}
