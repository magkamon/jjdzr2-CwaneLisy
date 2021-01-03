package com.infoshare.service;

import com.infoshare.database.DB;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VolunteerService {

    DB db;

    @Autowired
    public VolunteerService(DB db) {
        this.db = db;
    }

    public List<Volunteer> getVolunteerFilteredList(String city, TypeOfHelp typeOfHelp) {
        return db.getVolunteers().stream()
            .filter(Volunteer::isAvailable)
            .filter(v -> v.getLocation().equalsIgnoreCase(city))
            .filter(v -> v.getTypeOfHelp().equals(typeOfHelp))
            .collect(Collectors.toList());
    }

    public Volunteer searchForVolunteer(String email) {
        return db.getVolunteer(email);
    }

    public boolean updateAvailability(Volunteer volunteer) {
        if (volunteer != null) {
            volunteer.setAvailable(!volunteer.isAvailable());
            db.saveVolunteer(volunteer);
            return true;
        } else {
            return false;
        }
    }

    public boolean registerNewVolunteer(String name, String location, String email, String phone, TypeOfHelp typeOfHelp,
        boolean availability) {
        Volunteer newVolunteer = new Volunteer(name, location, email, phone, typeOfHelp, availability);
        if (db.getVolunteer(newVolunteer.getEmail()) == null) {
            db.saveVolunteer(newVolunteer);
            return true;
        } else {
            return false;
        }
    }

}
