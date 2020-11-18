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

    List<Volunteer> getVolunteers() throws FileNotFoundException;

    // zapis zgłoszenia osob potrzebujacej pomocy wraz z rodzajem pomocy
    void saveNeedRequest(NeedRequest needRequest) throws IOException, ParseException;

    List<NeedRequest> getNeedRequests() throws FileNotFoundException, ParseException;


}
