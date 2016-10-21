package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.dto.QuestionConfigDTO;
import com.qph.restdemo.service.dto.QuestionConfigField;
import com.qph.restdemo.service.dto.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by quocphan on 9/11/2016.
 */
@Service
public class QuestionSubsectionCsvGenerator extends QuestioncsvGenerator{

    public static final String FALSE = "FALSE";

    @Autowired
    public QuestionSubsectionCsvGenerator(ApplicationContext applicationContext) {
        super("sort_index;question_code;subsection_code;type;text;version;modified_by;modified_on;mandatory", applicationContext);
    }

    @Override
    protected void writeContents(FileWriter fileWriter, List<QuestionConfigDTO> rowContents) throws IOException {
        for (int i = 0; i < rowContents.size(); i++){
            QuestionConfigDTO configDTO = rowContents.get(i);
            //append sort_index
            fileWriter.append(String.valueOf(i+1));
            fileWriter.append(DELIMITER);
            fileWriter.append(configDTO.getQuestionCode());
            fileWriter.append(DELIMITER);
            fileWriter.append(configDTO.getSubsectionCode());
            fileWriter.append(DELIMITER);
            QuestionType questionType = QuestionConfigField.getQuestionType(configDTO.getQuestionType().toLowerCase());
            fileWriter.append(String.valueOf(questionType.getType()));
            fileWriter.append(DELIMITER);
            fileWriter.append(configDTO.getQuestionName());
            fileWriter.append(DELIMITER);
            fileWriter.append(String.valueOf(0));
            fileWriter.append(DELIMITER);
            fileWriter.append(MODIFIED_BY);
            fileWriter.append(DELIMITER);
            fileWriter.append(MODIFIED_ON);
            fileWriter.append(DELIMITER);
            fileWriter.append(FALSE);
            fileWriter.append(NEW_LINE_SEPARATOR);
        }
    }
}
