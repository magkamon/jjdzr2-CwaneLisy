package com.infoshare;

import java.util.Scanner;

public class UserRegistration {
    private static final String REGISTRATION_HEADER = "[Witaj w programie do rejestracji]";
    private static final String REGISTRATION_USERNAME = "Podaj imie/nickname: ";
    private static final String REGISTRATION_LOCATION = "Podaj swoją lokalizację: ";
    private static final String REGISTRATION_PHONE_NUMBER = "Podaj numer telefonu: ";
    private static final String REGISTRATION_EMAIL = "Podaj e-mail";
    private static final String REGISTRATION_HELP_TYPE = "W czym możesz pomóc innym, wybierz z listy: ";

    private String getUserName(){
        System.out.println(REGISTRATION_USERNAME);
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        return username;
    }

    private String getLocation(){
        System.out.println(REGISTRATION_LOCATION);
        Scanner sc = new Scanner(System.in);
        String location = sc.nextLine();
        return location;
    }

    private String getPhoneNumber(){
        System.out.println(REGISTRATION_PHONE_NUMBER);
        Scanner sc = new Scanner(System.in);
        String telNumber = sc.nextLine();
        return telNumber;
    }

    private String getEmail(){
        System.out.println(REGISTRATION_EMAIL);
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        return email;
    }

    private String getHelpType(){
        System.out.println(REGISTRATION_HELP_TYPE);
        Scanner sc = new Scanner(System.in);
        String helpType = sc.nextLine();
        return helpType;
    }


    public void register(){
        System.out.println(REGISTRATION_HEADER);

        NewUser newUser = new NewUser();
        newUser.username = getUserName();
        newUser.location = getLocation();
        newUser.telNumber = getPhoneNumber();
        newUser.email = getEmail();
        newUser.helpType = getHelpType();

        SavingUtil.saveToFile("/home/magda/workspace/Helpik/jjdzr2-CwaneLisy/registeredUsers", newUser);


    }


}
