package com.infoshare;

import java.util.Scanner;

public class UserRegistration {
    private static final String REGISTRATION_HEADER = "[Witaj w programie do rejestracji]";
    private static final String REGISTRATION_USERNAME = "Podaj imie/nickname: ";
    private static final String REGISTRATION_LOCATION = "Podaj swoją lokalizację: ";
    private static final String REGISTRATION_PHONE_NUMBER = "Podaj numer telefonu: ";
    private static final String REGISTRATION_EMAIL = "Podaj e-mail";
    private static final String REGISTRATION_HELP_TYPE = "W czym możesz pomóc innym, wybierz z listy: ";



    public void register(){

        System.out.println(REGISTRATION_HEADER);

        System.out.println(REGISTRATION_USERNAME);
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        System.out.println(REGISTRATION_LOCATION);
        String location = sc.nextLine();

        System.out.println(REGISTRATION_PHONE_NUMBER);
        String telNumber = sc.nextLine();

        System.out.println(REGISTRATION_EMAIL);
        String email = sc.nextLine();

        System.out.println(REGISTRATION_HELP_TYPE);
        String helpType = sc.nextLine();

        NewUser newUser = new NewUser();
        newUser.username = username;
        newUser.location = location;
        newUser.telNumber = telNumber;
        newUser.email = email;
        newUser.helpType = helpType;

        SavingUtil.saveToFile("/home/magda/workspace/Helpik/jjdzr2-CwaneLisy/registeredUsers", newUser);


    }



}
