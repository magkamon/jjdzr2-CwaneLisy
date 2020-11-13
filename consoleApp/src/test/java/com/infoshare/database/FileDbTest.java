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
import java.time.DateTimeException;
import java.util.*;
import java.util.stream.Collectors;

public class FileDbTest {

    public FileDbTest() throws IOException {
    }
    public static void main(String[] args) throws IOException, ParseException {
        DB fileDb = new FileDb();
        PersonInNeed personInNeed = new PersonInNeed("Basia", "Gdańsk",
                "500300700");
        PersonInNeed personInNeed1 = new PersonInNeed("Rafał", "Elblag",
                "800456789");
        PersonInNeed personInNeed2 = new PersonInNeed("Magda", "Torun",
                "636536");

        NeedRequest needRequest = new NeedRequest(TypeOfHelp.WALKING_THE_DOG, HelpStatuses.NEW, new Date(),
                personInNeed);
        NeedRequest needRequest1 = new NeedRequest(TypeOfHelp.SHOPPING, HelpStatuses.INPROGRESS, new Date(),
                personInNeed1);
        NeedRequest needRequest2 = new NeedRequest(TypeOfHelp.HOUSE_HELP, HelpStatuses.DONE, new Date(),
                personInNeed2);
        List<NeedRequest> needRequestList= new ArrayList<>();
        needRequestList.add(needRequest);
        needRequestList.add(needRequest1);
        needRequestList.add(needRequest2);
        fileDb.saveNeedRequest(needRequestList);

        Volunteer volunteer = new Volunteer("Piotr", "Gdańsk", "Piotr@.wp.pl", "7865", TypeOfHelp.SHOPPING, true);
        Volunteer volunteer1 = new Volunteer("Paweł", "Poznań", "Paweł@.o2.pl", "7423",
                TypeOfHelp.HOUSE_HELP, true);
        Volunteer volunteer2 = new Volunteer("Kasia", "Warszawa", "Kasia@.ll",
               "2123", TypeOfHelp.WALKING_THE_DOG, true);
        Volunteer volunteer3 = new Volunteer("Ala","kopot","kaweł@.o2.pl","987556"
                ,TypeOfHelp.SHOPPING,true);
        Volunteer volunteer4 = new Volunteer("Ala","kyopot","laweł@.o2.pl","987556"
                ,TypeOfHelp.SHOPPING,true);
        Volunteer volunteer5 = new Volunteer("Ala","popot","maweł@.o2.pl","987556"
                ,TypeOfHelp.SHOPPING,true);
        Volunteer volunteer6 = new Volunteer("Ala","UUopot","maweł@.o2.pl","987556"
                ,TypeOfHelp.SHOPPING,true);

        Set<Volunteer> volunteerSet= new HashSet<>();
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
        long start = System.nanoTime();
        System.out.println("Start :"+start);
        for (int i = 0; i < 10000; i++) {
            fileDb.saveVolunteer(volunteerSet);
        }

        long elapsedTime = System.nanoTime() - start;
        System.out.println("Elapsed time "+elapsedTime);
        System.out.println(fileDb.getVolunteers());
        System.out.println(fileDb.getAllNeedRequests());
    }
}



