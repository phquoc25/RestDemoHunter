package com.qph.restdemo.service;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by quocphan on 9/11/2016.
 */
public interface FileGenerator<T> {
    String generate(List<T> rowContents, String fullFileName) throws FileNotFoundException;
}
