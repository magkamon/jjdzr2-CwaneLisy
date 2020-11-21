package com.infoshare.service;

import com.infoshare.database.FileDb;
import com.infoshare.domain.*;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class NeedRequestService {

    public void changeRequestStatus() {
        FileDb fileDb = new FileDb();
        String inputCity = Util.readDataFromConsole("CITY_CHOOSE_HEADER", ValidatorEnum.POLISHSIGNS);
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
                for (int i = 0; i < filteredList.size(); i++){
                    System.out.println(i + ". " + filteredList.get(i));
                }
                System.out.println("Którego zgłoszenia chcesz się podjąć?");
                int choice = new Scanner(System.in).nextInt();
                filteredList.get(choice).setHelpStatus(HelpStatuses.INPROGRESS);
                filteredList.get(choice).setStatusChange(new Date());
                NeedRequest changedRequest = filteredList.get(choice);
                int index = 0;
                for (int i = 0; i < activeNeedRequests.size(); i++) {
                    NeedRequest nr = activeNeedRequests.get(i);
                    if (nr.equals(changedRequest)) {
                        index = i;
                        System.out.println(index);
                    }
                }
                activeNeedRequests.set(index, changedRequest);
                FileWriter writer = new FileWriter("NeedRequest.csv", false);
                for (NeedRequest nr : activeNeedRequests) {
                    fileDb.saveNeedRequest(nr);
                }
                writer.flush();

            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

    }
    public void updateRequestsStatus(){
        FileDb fileDb = new FileDb();
        try {
            List<NeedRequest> activeNeedRequests = fileDb.getNeedRequests();
            for (NeedRequest request: activeNeedRequests) {
                Date time1 = request.getStatusChange();
                Date actualTime = new Date();
                long diff = actualTime.getTime() - time1.getTime();
                long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
                if (request.getHelpStatus().equals(HelpStatuses.INPROGRESS) &&
                        minutes > 1440) {
                    System.out.println("Roznica wiecej niz 24h, zmieniam status");
                    request.setHelpStatus(HelpStatuses.NEW);
                    request.setStatusChange(new Date());
                }
            }
            FileWriter writer = new FileWriter("NeedRequest.csv", false);
            for (NeedRequest nr : activeNeedRequests) {
                fileDb.saveNeedRequest(nr);
            }
            writer.flush();

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

    }

    public void createNeedRequest() {
        PersonInNeed personInNeed=createPersonInNeed();
        TypeOfHelp typeOfHelp= Util.createTypeOfHelp();
        NeedRequest needRequest=new NeedRequest(typeOfHelp, HelpStatuses.NEW,new Date(),personInNeed);
        try {
            new FileDb().saveNeedRequest(needRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PersonInNeed createPersonInNeed() {
        String name= Util.readDataFromConsole(Util.REGISTRATION_NAME, ValidatorEnum.ALPHA);
        String location=Util.readDataFromConsole(Util.REGISTRATION_LOCATION, ValidatorEnum.ALPHA);
        String phone=Util.readDataFromConsole(Util.REGISTRATION_PHONE_NUMBER, ValidatorEnum.PHONENUMBER);

        return new PersonInNeed(name,location,phone);
    }

}
