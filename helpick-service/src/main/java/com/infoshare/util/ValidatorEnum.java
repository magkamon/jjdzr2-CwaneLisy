package com.infoshare.util;

public enum ValidatorEnum {
    ALPHA("[a-zA-Z]+", "Dozwolone tylko litery"),
    POLISHSIGNS("[a-zA-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ -]+", "Dozwolone tylko litery"),
    PHONENUMBER("^\\d{9}$", "Błędny numer, dozwolone 9 cyfr"),
    EMAIL("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,9}$", "Poprawny format to: ktos@gdzies.com"),
    YESNO("[yYnN]", "Dozwolone znaki to Y lub N");
    String regex;
    String errorMessage;

    ValidatorEnum(String regex, String errorMessage) {
        this.regex = regex;
        this.errorMessage = errorMessage;
    }

    public String getRegex() {
        return regex;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
