package com.qph.restdemo.config;

import org.apache.xmlgraphics.io.Resource;
import org.apache.xmlgraphics.io.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

@Component
public class FopResourceResolver implements ResourceResolver {

    private static final Logger LOG = LoggerFactory.getLogger(FopResourceResolver.class);

    private final ResourceLoader loader;

    @Autowired
    public FopResourceResolver(final ResourceLoader loader) {
        this.loader = loader;
    }

    @Override
    public Resource getResource(final URI uri) throws IOException {
        return new Resource(loader.getResource(uri.toString()).getInputStream());
    }

    @Override
    public OutputStream getOutputStream(final URI uri) throws IOException {
        LOG.debug("getOutputStream, UnsupportedOperationException: {}", uri);
        throw new UnsupportedOperationException();
    }
}
