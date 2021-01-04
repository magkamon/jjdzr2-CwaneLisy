package com.infoshare.validator;

public class FormValidator {
    public static final String  ALPHA = "[a-zA-Z]+";
    public static final String  ALPHA_ERROR = "Dozwolone tylko litery";
    public static final String  POLISHSIGNS = "[a-zA-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ]+";
    public static final String  POLISHSIGNS_ERROR = "Dozwolone tylko litery";
    public static final String  PHONENUMBER = "^\\d{9}$";
    public static final String  PHONENUMBER_ERROR = "Nieprawidłowy numer telefonu, dozwolone 9 cyfr";
    public static final String  EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final String  EMAIL_ERROR = "Poprawny format to: ktos@gdzies.com";
    public static final String  YESNO = "[yYnN]";
    public static final String  YESNO_ERROR = "Dozwolone znaki to Y lub N";

    private FormValidator() {
    }
}
