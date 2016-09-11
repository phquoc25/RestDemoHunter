package com.qph.restdemo.service.dto;

/**
 * Created by quocphan on 9/11/2016.
 */
public class QuestionConfigDTO {
    private String questionCode;
    private String sectionName;
    private String subsectionName;
    private String subsectionCode;
    private String questionName;
    private String questionType;
    private String answer;
    private String agricultureLarge;
    private String intermediate;
    private String manufact;
    private String serviceProvider;
    private String agricultureSmall;
    private String heavyEngineering;
    private String officeHQ;

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSubsectionName() {
        return subsectionName;
    }

    public void setSubsectionName(String subsectionName) {
        this.subsectionName = subsectionName;
    }

    public String getSubsectionCode() {
        return subsectionCode;
    }

    public void setSubsectionCode(String subsectionCode) {
        this.subsectionCode = subsectionCode;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAgricultureLarge() {
        return agricultureLarge;
    }

    public void setAgricultureLarge(String agricultureLarge) {
        this.agricultureLarge = agricultureLarge;
    }

    public String getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(String intermediate) {
        this.intermediate = intermediate;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getAgricultureSmall() {
        return agricultureSmall;
    }

    public void setAgricultureSmall(String agricultureSmall) {
        this.agricultureSmall = agricultureSmall;
    }

    public String getHeavyEngineering() {
        return heavyEngineering;
    }

    public void setHeavyEngineering(String heavyEngineering) {
        this.heavyEngineering = heavyEngineering;
    }

    public String getOfficeHQ() {
        return officeHQ;
    }

    public void setOfficeHQ(String officeHQ) {
        this.officeHQ = officeHQ;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionConfigDTO{");
        sb.append("questionCode='").append(questionCode).append('\'');
        sb.append(", sectionName='").append(sectionName).append('\'');
        sb.append(", subsectionName='").append(subsectionName).append('\'');
        sb.append(", subsectionCode='").append(subsectionCode).append('\'');
        sb.append(", questionName='").append(questionName).append('\'');
        sb.append(", questionType='").append(questionType).append('\'');
        sb.append(", answer='").append(answer).append('\'');
        sb.append(", agricultureLarge='").append(agricultureLarge).append('\'');
        sb.append(", intermediate='").append(intermediate).append('\'');
        sb.append(", manufact='").append(manufact).append('\'');
        sb.append(", serviceProvider='").append(serviceProvider).append('\'');
        sb.append(", agricultureSmall='").append(agricultureSmall).append('\'');
        sb.append(", heavyEngineering='").append(heavyEngineering).append('\'');
        sb.append(", officeHQ='").append(officeHQ).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
