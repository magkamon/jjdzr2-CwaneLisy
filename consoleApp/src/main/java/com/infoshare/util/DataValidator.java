package com.infoshare.util;

import com.infoshare.App;

public class DataValidator {


    public static boolean isDataValid(String data, ValidatorEnum regex) {

        return App.isValidatorEnabled ? data.matches(regex.getRegex()) : true;
    }
}

