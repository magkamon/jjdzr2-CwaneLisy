package com.infoshare.domain;

public class Volunteer {
    String name;
    String location;
    String email;
    String phone;
    String typeOfHelp;
    boolean isAvailable;

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
}
