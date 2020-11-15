package com.infoshare.database;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.Volunteer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

public interface Storage {
    void saveVolunteer(List<Volunteer> volunteer) throws IOException;

    void saveNeedRequest(List<NeedRequest> needRequest) throws IOException;

    List<Volunteer> getVolunteers();

    List<NeedRequest> getAllNeedRequests();

}
