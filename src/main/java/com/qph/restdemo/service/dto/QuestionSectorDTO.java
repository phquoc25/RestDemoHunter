package com.qph.restdemo.service.dto;

/**
 * Created by quocphan on 9/11/2016.
 */
public class QuestionSectorDTO {
    private String questionCode;
    private String sectorCode;
    private String version;
    private String modifiedBy;
    private String modifiedOn;

    public QuestionSectorDTO() {
    }

    public QuestionSectorDTO(QuestionSectorDTO dto) {
        this.questionCode = dto.getQuestionCode();
        this.sectorCode = dto.getSectorCode();
        this.version = dto.getVersion();
        this.modifiedBy = dto.getModifiedBy();
        this.modifiedOn = dto.getModifiedOn();
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
