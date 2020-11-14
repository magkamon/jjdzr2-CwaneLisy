package com.infoshare.domain;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class NeedRequest {
    private UUID uuid;
    private TypeOfHelp typeOfHelp;
    private HelpStatuses helpStatus;
    private Date statusChange;
    private PersonInNeed personInNeed;


    public NeedRequest() {
    }


    public NeedRequest(UUID uuid, TypeOfHelp typeOfHelp, HelpStatuses helpStatus, Date statusChange,
                       PersonInNeed personInNeed) {
        this.uuid = uuid;
        this.typeOfHelp = typeOfHelp;
        this.helpStatus = helpStatus;
        this.statusChange = statusChange;
        this.personInNeed = personInNeed;
    }

    public NeedRequest(TypeOfHelp typeOfHelp, PersonInNeed personInNeed) {
        this.uuid=UUID.randomUUID();
        this.typeOfHelp = typeOfHelp;
        this.helpStatus = HelpStatuses.NEW;
        this.statusChange = new Date();
        this.personInNeed = personInNeed;
    }


    public TypeOfHelp getTypeOfHelp() {
        return typeOfHelp;
    }

    public void setTypeOfHelp(TypeOfHelp typeOfHelp) {
        this.typeOfHelp = typeOfHelp;
    }

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

    public PersonInNeed getPersonInNeed() {
        return personInNeed;
    }

    public void setPersonInNeed(PersonInNeed personInNeed) {
        this.personInNeed = personInNeed;
    }

    @Override
    public String toString() {
        return "NeedRequest{" + "typeOfHelp=" + typeOfHelp + ", helpStatus=" + helpStatus + ", statusChange=" + statusChange + ", personInNeed=" + personInNeed + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NeedRequest that = (NeedRequest) o;
        return typeOfHelp == that.typeOfHelp && helpStatus == that.helpStatus && statusChange
                .equals(that.statusChange) && personInNeed.equals(that.personInNeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfHelp, helpStatus, statusChange, personInNeed);
    }

    public UUID getUuid() {
        return uuid;
    }
}

