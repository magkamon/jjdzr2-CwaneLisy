package com.infoshare.database;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.Volunteer;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DummyDB implements DB{
    @Override
    public void saveVolunteer(Set<Volunteer> volunteer) throws IOException {

    }

    @Override
    public void saveNeedRequest(List<NeedRequest> needRequest) throws IOException {

    }

    @Override
    public List<Volunteer> getVolunteers() {
        return Collections.emptyList();
    }

    @Override
    public List<NeedRequest> getAllNeedRequests() {
        return Collections.emptyList();
    }
}
