package com.infoshare.service;

import com.infoshare.database.FileDb;
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

    private static final String CITY_CHOOSE_HEADER = "Z jakiego miasta wyświetlić zgłoszenia pomocy?";
    FileDb fileDb = new FileDb();

    public void printFilteredList(){
        String inputCity = Util.readDataFromConsole(CITY_CHOOSE_HEADER, ValidatorEnum.POLISHSIGNS);
        TypeOfHelp inputType = Util.createTypeOfHelp();
        try {
            List<NeedRequest> activeNeedRequests = fileDb.getNeedRequests();
            List<NeedRequest> filteredList;
            filteredList = activeNeedRequests.stream().
                    filter(req -> req.getHelpStatus().equals(HelpStatuses.NEW)).
                    filter(req -> req.getPersonInNeed().getLocation().equalsIgnoreCase(inputCity)).
                    filter(req -> req.getTypeOfHelp().equals(inputType)).
                    collect(Collectors.toList());
            if (filteredList.isEmpty()) {
                System.out.println("Brak zgłoszeń pomocy o zadanych parametrach");
            }
            else {
                for (NeedRequest needRequest : filteredList) {
                    needRequest.printDescription();
                    }
                }
            }
        catch(FileNotFoundException | ParseException e){
                e.printStackTrace();
            }
        }
}
