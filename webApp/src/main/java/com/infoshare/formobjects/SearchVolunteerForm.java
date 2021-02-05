package com.infoshare.formobjects;

import com.infoshare.util.ValidatorEnum;
import com.infoshare.validator.RegExpPattern;
import com.infoshare.validator.IsMailRegistered;

public class SearchVolunteerForm {
    @RegExpPattern(regexp = ValidatorEnum.EMAIL)
    @IsMailRegistered
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
