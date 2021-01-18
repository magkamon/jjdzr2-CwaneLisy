package com.infoshare.service;

import com.infoshare.database.DB;
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

    public void changeRequestStatus(List<NeedRequest> filteredList, int choice) {
        try {
            List<NeedRequest> activeNeedRequests = db.getNeedRequests();
            NeedRequest changedRequest = filteredList.get(choice-1);
            changedRequest.setHelpStatus(HelpStatuses.INPROGRESS);
            changedRequest.setStatusChange(new Date());
            for (int i = 0; i < activeNeedRequests.size(); i++) {
                if (activeNeedRequests.get(i).getUuid().equals(changedRequest.getUuid())) {
                    activeNeedRequests.set(i, changedRequest);
                }
            }
            FileWriter writer = new FileWriter("NeedRequest.csv", false);
            for (NeedRequest nr : activeNeedRequests) {
                db.saveNeedRequest(nr);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreStatusForExpiredRequests() {
        try {
            List<NeedRequest> activeNeedRequests = db.getNeedRequests();
            for (NeedRequest request : activeNeedRequests) {
                Date time1 = request.getStatusChange();
                Date actualTime = new Date();
                long diff = actualTime.getTime() - time1.getTime();
                long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
                if (request.getHelpStatus().equals(HelpStatuses.INPROGRESS) &&
                        minutes > 1440) {
                    log.info("Found difference > 24h in request " + request.getUuid() + ", changing status...");
                    request.setHelpStatus(HelpStatuses.NEW);
                    request.setStatusChange(new Date());
                    log.info("Status of request ID " + request.getUuid() + " restored to NEW");
                }
            }
            FileWriter writer = new FileWriter("NeedRequest.csv", false);
            for (NeedRequest nr : activeNeedRequests) {
                db.saveNeedRequest(nr);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printNeedRequestsList(List<NeedRequest> needRequestList) {
        for (int i = 0; i < needRequestList.size(); i++) {
            System.out.println(i+1 + ". " + needRequestList.get(i));
        }
    }

    public List<NeedRequest> getNeedRequestFilteredList(String city, TypeOfHelp typeOfHelp) {
        return db.getNeedRequests().stream()
                .filter(n -> n.getHelpStatus().equals(HelpStatuses.NEW))
                .filter(n -> n.getTypeOfHelp().equals(typeOfHelp))
                .filter(n -> n.getPersonInNeed().getLocation().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public Optional<NeedRequest> getNeedRequestById(UUID uuid) {
        return db.getNeedRequests().stream()
                .filter(n -> n.getUuid().equals(uuid))
                .findAny();
    }

    public List<NeedRequest> getAllNeedRequests() {
        return db.getNeedRequests();
    }

    public List<TypeOfHelp> getTypesOfHelp() {
        return Arrays.asList(TypeOfHelp.values());
    }
}
