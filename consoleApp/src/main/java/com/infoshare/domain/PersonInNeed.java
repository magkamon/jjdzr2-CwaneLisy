package com.infoshare.domain;

import java.util.Objects;

public class PersonInNeed {
    private String name;
    private String location;
    private String email;
    private String phone;

    public PersonInNeed(String name, String location, String email, String phone) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInNeed that = (PersonInNeed) o;
        return name.equals(that.name) && location.equals(that.location) && email.equals(that.email) && phone
                .equals(that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, email, phone);
    }

    @Override
    public String toString() {
        return "PersonInNeed{" + "name='" + name + '\'' + ", location='" + location + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
