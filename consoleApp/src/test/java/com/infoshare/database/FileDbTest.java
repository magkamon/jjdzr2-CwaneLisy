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
      //  PersonInNeed personInNeed = new PersonInNeed("Basia", "gdans", "ww@.oo", "2233");
       // PersonInNeed personInNeed1 = new PersonInNeed("przemek", "elblag", "hhh#@.ll", "345");
       // PersonInNeed personInNeed2 = new PersonInNeed("magda", "torun", "tt@ll.c", "636536");

       // NeedRequest needRequest = new NeedRequest(TypeOfHelp.HOUSE_HELP, HelpStatuses.NEW, new Date(), personInNeed);
       // NeedRequest needRequest1 = new NeedRequest(TypeOfHelp.SHOPPING, HelpStatuses.INPROGRESS, new Date(), personInNeed1);
       // NeedRequest needRequest2 = new NeedRequest(TypeOfHelp.HOUSE_HELP, HelpStatuses.DONE, new Date(), personInNeed2);

      // fileDb.saveNeedRequest(needRequest);
      //  fileDb.saveNeedRequest(needRequest1);
      //  fileDb.saveNeedRequest(needRequest2);

       // Volunteer volunteer = new Volunteer("Piotr", "gdańsk", "piotr@.wp.pl", "7865"
                //, "SHOPPING", true);
       //Volunteer volunteer1 = new Volunteer("pawe", "Poznan", "ooiotr@.wp.pl", "7423",
              //  "HOUSE HELP", true);
      //  Volunteer volunteer2 = new Volunteer("Kasia", "Wawa","ppp@.ll",
                //"2123","Shopping", true);


        List list = new ArrayList<>(); // wyswietlanie z pliku uzytkownikow volontariat,
        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("/home/przemek/Pulpit/tmp/" +
                "jjdzr2-CwaneLisy/consoleApp/Volunteer.csv"))) {
            list = bufferedReader.lines().collect(Collectors.toList());

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        list.forEach(System.out::println);



        List <String> list1 = new ArrayList<>();// wyswietlanie z pliku osob potrzebujacych
        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("/home/przemek/Pulpit/tmp/" +
                "jjdzr2-CwaneLisy/consoleApp/NeedRequest.csv"))) {
            list1 = bufferedReader.lines().collect(Collectors.toList());
            for(int i = 0; i<list1.size(); i++) {
                String line = list1.get(i);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        list1.forEach(System.out::println);


    }
}



