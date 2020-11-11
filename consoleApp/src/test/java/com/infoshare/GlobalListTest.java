package com.infoshare;

import com.infoshare.domain.GlobalLists;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GlobalListTest {
    @Test
    public void shouldHaveThreeVolunteers(){
        Volunteer volunteer = new Volunteer("Piotr", "Gdańsk", "Piotr@.wp.pl", "7865", TypeOfHelp.SHOPPING, true);
        Volunteer volunteer1 = new Volunteer("Paweł", "Poznań", "Paweł@.o2.pl", "7423",
                TypeOfHelp.HOUSE_HELP, true);
        Volunteer volunteer2 = new Volunteer("Kasia", "Warszawa", "Kasia@.ll",
                "2123", TypeOfHelp.WALKING_THE_DOG, true);
        Volunteer volunteer3 = new Volunteer("Kasia","Warszawa","Kasia@.ll","2123"
                ,TypeOfHelp.WALKING_THE_DOG,false);


        GlobalLists.INSTANCE.addVolunteer(volunteer);
        GlobalLists.INSTANCE.addVolunteer(volunteer1);
        GlobalLists.INSTANCE.addVolunteer(volunteer2);
        GlobalLists.INSTANCE.addVolunteer(volunteer3);

        assertEquals(3,GlobalLists.INSTANCE.getVolunteerList().size());

    }
}
