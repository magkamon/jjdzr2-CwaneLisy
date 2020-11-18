package com.infoshare.database;

import com.infoshare.domain.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class FileDbTest {

    public FileDbTest(){
    }
    public static void main(String[] args) throws IOException, ParseException {
        DB fileDb = new FileDb();
        PersonInNeed personInNeed = new PersonInNeed("Basia", "Gdańsk",
                "500300700");
        PersonInNeed personInNeed1 = new PersonInNeed("Rafał", "Elblag",
                "800456789");
        PersonInNeed personInNeed2 = new PersonInNeed("Magda", "porun",
                "636536");
        PersonInNeed personInNeed3 = new PersonInNeed("Magdal", "porun",
                "636536");

        NeedRequest needRequest = new NeedRequest(TypeOfHelp.WALKING_THE_DOG, HelpStatuses.NEW, new Date(),
                personInNeed);
        NeedRequest needRequest1 = new NeedRequest(TypeOfHelp.SHOPPING, HelpStatuses.INPROGRESS, new Date(),
                personInNeed1);
        NeedRequest needRequest2 = new NeedRequest(TypeOfHelp.HOUSE_HELP, HelpStatuses.DONE, new Date(),
                personInNeed2);
        NeedRequest needRequest3 = new NeedRequest(TypeOfHelp.HOUSE_HELP, HelpStatuses.DONE, new Date(),
                personInNeed3);



        Volunteer volunteer = new Volunteer("Piotr", "Gdańsk", "Piotr@.wp.pl", "7865",
                TypeOfHelp.HOUSE_HELP
                 , true);
        Volunteer volunteer1 = new Volunteer("Paweł", "Poznań", "Paweł@.o2.pl", "7423",
                TypeOfHelp.SHOPPING, true);
        Volunteer volunteer2 = new Volunteer("Kasia", "Warszawa", "Kasia@.ll",
               "2123", TypeOfHelp.HOUSE_HELP, true);
        Volunteer volunteer3 = new Volunteer("Ala","kopot","kaweł@.o2.pl","987556"
                ,TypeOfHelp.HOUSE_HELP,true);
        Volunteer volunteer4 = new Volunteer("olaf","kyopot","laweł@.o2.pl","987556"
                ,TypeOfHelp.SHOPPING,true);
        Volunteer volunteer5 = new Volunteer("damian","UUUopot","maweł@.o2.pl","987556"
                ,TypeOfHelp.HOUSE_HELP,true);
        Volunteer volunteer6 = new Volunteer("ola","DUPA","maweł@.o2.pl","987556"
                ,TypeOfHelp.HOUSE_HELP,true);
        Volunteer volunteer7 = new Volunteer("Kamila","Radom","Kamila.o2.pl","000000022"
                ,TypeOfHelp.SHOPPING,true);

        fileDb.saveVolunteer(volunteer);
        fileDb.saveVolunteer(volunteer1);
        fileDb.saveVolunteer(volunteer2);
        fileDb.saveVolunteer(volunteer3);
        fileDb.saveVolunteer(volunteer4);
        fileDb.saveVolunteer(volunteer5);
        fileDb.saveVolunteer(volunteer6);
        fileDb.saveVolunteer(volunteer7);
        fileDb.saveNeedRequest(needRequest);
        fileDb.saveNeedRequest(needRequest1);
        //System.out.println(fileDb.getVolunteers());
      //  System.out.println(fileDb.getAllNeedRequests());
    }
}



