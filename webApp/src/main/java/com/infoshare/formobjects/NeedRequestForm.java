package com.infoshare.formobjects;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.util.ValidatorEnum;
import com.infoshare.validator.RegExpPattern;

public class NeedRequestForm {
    @RegExpPattern(regexp = ValidatorEnum.POLISHSIGNS)
    private String name;
    @RegExpPattern(regexp = ValidatorEnum.POLISHSIGNS)
    private String location;
    @RegExpPattern(regexp = ValidatorEnum.PHONENUMBER)
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
