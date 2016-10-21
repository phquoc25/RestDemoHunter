package com.qph.restdemo.service.dto;

/**
 * Created by quocphan on 9/11/2016.
 */
public enum  Sector {
    AGRI_LARGE("BIGAGRI", "Agri (L)"),
    INTERME("INTERMEDI","Intermediaries"),
    MANUFACT("MANUFACT","Manufacturing"),
    SERVICE_P("SERVPROV","SPs"),
    AGRI_SMALL("SMALLAGRI","Agri (S)"),
    HEAVY_EN("HEAVMANU","Heavy Eng"),
    OFFICE_HQ("OFFICEHQ","HQ")
    ;

    private String code;
    private String name;
    Sector(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }
}
