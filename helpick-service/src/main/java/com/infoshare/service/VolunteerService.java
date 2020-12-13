package com.infoshare.service;

import com.infoshare.database.FileDb;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class VolunteerService {


    public List<Volunteer> printFilteredList(String city, TypeOfHelp typeOfHelp) {
        FileDb fileDb = new FileDb();

        List<Volunteer> availableVolunteers = fileDb.getVolunteers();
        List<Volunteer> filteredList;
        filteredList = availableVolunteers.stream().
                filter(Volunteer::isAvailable).
                filter(v -> v.getLocation().equalsIgnoreCase(city)).
                filter(v -> v.getTypeOfHelp().equals(typeOfHelp)).
                collect(Collectors.toList());
        return filteredList;

    }

    public Volunteer searchForVolunteeer(String email) {
        FileDb database = new FileDb();
        return database.getVolunteer(email);
    }

    public boolean updateAvailability(Volunteer volunteer) {
        FileDb database = new FileDb();
        if (volunteer != null) {
            volunteer.setAvailable(!volunteer.isAvailable());
            database.saveVolunteer(volunteer);
            return true;
        } else {
            return false;
        }
    }
    public boolean registerNewVolunteer(String name, String location, String email, String phone, TypeOfHelp typeOfHelp, boolean availability) {

        Volunteer newVolunteer = new Volunteer(name, location, email, phone, typeOfHelp, availability);
        FileDb database = new FileDb();
        if (database.getVolunteer(newVolunteer.getEmail()) == null) {
            database.saveVolunteer(newVolunteer);
            return true;
        } else {
            return false;
        }
    }

}
