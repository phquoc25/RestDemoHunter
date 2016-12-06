package com.qph.restdemo.common;

/**
 * Created by quocphan on 10/22/2016.
 */
public enum  InterfaceType {
    REPORT_LOG("report_log");

    private String interfaceName;
    InterfaceType(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
}
