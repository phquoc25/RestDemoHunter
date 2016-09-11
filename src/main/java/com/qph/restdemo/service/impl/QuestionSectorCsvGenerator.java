package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.dto.QuestionConfigDTO;
import com.qph.restdemo.service.dto.QuestionSectorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quocphan on 9/11/2016.
 */
@Service
public class QuestionSectorCsvGenerator extends QuestioncsvGenerator{

    @Autowired
    public QuestionSectorCsvGenerator(ApplicationContext applicationContext) {
        super("question_code;sector_code;version;modified_by;modified_on", applicationContext);
    }

    @Override
    protected void writeContents(FileWriter fileWriter, List<QuestionConfigDTO> rowContents) throws IOException {
        rowContents.stream().forEach(rowContent -> {
            List<QuestionSectorDTO> questionSectorDTOs = new ArrayList<>();
            QuestionSectorDTO questionSectorDTO = new QuestionSectorDTO();
            questionSectorDTO.setVersion(String.valueOf(0));
            questionSectorDTO.setModifiedOn(MODIFIED_ON);
            questionSectorDTO.setModifiedBy(MODIFIED_BY);
            questionSectorDTO.setQuestionCode(rowContent.getQuestionCode());
            if (!StringUtils.isEmpty(rowContent.getAgricultureLarge())){

            }
        });
    }
}
