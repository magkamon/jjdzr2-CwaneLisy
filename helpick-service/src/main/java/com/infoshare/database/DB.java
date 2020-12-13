package com.infoshare.database;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.Volunteer;

import java.util.List;

public interface DB {

    void saveVolunteer(Volunteer volunteer);

    List<Volunteer> getVolunteers();

    void saveNeedRequest(NeedRequest needRequest);

    List<NeedRequest> getNeedRequests();
}
