package com.qph.restdemo.service.report.dto;

import java.util.List;

/**
 * Created by quocphan on 10/13/2016.
 */
public class ReportSvcDTO {

    private String userName;
    private String contentFont;
    private String saqResultsTitle;
    private SiteDetails siteDetail;
    private WorkerNumberList workerNumberList;
    private List<SaqResultsList> saqResultsList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SiteDetails getSiteDetail() {
        return siteDetail;
    }

    public void setSiteDetail(SiteDetails siteDetail) {
        this.siteDetail = siteDetail;
    }

    public WorkerNumberList getWorkerNumberList() {
        return workerNumberList;
    }

    public void setWorkerNumberList(WorkerNumberList workerNumberList) {
        this.workerNumberList = workerNumberList;
    }

    public List<SaqResultsList> getSaqResultsList() {
        return saqResultsList;
    }

    public void setSaqResultsList(List<SaqResultsList> saqResultsList) {
        this.saqResultsList = saqResultsList;
    }

    public String getContentFont() {
        return contentFont;
    }

    public void setContentFont(String contentFont) {
        this.contentFont = contentFont;
    }

    public String getSaqResultsTitle() {
        return saqResultsTitle;
    }

    public void setSaqResultsTitle(String saqResultsTitle) {
        this.saqResultsTitle = saqResultsTitle;
    }
}
