package com.infoshare.domain;

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
}
