package com.infoshare.service;

import com.infoshare.domain.*;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NeedRequestRepository {

    private static final String DB_FILE = "NeedRequest.csv";
    private static final String CITY_CHOOSE_HEADER = "Z jakiego miasta wyświetlić zgłoszenia pomocy?";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void printFilteredList(){
        String inputCity = Util.readDataFromConsole(CITY_CHOOSE_HEADER, ValidatorEnum.ALPHA);
        TypeOfHelp inputType = Util.createTypeOfHelp();
        List <NeedRequest> availableVolunteers = readFromFile();
        List<NeedRequest> filteredList;
        filteredList = availableVolunteers.stream().
                filter(req -> req.getHelpStatus().equals(HelpStatuses.NEW)).
                filter(req -> req.getPersonInNeed().getLocation().equalsIgnoreCase(inputCity)).
                filter(req -> req.getTypeOfHelp().equals(inputType)).
                collect(Collectors.toList());
        if (filteredList.isEmpty()){
            System.out.println("Brak zgłoszeń pomocy o zadanych parametrach");
        }
        else {
            for (NeedRequest needRequest : filteredList) {
                System.out.println(needRequest.toString());
            }
        }
    }

    private List<NeedRequest> readFromFile () {
        List<NeedRequest> needRequestsList = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File(DB_FILE));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splited = line.split(",");
                NeedRequest needRequest = new NeedRequest(TypeOfHelp.valueOf(splited[0]), HelpStatuses.valueOf(splited[1]),
                        DATE_FORMAT.parse(splited[2]), new PersonInNeed(splited[3],splited[4], splited[5]));
                needRequestsList.add(needRequest);
            }
        } catch (FileNotFoundException | ParseException e) {
            System.out.println("Brak pliku z danymi, sprawdź lokalizację pliku.");
        }
        return needRequestsList;
    }

}
