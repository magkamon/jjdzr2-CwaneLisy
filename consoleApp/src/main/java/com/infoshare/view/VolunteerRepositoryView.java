package com.infoshare.view;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;
import com.infoshare.service.VolunteerService;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

import java.util.List;


public class VolunteerRepositoryView {
    private static final String CITY_CHOOSE_HEADER = "Z jakiego miasta chcesz wyszukac wolontariuszy?";
    VolunteerService volunteerService;

    public VolunteerRepositoryView(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    public void showAvailableVolunteer() {
        String city = Util.readDataFromConsole(CITY_CHOOSE_HEADER, ValidatorEnum.POLISHSIGNS);
        TypeOfHelp typeOfHelp = Util.createTypeOfHelp();
        List<Volunteer> filteredList = volunteerService.printFilteredList(city, typeOfHelp);
        if (filteredList.isEmpty()) {
            System.out.println("Brak dostępnych wolontariuszy");
        } else {
            for (Volunteer volunteer : filteredList) {
                System.out.println(volunteer.printDescription());
            }
        }
    }
}
