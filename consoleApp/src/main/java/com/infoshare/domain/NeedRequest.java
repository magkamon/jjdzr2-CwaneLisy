package com.infoshare.domain;

import java.time.Duration;
import java.util.Date;

public class NeedRequest {
    private String name;
    private String location;
    private String phone;
    private String typeOfHelp;
    private HelpStatuses helpStatus;


    public NeedRequest() {
    }

    public NeedRequest(String name, String location, String phone, String typeOfHelp, HelpStatuses helpStatus,
                       Date statusChange) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.typeOfHelp = typeOfHelp;


    }

    @Override
    public String toString() {
        return "NeedRequest{" + "name='" + name + '\'' + ", location='" + location + '\'' + ", phone='" + phone + '\'' + ", typeOfHelp='" + typeOfHelp + '\'' + ", helpStatus=" + helpStatus + '}';
    }
}
