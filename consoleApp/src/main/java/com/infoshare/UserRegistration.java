package com.infoshare;

import com.infoshare.domain.Volunteer;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

import java.util.Scanner;

public class UserRegistration {
    private static final String REGISTRATION_HEADER = "[Witaj w programie do rejestracji]";
    private static final String REGISTRATION_NAME = "Podaj imie/nickname (min 3 znaki): ";
    private static final String REGISTRATION_LOCATION = "Podaj swoją lokalizację (bez polskich znaków): ";
    private static final String REGISTRATION_PHONE_NUMBER = "Podaj numer telefonu: ";
    private static final String REGISTRATION_EMAIL = "Podaj e-mail";
    private static final String REGISTRATION_AVAILABILITY = "Czy jesteś dostępny [Y/N]? ";

    private static Scanner sc = new Scanner(System.in);

    public static void register(){
        System.out.println(REGISTRATION_HEADER);
        Volunteer newVolunteer = new Volunteer(
                Util.readDataFromConsole(REGISTRATION_NAME,ValidatorEnum.ALPHA),
                Util.readDataFromConsole(REGISTRATION_LOCATION,ValidatorEnum.ALPHA ),
                Util.readDataFromConsole(REGISTRATION_EMAIL, ValidatorEnum.EMAIL),
                Util.readDataFromConsole(REGISTRATION_PHONE_NUMBER, ValidatorEnum.PHONENUMBER),
                Util.createTypeOfHelp(),
                (Util.readDataFromConsole(REGISTRATION_AVAILABILITY, ValidatorEnum.YESNO).toUpperCase().equals("Y"))?
                        true:false

        );
        SavingUtil.saveToFile("../registeredVolunteer", newVolunteer);

    }



}
