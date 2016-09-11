package com.qph.restdemo.service.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quocphan on 9/11/2016.
 */
public class QuestionConfigResultDTO {
    private Integer rowsAttempt;
    private List<String> errorDesc = new ArrayList<String>();

    public Integer getRowsAttempt() {
        return rowsAttempt;
    }

    public void setRowsAttempt(Integer rowsAttempt) {
        this.rowsAttempt = rowsAttempt;
    }

    public List<String> getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(List<String> errorDesc) {
        this.errorDesc = errorDesc;
    }
}
