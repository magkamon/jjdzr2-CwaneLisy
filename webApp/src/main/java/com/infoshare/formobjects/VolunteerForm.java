package com.infoshare.formobjects;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.util.ValidatorEnum;
import com.infoshare.validator.RegExpPattern;

import javax.validation.constraints.Size;

public class VolunteerForm {
    @RegExpPattern(regexp = ValidatorEnum.POLISHSIGNS)
    @Size(min = 2, max = 20)
    private String name;
    @Size(min = 2, max = 20)
    @RegExpPattern(regexp = ValidatorEnum.POLISHSIGNS)
    private String location;
    @Size(min = 2, max = 20)
    @RegExpPattern(regexp = ValidatorEnum.EMAIL)
    private String email;
    @Size(min = 2, max = 20)
    @RegExpPattern(regexp = ValidatorEnum.PHONENUMBER)
    private String phone;
    private TypeOfHelp typeOfHelp;
    private  boolean isAvalible;





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

    public void setTypeOfHelp() {
    }

    public boolean isAvalible() {
        return isAvalible;
    }

}
