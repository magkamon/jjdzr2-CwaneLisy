package com.infoshare.database;
import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.Volunteer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface DB {

    void saveVolunteer(Volunteer volunteer) throws IOException;

    List<Volunteer> getVolunteers() throws FileNotFoundException;

    void saveNeedRequest(NeedRequest needRequest) throws IOException, ParseException;

    List<NeedRequest> getNeedRequests() throws FileNotFoundException, ParseException;
}
