package com.infoshare.service;

import com.infoshare.domain.GlobalLists;
import com.infoshare.domain.Volunteer;
import com.infoshare.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ChangeVolunteerStatusService {

    public void handleVolunteerStatusChange(){
        List<Volunteer> volunteerList =new ArrayList<>(GlobalLists.INSTANCE.getVolunteerMap().values());
        displayVolunteers(volunteerList);
        GlobalLists.INSTANCE.updateVolunteer(changeVolunteerStatus(volunteerList));
    }

    private void displayVolunteers(List<Volunteer> volunteerList){

        for (Volunteer volunteer: volunteerList) {
            System.out.println(((volunteer.isAvailable())?"\u001B[32m":"\u001B[31m")+(volunteerList.indexOf(volunteer)+1)+
                    ". Imie: "+volunteer.getName()+"\n Lokalizacja: "+volunteer.getLocation()+"\n Typ pomocy: "+volunteer.getTypeOfHelp().getTypeOfHelp()+
                    "\n Dostepny: "+((volunteer.isAvailable())? " Tak" : "Nie"));
        }
        System.out.println("\u001B[0m");
    }

    private Volunteer changeVolunteerStatus(List<Volunteer> volunteerList) {
        int number = Util.readNumberFromUser("Wybierz wolontariusza ",
                volunteerList.size());
        Volunteer volunteer = volunteerList.get(number-1);
        volunteer.setAvailable(!volunteer.isAvailable());
        System.out.println("Zmienilismy status na "+ (volunteer.isAvailable()? "Dostepny" : "Zajety"));
        return volunteer;
    }
}
