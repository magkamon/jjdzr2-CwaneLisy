package com.infoshare;

import com.infoshare.database.FileDb;
import com.infoshare.domain.Volunteer;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

import java.io.IOException;
import java.util.Scanner;

public class UserRegistration {
    private static final String REGISTRATION_HEADER = "[Witaj w programie do rejestracji]";
    private static final String REGISTRATION_EMAIL = "Podaj e-mail";
    private static final String REGISTRATION_AVAILABILITY = "Czy jesteś dostępny [Y/N]? ";

    private static Scanner sc = new Scanner(System.in);

    private static FileDb fileDb = new FileDb();

    public static void register() {
        System.out.println(REGISTRATION_HEADER);
        Volunteer newVolunteer = new Volunteer(
                Util.readDataFromConsole(Util.REGISTRATION_NAME,ValidatorEnum.ALPHA),
                Util.readDataFromConsole(Util.REGISTRATION_LOCATION,ValidatorEnum.ALPHA ),
                Util.readDataFromConsole(REGISTRATION_EMAIL, ValidatorEnum.EMAIL),
                Util.readDataFromConsole(Util.REGISTRATION_PHONE_NUMBER, ValidatorEnum.PHONENUMBER),
                Util.createTypeOfHelp(),
                (Util.readDataFromConsole(REGISTRATION_AVAILABILITY, ValidatorEnum.YESNO).toUpperCase().equals("Y"))?
                        true:false

        );
       // SavingUtil.saveToFile("../registeredVolunteer", newVolunteer);

        try {
            fileDb.saveVolunteer(newVolunteer);
        } catch (IOException ex) {
            System.out.println("Coś poszło nietak");
        }

    }



}
