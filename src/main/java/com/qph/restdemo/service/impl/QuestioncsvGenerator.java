package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.FileGenerator;
import com.qph.restdemo.service.dto.QuestionConfigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by quocphan on 9/11/2016.
 */
public abstract class QuestioncsvGenerator implements FileGenerator<QuestionConfigDTO> {
    //Delimiter used in CSV file
    protected static final String DELIMITER = ";";
    protected static final String NEW_LINE_SEPARATOR = "\n";
    protected static final String MODIFIED_BY = "liquibase";
    protected static final String MODIFIED_ON = "2016-01-11 07:59:14.822";
    //CSV file header
    private final String FILE_HEADER;
    protected ApplicationContext applicationContext;

    public QuestioncsvGenerator(String FILE_HEADER, ApplicationContext applicationContext) {
        this.FILE_HEADER = FILE_HEADER;
        this.applicationContext = applicationContext;
    }

    @Override
    public String generate(List<QuestionConfigDTO> rowContents, String fullFileName) throws FileNotFoundException {
        Resource resource = applicationContext.getResource("classpath:" + fullFileName);
        /*if(!resource.exists()) {
            resource.cre
            throw new FileNotFoundException();
        }*/
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(resource.getFilename());
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            writeContents(fileWriter, rowContents);
        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        return fullFileName;
    }

    protected abstract void writeContents(FileWriter fileWriter, List<QuestionConfigDTO> rowContents) throws IOException;
}
