package com.qph.restdemo.config;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by quocphan on 10/21/2016.
 */
public class ClasspathURIResolver implements URIResolver {
    @Override
    public Source resolve(String href, String base) throws TransformerException {
        return new StreamSource(getClass().getResourceAsStream(href));
    }
}
