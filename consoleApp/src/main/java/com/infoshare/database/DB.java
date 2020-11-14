package com.infoshare.database;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.PersonInNeed;
import com.infoshare.domain.Volunteer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

public interface DB {
    void saveVolunteer(Volunteer volunteer) throws IOException;
    Volunteer getVolunteer(String email) throws FileNotFoundException;
    List<Volunteer> getVolunteers() throws FileNotFoundException;

    // zapis zgłoszenia osob potrzebujacej pomocy wraz z rodzajem pomocy
    void saveNeedRequest(NeedRequest needRequest) throws IOException, ParseException;


    PersonInNeed getPersonInNeed(String email) throws FileNotFoundException;

    List<PersonInNeed> getPersonsInNeed() throws FileNotFoundException;
    List<Volunteer> getAvailableVolunteers();

    // zapis / aktualizacja danych  wolontariusza
    void saveVolunteer(Set<Volunteer> volunteerSet) throws IOException;

    // zapis zgłoszenia osob potrzebujacej pomocy wraz z rodzajem pomocy
    void saveNeedRequest(List<NeedRequest> needRequestList) throws IOException;

    List<NeedRequest> getAllNeedRequests() throws FileNotFoundException, ParseException;


}
