package com.infoshare.service;

import com.infoshare.database.DB;
import com.infoshare.database.FileDb;
import com.infoshare.domain.HelpStatuses;
import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.PersonInNeed;
import com.infoshare.domain.TypeOfHelp;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NeedRequestService {

    DB db;

    @Autowired
    public NeedRequestService(DB db) {
        this.db = db;
    }

    public void createNeedRequest(String name, String location, String phone, TypeOfHelp typeOfHelp) {
        PersonInNeed personInNeed = new PersonInNeed(name, location, phone);
        NeedRequest needRequest = NeedRequest
            .create(typeOfHelp, personInNeed);
        db.saveNeedRequest(needRequest);
    }

    public List<NeedRequest> getNeedRequestFilteredList(String city, TypeOfHelp typeOfHelp) {
        return db.getNeedRequests().stream()
            .filter(n -> n.getHelpStatus().equals(HelpStatuses.NEW))
            .filter(n -> n.getTypeOfHelp().equals(typeOfHelp))
            .filter(n -> n.getPersonInNeed().getLocation().equalsIgnoreCase(city))
            .collect(Collectors.toList());
    }
    public Optional<NeedRequest>getNeedRequestById(UUID uuid){
      return db.getNeedRequests().stream()
      .filter(n->n.getUuid().equals(uuid))
      .findAny();
    }
    public List<NeedRequest> getAllNeedRequests(){
       return db.getNeedRequests();
    }

  public List<TypeOfHelp> getTypesOfHelp() {
    return Arrays.asList(TypeOfHelp.values());
  }

    public void changeRequestStatus(String city, TypeOfHelp typeOfHelp) {
        FileDb fileDb = new FileDb();
        try {
            List<NeedRequest> activeNeedRequests = fileDb.getNeedRequests();
            List<NeedRequest> filteredList;
            filteredList = activeNeedRequests.stream().
                    filter(req -> req.getHelpStatus().equals(HelpStatuses.NEW)).
                    filter(req -> req.getPersonInNeed().getLocation().equalsIgnoreCase(city)).
                    filter(req -> req.getTypeOfHelp().equals(typeOfHelp)).
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
        } catch (IOException e) {
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
                    log.info("Found difference > 24h in " + request.toString() + ", changing status");
                    request.setHelpStatus(HelpStatuses.NEW);
                    request.setStatusChange(new Date());
                }
            }
            FileWriter writer = new FileWriter("NeedRequest.csv", false);
            for (NeedRequest nr : activeNeedRequests) {
                fileDb.saveNeedRequest(nr);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
