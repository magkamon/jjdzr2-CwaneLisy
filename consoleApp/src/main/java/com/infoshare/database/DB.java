package com.infoshare.database;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.PersonInNeed;
import com.infoshare.domain.Volunteer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DB {
     void saveVolunteer(Volunteer volunteer) throws IOException;

     void saveNeedRequest(NeedRequest needRequest) throws IOException;
     
    Volunteer getVolunteer(String email) throws FileNotFoundException;

    List<Volunteer> getVolunteers() throws FileNotFoundException;

    List<PersonInNeed> getPersonInNeed () throws FileNotFoundException;

}
