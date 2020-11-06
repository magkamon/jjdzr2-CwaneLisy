package com.infoshare.database;

import com.infoshare.domain.*;
import org.junit.runner.Request;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileDbTest {

    public FileDbTest() throws IOException {
    }
    public static void main(String[] args) throws IOException, ParseException {
        DB fileDb = new FileDb();
        PersonInNeed personInNeed = new PersonInNeed("Basia", "Gdańsk", "Basia@kk.pl",
                "500300700");
        PersonInNeed personInNeed1 = new PersonInNeed("Rafał", "Elblag", "Rafał@ll.pl",
                "800456789");
        PersonInNeed personInNeed2 = new PersonInNeed("Magda", "Torun", "Magda@ii.pl",
                "636536");

        NeedRequest needRequest = new NeedRequest(TypeOfHelp.WALKING_THE_DOG, HelpStatuses.NEW, new Date(),
                personInNeed);
        NeedRequest needRequest1 = new NeedRequest(TypeOfHelp.SHOPPING, HelpStatuses.INPROGRESS, new Date(),
                personInNeed1);
        NeedRequest needRequest2 = new NeedRequest(TypeOfHelp.HOUSE_HELP, HelpStatuses.DONE, new Date(),
                personInNeed2);

        fileDb.saveNeedRequest(needRequest);
        fileDb.saveNeedRequest(needRequest1);
        fileDb.saveNeedRequest(needRequest2);

        Volunteer volunteer = new Volunteer("Piotr", "Gdańsk", "Piotr@.wp.pl", "7865",
                 "SHOPPING", true);
        Volunteer volunteer1 = new Volunteer("Paweł", "Poznań", "Paweł@.o2.pl", "7423",
                "HOUSE HELP", true);
        Volunteer volunteer2 = new Volunteer("Kasia", "Warszawa", "Kasia@.ll",
               "2123", "Walking the Dog", true);
        Volunteer volunteer3 = new Volunteer("Ala","kopot","kaweł@.o2.pl","987556"
                ,"SHOPPING",true);
        Volunteer volunteer4 = new Volunteer("Ala","kyopot","laweł@.o2.pl","987556"
                ,"SHOPPING",true);
        Volunteer volunteer5 = new Volunteer("Ala","popot","maweł@.o2.pl","987556"
                ,"SHOPPING",true);
        Volunteer volunteer6 = new Volunteer("Ala","UUopot","maweł@.o2.pl","987556"
                ,"SHOPPING",true);

        fileDb.saveVolunteer(volunteer);
        fileDb.saveVolunteer(volunteer1);
        fileDb.saveVolunteer(volunteer2);
        fileDb.saveVolunteer(volunteer3);
        fileDb.saveVolunteer(volunteer4);
        fileDb.saveVolunteer(volunteer5);
        fileDb.saveVolunteer(volunteer6);
        System.out.println(fileDb.getVolunteers());
        System.out.println(fileDb.getAllNeedRequests());
    }
}


