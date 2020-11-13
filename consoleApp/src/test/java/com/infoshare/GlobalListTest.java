package com.infoshare;

import com.infoshare.domain.GlobalLists;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GlobalListTest {
    private Set<Volunteer> volunteerSet= new HashSet<>();

    @Test
    public void shouldHaveThreeVolunteers(){
        //GlobalLists.INSTANCE.setStorage(new DummyDB());
        long start = System.nanoTime();
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

        for (int i = 0; i < 10000; i++) {
            volunteerSet.add(volunteer);
        }
        volunteerSet.add(volunteer);
        volunteerSet.add(volunteer1);
        volunteerSet.add(volunteer2);
        volunteerSet.add(volunteer3);
        volunteerSet.add(volunteer4);
        volunteerSet.add(volunteer5);
        volunteerSet.add(volunteer6);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Elapsed time "+elapsedTime);

        assertEquals(0,GlobalLists.INSTANCE.getVolunteerList().size());

    }
}
