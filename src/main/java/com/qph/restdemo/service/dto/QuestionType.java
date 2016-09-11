package com.qph.restdemo.service.dto;

public enum QuestionType {
    FREE_TEXT(2),
    NUMERIC(4),
    DATE(1),
    SINGLE_CHOICE(5),
    MULTIPLE_CHOICE(3),
    ATTACHMENT(6),
    DERIVED(7);

    private int type;
    QuestionType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
