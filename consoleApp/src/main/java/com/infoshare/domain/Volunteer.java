package com.infoshare.domain;

import java.util.Objects;

public class Volunteer {
    private String name;
    private String location;
    private String email;
    private String phone;
    private String typeOfHelp;
    private boolean isAvailable;

    public Volunteer(String name, String location, String email, String phone, String typeOfHelp, boolean isAvailable) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.typeOfHelp = typeOfHelp;
        this.isAvailable = isAvailable;
    }

    public Volunteer() {
    }

    @Override
    public String toString() {
        return "Volunteer{" + "name='" + name + '\'' + ", location='" + location + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", typeOfHelp='" + typeOfHelp + '\'' + ", isAvailable=" + isAvailable + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volunteer volunteer = (Volunteer) o;
        return isAvailable == volunteer.isAvailable && name.equals(volunteer.name) && location
                .equals(volunteer.location) && email.equals(volunteer.email) && phone
                .equals(volunteer.phone) && typeOfHelp.equals(volunteer.typeOfHelp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, email, phone, typeOfHelp, isAvailable);
    }
}
