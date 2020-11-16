package com.infoshare.service;

import com.infoshare.domain.Volunteer;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

public class VolunteerAvailability {

    private static final String AVAILABILITY_HEADER = "Czy chcesz zmienić swoją dostępność? [ Y / N ] ";
    private static final String AVAILABILITY_STATUS = "Twoj obecny status w systemie to: ";
    private static final String GET_EMAIL = "Podaj adres e-mail podany podczas rejestracji";
    private static final String STATUS_AVAILABLE = "DOSTĘPNY";
    private static final String STATUS_UNAVAILABLE = "NIEDOSTĘPNY";

    public static void changeAvailability(Volunteer volunteer){
        System.out.println(AVAILABILITY_STATUS);
        System.out.println(volunteer.isAvailable() ? STATUS_AVAILABLE : STATUS_UNAVAILABLE);
        String data = Util.readDataFromConsole(AVAILABILITY_HEADER, ValidatorEnum.YESNO);
        if (data.equalsIgnoreCase("Y")){
            if(volunteer.isAvailable()){
                volunteer.setAvailable(false);
            }else {
                volunteer.setAvailable(true);
            }
        }
    }

    public static void updateAvailability(){
        // FileDb database = new FileDb();
//        String email = Util.readDataFromConsole(GET_EMAIL, ValidatorEnum.EMAIL);
//        Volunteer volunteerToUpdate = database.getVolunteer(email);
//        if(volunteerToUpdate != null){
//            changeAvailability(volunteerToUpdate);
//            database.saveVolunteer(volunteerToUpdate);
//        }
    }
}
