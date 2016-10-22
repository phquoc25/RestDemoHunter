package com.qph.restdemo.config;

import com.qph.restdemo.service.report.dto.ObjectFactory;
import org.apache.avalon.framework.configuration.DefaultConfiguration;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.avalon.framework.configuration.MutableConfiguration;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.xmlgraphics.io.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import java.io.InputStream;
import java.net.URI;

@Configuration
public class ApacheFOPConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(ApacheFOPConfiguration.class);
    @Bean
    public Marshaller jaxbMarshaller() {
        final Jaxb2Marshaller jaxb = new Jaxb2Marshaller();
        jaxb.setPackagesToScan(ObjectFactory.class.getPackage().getName());
        return jaxb;
    }

    @Bean
    public URIResolver uriResolver(){
        return new ClasspathURIResolver();
    }

    @Bean
    public TransformerFactory transformerFactory() {
        return TransformerFactory.newInstance();
    }

    private static final String FOP_RESOURCES_PATH = "report/";
    private static final String FOP_CONFIGURATION_RESOURCE_NAME = "fop_configuration.xml";
    private static final String FOP_CONFIGURATION_RESOURCE = FOP_RESOURCES_PATH + FOP_CONFIGURATION_RESOURCE_NAME;

    @Bean
    public FopFactory fopFactory(final ResourceResolver resolver) throws Exception {
        Resource resource = new ClassPathResource(FOP_CONFIGURATION_RESOURCE);
        URI parentResourceUri;
        try {
            parentResourceUri = new URI(resource.getURI().toString().replace(FOP_CONFIGURATION_RESOURCE_NAME, ""));

            FopFactoryBuilder fopFactoryBuilder = new FopFactoryBuilder(parentResourceUri).setConfiguration(createConfigurationFromResource(resource, parentResourceUri));
            return fopFactoryBuilder.build();
        } catch (Exception ex) {
            LOG.error("Error while initializing FOP factory",ex);
            throw ex;
        }
    }

    private DefaultConfiguration createConfigurationFromResource(Resource configResource, URI parentResourceUri) throws Exception {
        try (InputStream configIs = configResource.getInputStream()) {
            DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
            DefaultConfiguration configuration = (DefaultConfiguration) cfgBuilder.build(configIs);
            MutableConfiguration base = configuration.getMutableChild("base");
            base.setValue(parentResourceUri.toString());
            return configuration;
        }
    }
}
