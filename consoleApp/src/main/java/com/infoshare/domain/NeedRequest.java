package com.infoshare.domain;

import java.time.Duration;
import java.util.Date;

public class NeedRequest {
    String name;
    String location;
    String phone;
    String typeOfHelp;
    HelpStatuses helpStatus;
    Date statusChange;

    public NeedRequest() {
    }

    public NeedRequest(String name, String location, String phone, String typeOfHelp, HelpStatuses helpStatus,
                       Date statusChange) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.typeOfHelp = typeOfHelp;


        if(statusChange.before(Date.from(new Date().toInstant().minus(Duration.ofHours(24))))
                && helpStatus==HelpStatuses.INPROGRESS){
            this.helpStatus=HelpStatuses.NEW;
            this.statusChange=new Date();
        } else {
            this.helpStatus = helpStatus;
            this.statusChange = statusChange;
        }

    }
}
