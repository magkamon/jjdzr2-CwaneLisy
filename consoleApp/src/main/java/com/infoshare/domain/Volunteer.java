package com.infoshare.domain;

import java.util.Objects;
import java.util.UUID;

public class Volunteer {
    private UUID uuid;
    private String name;
    private String location;
    private String email;
    private String phone;
    private TypeOfHelp typeOfHelp;
    private boolean isAvailable;

    public Volunteer(String name, String location, String email, String phone, TypeOfHelp typeOfHelp, boolean isAvailable) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.typeOfHelp = typeOfHelp;
        this.isAvailable = isAvailable;
    }

    public Volunteer(UUID uuid, String name, String location, String email, String phone, TypeOfHelp typeOfHelp,
                     boolean isAvailable) {
        this.uuid = uuid;
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.typeOfHelp = typeOfHelp;
        this.isAvailable = isAvailable;
    }

    public Volunteer() {

    }


    public boolean dataEquals(Volunteer v){
        return name.equals(v.name) && location
                .equals(v.location) && email.equals(v.email) && phone
                .equals(v.phone) && typeOfHelp.equals(v.typeOfHelp);
    }

    @Override
    public String toString() {
        return "Volunteer{" + "uuid=" + uuid + ", name='" + name + '\'' + ", location='" + location + '\'' + ", email" +
                "='" + email + '\'' + ", phone='" + phone + '\'' + ", typeOfHelp=" + typeOfHelp + ", isAvailable=" + isAvailable + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volunteer volunteer = (Volunteer) o;
        return isAvailable == volunteer.isAvailable && Objects.equals(uuid, volunteer.uuid) && Objects
                .equals(name, volunteer.name) && Objects.equals(location, volunteer.location) && Objects
                .equals(email, volunteer.email) && Objects
                .equals(phone, volunteer.phone) && typeOfHelp == volunteer.typeOfHelp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, location, email, phone, typeOfHelp, isAvailable);
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

    public TypeOfHelp getTypeOfHelp() {
        return typeOfHelp;
    }

    public void setTypeOfHelp(TypeOfHelp typeOfHelp) {
        this.typeOfHelp = typeOfHelp;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public UUID getUuid() {
        return uuid;
    }

}
