package com.infoshare.service;

import com.infoshare.database.DB;
import com.infoshare.domain.HelpStatuses;
import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.PersonInNeed;
import com.infoshare.domain.TypeOfHelp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeedRequestService {

    DB db;

    @Autowired
    public NeedRequestService(DB db) {
        this.db = db;
    }

    public void createNeedRequest(String name, String location, String phone, TypeOfHelp typeOfHelp) {
        PersonInNeed personInNeed = new PersonInNeed(name, location, phone);
        NeedRequest needRequest = NeedRequest
            .createNeedRequest(typeOfHelp, personInNeed);
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
}
