package com.qph.restdemo.common;

import org.springframework.http.HttpStatus;

/**
 * Created by quocphan on 10/22/2016.
 */
public enum RestErrors implements TranslatableToRestError {
    NOT_ALLOW_DUPLICATE_TRIGGER_QUESTION("Not allow duplicate trigger question", HttpStatus.BAD_REQUEST),
    NOT_ALLOW_DUPLICATE_NAME("Not allow duplicate data on name field", HttpStatus.BAD_REQUEST),
    MODULE_NOT_FOUND("admin.module.code.notfound", HttpStatus.NOT_FOUND),
    SECTION_NOT_FOUND("admin.section.code.notfound", HttpStatus.NOT_FOUND),
    SECTION_LABEL_NOT_FOUND("admin.section.label.notfound", HttpStatus.NOT_FOUND),
    SECTION_NAME_DUPLICATED("questionnaires.saq.sectionname.exist", HttpStatus.BAD_REQUEST),
    SUBSECTION_NAME_DUPLICATED("questionnaires.saq.subsectionname.exist", HttpStatus.BAD_REQUEST),
    LANGUAGE_UNSUPPORTED("admin.language.code.unsupported", HttpStatus.BAD_REQUEST),
    QUESTION_TYPE_UNSUPPORTED("admin.question.type.unsupported", HttpStatus.BAD_REQUEST),
    SUB_SECTION_NOT_FOUND("admin.subsection.code.notfound", HttpStatus.NOT_FOUND),
    SUB_SECTION_LABEL_NOT_FOUND("admin.subsection.label.notfound", HttpStatus.NOT_FOUND),
    QUESTION_NOT_FOUND("admin.question.code.notfound", HttpStatus.NOT_FOUND),
    QUESTION_CODE_INVALID("admin.question.code.invalid", HttpStatus.BAD_REQUEST),
    STALE_ANSWER("The following questions have been already answered by the listed users: %s", HttpStatus.CONFLICT),
    STALE_QUESTION("Question is stale", HttpStatus.CONFLICT),
    ORG_NOT_FOUND("The organisation was not found", HttpStatus.NOT_FOUND),
    ORG_CANNOT_ANSWER_NON_GLOBAL_QUESTIONS("Organisation cannot answer non-global questions", HttpStatus.UNPROCESSABLE_ENTITY),
    ANSWER_READ_ONLY("Answer is read-only", HttpStatus.UNPROCESSABLE_ENTITY),
    ANSWERS_MODIFIED_BY_EMPTY("Modified by field was not provided", HttpStatus.UNPROCESSABLE_ENTITY),
    USER_DATA_NOT_PRESENT("The user data was missing from the header", HttpStatus.BAD_REQUEST),
    MODULE_NAME_DUPICATED("questionnaires.saq.modulename.exist", HttpStatus.BAD_REQUEST),
    MODULE_ASSOCIATED_NOT_FOUND("questionnaires.saq.association.notfound", HttpStatus.NOT_FOUND),
    MODULE_ASSOCIATED_EXIST("questionnaires.saq.association.exist", HttpStatus.BAD_REQUEST),
    MODULE_DEFAULT_LABEL_MISSING("questionnaires.saq.module.message.defaultlanguage", HttpStatus.BAD_REQUEST),
    SITE_SEARCHING_INPUT_INVALID("questionnaires.saq.module.searchingInputInvalid", HttpStatus.BAD_REQUEST),
    SITE_CONDITION_QUERIES_INPUT_INVALID("questionnaires.saq.module.messageConditionInvalid", HttpStatus.BAD_REQUEST),
    MODULE_UPLOAD_FILE_INVALID_EXTENSION("The excel format ( xls or xlsx ) required", HttpStatus.BAD_REQUEST),
    MODULE_UPLOAD_PARSING_FAILURE("There were errors during parsing file, please check log for more details", HttpStatus.BAD_REQUEST),
    DOWNLOAD_FORMAT_NOT_SUPPORTED("Download format file is not supported", HttpStatus.BAD_REQUEST);

    RestErrors(String errorMessage, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    private HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public RestError toRestError() {
        return new RestError(this.name(), errorMessage, httpStatus);
    }

    public RestError toRestError(Object... params) {
        return new RestError(this.name(), String.format(errorMessage, params), httpStatus);
    }
}