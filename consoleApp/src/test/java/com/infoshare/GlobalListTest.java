package com.infoshare;

import com.infoshare.database.DummyStorage;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;
import com.infoshare.persistence.Persistence;
import com.infoshare.persistence.PersistenceImplementation;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GlobalListTest {
    private Set<Volunteer> volunteerSet= new HashSet<>();
    Volunteer volunteer = new Volunteer("Piotr", "Gdańsk", "Piotr@.wp.pl", "7865", TypeOfHelp.SHOPPING, true);
    Volunteer volunteer1 = new Volunteer("Paweł", "Poznań", "Paweł@.o2.pl", "7423",
            TypeOfHelp.HOUSE_HELP, true);
    Volunteer volunteer2 = new Volunteer("Kasia", "Warszawa", "Kasia@.ll",
            "2123", TypeOfHelp.WALKING_THE_DOG, true);
    Volunteer volunteer3 = new Volunteer("Kasia","Warszawa","Kasia@.ll","2123"
            ,TypeOfHelp.WALKING_THE_DOG,false);
    Volunteer volunteer4 = new Volunteer("Ala","kyopot","laweł@.o2.pl","987556"
            ,TypeOfHelp.SHOPPING,true);
    Volunteer volunteer5 = new Volunteer("Ala","popot","maweł@.o2.pl","987556"
            ,TypeOfHelp.SHOPPING,true);
    Volunteer volunteer6 = new Volunteer("Ala","UUopot","maweł@.o2.pl","987556"
            ,TypeOfHelp.SHOPPING,true);

    @Test
    public void shouldHaveSixVolunteers(){
        Persistence persistence=new PersistenceImplementation(new DummyStorage(),new HashMap<>(),new HashMap<>());


        persistence.addVolunteer(volunteer);
        persistence.addVolunteer(volunteer1);
        persistence.addVolunteer(volunteer2);
        persistence.addVolunteer(volunteer3);
        persistence.addVolunteer(volunteer4);
        persistence.addVolunteer(volunteer5);
        persistence.addVolunteer(volunteer6);

        assertEquals(6,persistence.getVolunteerMap().size());

    }

    @Test
    public void shouldUpdateVolunteer(){
        Persistence persistence=new PersistenceImplementation(new DummyStorage(),new HashMap<>(),new HashMap<>());
        persistence.addVolunteer(volunteer);
        Volunteer updated = new Volunteer(volunteer.getUuid(), volunteer.getName(), "Warszawa", volunteer.getEmail(),
                "", TypeOfHelp.SHOPPING, false);
        persistence.updateVolunteer(updated);
        assertEquals("Warszawa", persistence.getVolunteerMap().get(volunteer.getUuid()).getLocation());
    }
}
