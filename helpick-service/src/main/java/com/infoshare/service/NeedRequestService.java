package com.infoshare.service;

import com.infoshare.database.FileDb;
import com.infoshare.domain.HelpStatuses;
import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.PersonInNeed;
import com.infoshare.domain.TypeOfHelp;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NeedRequestService {

    public void createNeedRequest(String name, String location, String phone, TypeOfHelp typeOfHelp) {
        PersonInNeed personInNeed = new PersonInNeed(name, location, phone);
        NeedRequest needRequest = new NeedRequest(typeOfHelp, HelpStatuses.NEW, new Date(), personInNeed);
        new FileDb().saveNeedRequest(needRequest);
    }

    public List<NeedRequest> printFilteredList(String city, TypeOfHelp typeOfHelp) {
        FileDb fileDb = new FileDb();
        List<NeedRequest> activeNeedRequests = fileDb.getNeedRequests();
        List<NeedRequest> filteredList;
        filteredList = activeNeedRequests.stream().
                filter(req -> req.getHelpStatus().equals(HelpStatuses.NEW)).
                filter(req -> req.getPersonInNeed().getLocation().equalsIgnoreCase(city)).
                filter(req -> req.getTypeOfHelp().equals(typeOfHelp)).
                collect(Collectors.toList());
        return filteredList;
    }

}
