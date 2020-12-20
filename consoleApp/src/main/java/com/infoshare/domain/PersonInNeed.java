package com.infoshare.domain;

import java.util.Objects;
import java.util.UUID;

public class PersonInNeed {
    private String name;
    private String location;
    private String phone;
    private UUID ID;

    public PersonInNeed(String name, String location, String phone, UUID ID) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.ID = ID;
    }

    public PersonInNeed() {

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

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInNeed that = (PersonInNeed) o;
        return name.equals(that.name) && location.equals(that.location) && phone
                .equals(that.phone) && ID.equals(that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, phone, ID);
    }

    @Override
    public String toString() {
        return "PersonInNeed{" + "name='" + name + '\'' + ", location='" + location + '\'' + '\'' + ", phone='"
                + phone + ", ID" + ID + '\'' + '}';
    }
}
