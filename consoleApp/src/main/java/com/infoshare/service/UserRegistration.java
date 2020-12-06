package com.infoshare.service;

import com.infoshare.database.FileDb;
import com.infoshare.domain.Volunteer;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

import java.io.IOException;

public class UserRegistration {
    private static final String REGISTRATION_HEADER = "[Witaj w programie do rejestracji]";
    private static final String REGISTRATION_EMAIL = "Podaj e-mail";
    private static final String REGISTRATION_AVAILABILITY = "Czy jesteś dostępny [Y/N]? ";
    private static final String REGISTRATION_ERROR = "*** Rejestracja nie powiodła się *** Podany adres e-mail już istnieje w bazie danych. ";

    public void register(){
        System.out.println(REGISTRATION_HEADER);
        Volunteer newVolunteer = new Volunteer(
                Util.readDataFromConsole(Util.REGISTRATION_NAME,ValidatorEnum.ALPHA),
                Util.readDataFromConsole(Util.REGISTRATION_LOCATION,ValidatorEnum.ALPHA ),
                Util.readDataFromConsole(REGISTRATION_EMAIL, ValidatorEnum.EMAIL).toLowerCase(),
                Util.readDataFromConsole(Util.REGISTRATION_PHONE_NUMBER, ValidatorEnum.PHONENUMBER),
                Util.createTypeOfHelp(),
                Util.readDataFromConsole(REGISTRATION_AVAILABILITY, ValidatorEnum.YESNO).toUpperCase().equals("Y")
        );
        try{
            FileDb database = new FileDb();
            if(database.getVolunteer(newVolunteer.getEmail()) == null ){
                database.saveVolunteer(newVolunteer);
            }
            else {
                System.out.println(REGISTRATION_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
