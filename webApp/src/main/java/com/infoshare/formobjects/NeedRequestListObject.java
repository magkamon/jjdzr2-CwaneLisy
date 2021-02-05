package com.infoshare.formobjects;

import com.infoshare.domain.HelpStatuses;
import com.infoshare.domain.TypeOfHelp;

import java.util.Date;
import java.util.UUID;

public class NeedRequestListObject {

    private String name;
    private String location;
    private String phone;
    private TypeOfHelp typeOfHelp;
    private UUID uuid;
    private HelpStatuses helpStatus;
    private Date statusChange;

    public HelpStatuses getHelpStatus() {
        return helpStatus;
    }

    public void setHelpStatus(HelpStatuses helpStatus) {
        this.helpStatus = helpStatus;
    }

    public Date getStatusChange() {
        return statusChange;
    }

    public void setStatusChange(Date statusChange) {
        this.statusChange = statusChange;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TypeOfHelp getTypeOfHelp() {
        return typeOfHelp;
    }

    public void setTypeOfHelp(TypeOfHelp typeOfHelp) {
        this.typeOfHelp = typeOfHelp;
    }


    public static final class NeedRequestListObjectBuilder {
        private String name;
        private String location;
        private String phone;
        private TypeOfHelp typeOfHelp;
        private UUID uuid;
        private HelpStatuses helpStatus;
        private Date statusChange;

        private NeedRequestListObjectBuilder() {
        }

        public static NeedRequestListObjectBuilder aNeedRequestListObject() {
            return new NeedRequestListObjectBuilder();
        }

        public NeedRequestListObjectBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public NeedRequestListObjectBuilder withLocation(String location) {
            this.location = location;
            return this;
        }

        public NeedRequestListObjectBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public NeedRequestListObjectBuilder withTypeOfHelp(TypeOfHelp typeOfHelp) {
            this.typeOfHelp = typeOfHelp;
            return this;
        }

        public NeedRequestListObjectBuilder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public NeedRequestListObjectBuilder withHelpStatus(HelpStatuses helpStatus) {
            this.helpStatus = helpStatus;
            return this;
        }

        public NeedRequestListObjectBuilder withStatusChange(Date statusChange) {
            this.statusChange = statusChange;
            return this;
        }

        public NeedRequestListObject build() {
            NeedRequestListObject needRequestListObject = new NeedRequestListObject();
            needRequestListObject.setName(name);
            needRequestListObject.setLocation(location);
            needRequestListObject.setPhone(phone);
            needRequestListObject.setTypeOfHelp(typeOfHelp);
            needRequestListObject.setUuid(uuid);
            needRequestListObject.setHelpStatus(helpStatus);
            needRequestListObject.setStatusChange(statusChange);
            return needRequestListObject;
        }
    }
}
