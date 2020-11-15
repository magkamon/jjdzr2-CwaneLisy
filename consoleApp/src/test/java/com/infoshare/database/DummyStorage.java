package com.infoshare.database;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.Volunteer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class DummyStorage implements Storage {
    @Override
    public void saveVolunteer(List<Volunteer> volunteer) throws IOException {

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
