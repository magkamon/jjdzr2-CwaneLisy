package com.infoshare.view;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.service.VolunteerService;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;


public class VolunteerRegistrationView {
    private static final String REGISTRATION_HEADER = "[Witaj w programie do rejestracji]";
    private static final String REGISTRATION_EMAIL = "Podaj e-mail";
    private static final String REGISTRATION_AVAILABILITY = "Czy jesteś dostępny [Y/N]? ";
    private static final String REGISTRATION_ERROR = "*** Rejestracja nie powiodła się *** Podany adres e-mail już istnieje w bazie danych. ";
    VolunteerService volunteerService;


    public VolunteerRegistrationView(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    public void showVolunteerRegisterMenu() {
        System.out.println(REGISTRATION_HEADER);
        String name = Util.readDataFromConsole(Util.REGISTRATION_NAME, ValidatorEnum.ALPHA);
        String location = Util.readDataFromConsole(Util.REGISTRATION_LOCATION, ValidatorEnum.ALPHA);
        String email = Util.readDataFromConsole(REGISTRATION_EMAIL, ValidatorEnum.EMAIL).toLowerCase();
        String phone = Util.readDataFromConsole(Util.REGISTRATION_PHONE_NUMBER, ValidatorEnum.PHONENUMBER);
        TypeOfHelp typeOfHelp = Util.createTypeOfHelp();
        boolean available = Util.readDataFromConsole(REGISTRATION_AVAILABILITY, ValidatorEnum.YESNO).equalsIgnoreCase("Y");

        boolean isRegistrationSuccess = volunteerService.registerNewVolunteer(name, location, email, phone, typeOfHelp, available);
        if (!isRegistrationSuccess) {
            System.out.println(REGISTRATION_ERROR);
        }
    }
}



