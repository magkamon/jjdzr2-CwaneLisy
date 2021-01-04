package com.infoshare.formobjects;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.validator.FormValidator;

import javax.validation.constraints.Pattern;

public class NeedRequestForm {
    @Pattern(regexp = FormValidator.POLISHSIGNS, message = FormValidator.POLISHSIGNS_ERROR)
    private String name;
    @Pattern(regexp = FormValidator.POLISHSIGNS, message = FormValidator.POLISHSIGNS_ERROR)
    private String location;
    @Pattern(regexp = FormValidator.PHONENUMBER, message = FormValidator.PHONENUMBER_ERROR)
    private String phone;
    private TypeOfHelp typeOfHelp;

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
}
