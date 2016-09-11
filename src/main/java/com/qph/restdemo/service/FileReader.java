package com.qph.restdemo.service;

import java.io.InputStream;

/**
 * Created by quocphan on 9/11/2016.
 */
public interface FileReader<V, T> {
    T read(String fullFileName) throws Exception;
    V process(T file);
}
