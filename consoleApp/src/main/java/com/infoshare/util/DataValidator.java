package com.infoshare.util;

import com.infoshare.App;

public class DataValidator {


    public static boolean isDataValid(String data, ValidatorEnum regex) {

        return Config.IS_VALIDATOR_ENABLED.getBooleanValue() ? data.matches(regex.getRegex()) : true;
    }
}

