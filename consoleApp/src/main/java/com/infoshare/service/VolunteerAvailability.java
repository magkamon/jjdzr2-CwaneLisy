package com.infoshare.service;

import com.infoshare.database.FileDb;
import com.infoshare.domain.Volunteer;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;
import java.io.IOException;

public class VolunteerAvailability {

    private static final String AVAILABILITY_HEADER = "Czy chcesz zmienić swoją dostępność? [ Y / N ] ";
    private static final String AVAILABILITY_STATUS = "Twoj obecny status w systemie to: ";
    private static final String AVAILABILITY_STATUS_UPDATE = "Twoj status został zmieniony na: ";
    private static final String GET_EMAIL = "Podaj adres e-mail podany podczas rejestracji";
    private static final String STATUS_AVAILABLE = "DOSTĘPNY";
    private static final String STATUS_UNAVAILABLE = "NIEDOSTĘPNY";
    private static final String EMAIL_UNKNOWN = "Podany e-mail nie jest zarejestrowany w bazie danych";

    private void changeAvailability(Volunteer volunteer){
        System.out.println(AVAILABILITY_STATUS);
        System.out.println(volunteer.isAvailable() ? STATUS_AVAILABLE : STATUS_UNAVAILABLE);
        String data = Util.readDataFromConsole(AVAILABILITY_HEADER, ValidatorEnum.YESNO);
        if (data.equalsIgnoreCase("Y")){
            volunteer.setAvailable(!volunteer.isAvailable());
            System.out.println(AVAILABILITY_STATUS_UPDATE);
            System.out.println(volunteer.isAvailable() ? STATUS_AVAILABLE : STATUS_UNAVAILABLE);
        }
    }

    public void updateAvailability() {
        try {
            FileDb database = new FileDb();
            String email = Util.readDataFromConsole(GET_EMAIL, ValidatorEnum.EMAIL).toLowerCase();
            Volunteer volunteerToUpdate = database.getVolunteer(email);
            if(volunteerToUpdate != null){
                changeAvailability(volunteerToUpdate);
                database.saveVolunteer(volunteerToUpdate);
            } else {
                System.out.println(EMAIL_UNKNOWN);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
