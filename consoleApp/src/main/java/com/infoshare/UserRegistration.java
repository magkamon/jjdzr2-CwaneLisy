package com.infoshare;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserRegistration {
    private static final String REGISTRATION_HEADER = "[Witaj w programie do rejestracji]";
    private static final String REGISTRATION_NAME = "Podaj imie/nickname (min 3 znaki): ";
    private static final String REGISTRATION_LOCATION = "Podaj swoją lokalizację (bez polskich znaków): ";
    private static final String REGISTRATION_PHONE_NUMBER = "Podaj numer telefonu: ";
    private static final String REGISTRATION_EMAIL = "Podaj e-mail";
    private static final String REGISTRATION_HELP_TYPE = "W czym możesz pomóc innym, wybierz z listy: ";
    private static final String REGISTRATION_AVAILABILITY = "Czy jesteś dostępny [Y/N]? ";
    private static final String REGISTRATION_ERROR = "***BŁĄD***";

    private static Scanner sc = new Scanner(System.in);

    public static void register(){
        System.out.println(REGISTRATION_HEADER);
        Volunteer newVolunteer = new Volunteer(
                getVolunteerName(),
                getLocation(),
                getEmail(),
                getPhoneNumber(),
                getHelpType(),
                getAvailability()
        );
        SavingUtil.saveToFile("../registeredVolunteer", newVolunteer);

    }

    private static String getVolunteerName(){
        System.out.println(REGISTRATION_NAME);
        String username = sc.nextLine();
        if(username.length() > 2){
            return username;
        }else {
            System.out.println(REGISTRATION_ERROR);
            return getVolunteerName();
        }
    }

    private static String getLocation(){
        System.out.println(REGISTRATION_LOCATION);
        String location = sc.nextLine();
        if(isAlpha(location)){
            return location;
        }else {
            System.out.println(REGISTRATION_ERROR);
            return getLocation();
        }
    }

    private static String getPhoneNumber(){
        System.out.println(REGISTRATION_PHONE_NUMBER);
        String phone = sc.nextLine();
        if (isNumber(phone)) {
            return phone;
        } else {
            System.out.println(REGISTRATION_ERROR);
            return getPhoneNumber();
        }
    }

    private static String getEmail(){
        System.out.println(REGISTRATION_EMAIL);
        String email = sc.nextLine();
        if(isEmailValid(email)){
            return email;
        }else {
            System.out.println(REGISTRATION_ERROR);
            return getEmail();
        }
    }

    private static TypeOfHelp getHelpType(){
        int helpType = 0;
        boolean isGood = false;
        TypeOfHelp[] typeOfHelpArray = TypeOfHelp.values();
        do {
            System.out.println(REGISTRATION_HELP_TYPE);
            for (int i = 0; i < typeOfHelpArray.length; i++) {
                System.out.println((i + 1) + " - " + typeOfHelpArray[i].getTypeOfHelp());
            }
            try{
                Scanner sc = new Scanner(System.in);
                helpType = sc.nextInt();
            }catch (InputMismatchException exception){
                helpType = 0;
            }
            if (helpType > 0 && helpType < typeOfHelpArray.length + 1) {
                isGood = true;
                helpType = helpType - 1;
            } else {
                System.out.println(REGISTRATION_ERROR);
            }
        }while (!isGood);
        return typeOfHelpArray[helpType];
    }

    private static boolean getAvailability(){
        System.out.println(REGISTRATION_AVAILABILITY);
        Scanner sc = new Scanner(System.in);
        String availability = sc.nextLine();
        if (availability.equals("Y")){
            return true;
        } else if (availability.equals("N")){
            return false;
        }
        else {
            System.out.println(REGISTRATION_ERROR);
            return getAvailability();
        }
    }

    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private static boolean isNumber(String number){
        return number.matches("[0-9]+");
    }

    private static boolean isEmailValid(String email) { return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"); }


}
