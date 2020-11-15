package com.infoshare.persistence;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.Volunteer;

import java.util.Map;
import java.util.UUID;

public interface Persistence {


    void addNeedRequest(NeedRequest needRequest);

    void addVolunteer(Volunteer volunteer);

    void updateVolunteer(Volunteer volunteer);

    void updateNeedRequest(NeedRequest needRequest);

    Map<UUID, Volunteer> getVolunteerMap();

    Map<UUID, NeedRequest> getNeedRequestMap();
}
