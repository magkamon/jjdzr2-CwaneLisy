package com.infoshare;

import com.infoshare.database.DummyDB;
import com.infoshare.domain.GlobalLists;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;
import org.junit.Test;

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
        GlobalLists.INSTANCE.setStorage(new DummyDB());

        GlobalLists.INSTANCE.addVolunteer(volunteer);
        GlobalLists.INSTANCE.addVolunteer(volunteer1);
        GlobalLists.INSTANCE.addVolunteer(volunteer2);
        GlobalLists.INSTANCE.addVolunteer(volunteer3);
        GlobalLists.INSTANCE.addVolunteer(volunteer4);
        GlobalLists.INSTANCE.addVolunteer(volunteer5);
        GlobalLists.INSTANCE.addVolunteer(volunteer6);

        assertEquals(6,GlobalLists.INSTANCE.getVolunteerMap().size());

    }

    @Test
    public void shouldUpdateVolunteer(){
        GlobalLists.INSTANCE.setStorage(new DummyDB());
        GlobalLists.INSTANCE.addVolunteer(volunteer);
        Volunteer updated = new Volunteer(volunteer.getUuid(), volunteer.getName(), "Warszawa", volunteer.getEmail(),
                "", TypeOfHelp.SHOPPING, false);
        GlobalLists.INSTANCE.updateVolunteer(updated);
        assertEquals("Warszawa", GlobalLists.INSTANCE.getVolunteerMap().get(volunteer.getUuid()).getLocation());
    }
}
