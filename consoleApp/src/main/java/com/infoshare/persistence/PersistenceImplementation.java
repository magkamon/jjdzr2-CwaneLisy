package com.infoshare.persistence;

import com.infoshare.database.Storage;
import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.Volunteer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PersistenceImplementation implements Persistence {
    Storage storage;
    private Map<UUID, Volunteer> volunteerMap = new HashMap<>();
    private Map<UUID, NeedRequest> needRequestMap = new HashMap<>();

    public PersistenceImplementation(Storage storage, Map<UUID, Volunteer> volunteerMap,
                                     Map<UUID, NeedRequest> needRequestMap) {
        this.storage = storage;
        this.volunteerMap = volunteerMap;
        this.needRequestMap = needRequestMap;
        for (Volunteer volunteer : storage.getVolunteers()) {
            volunteerMap.put(volunteer.getUuid(), volunteer);
        }
        for (NeedRequest needRequest : storage.getAllNeedRequests()) {
            needRequestMap.put(needRequest.getUuid(), needRequest);
        }
    }

    public PersistenceImplementation() {

    }


    @Override
    public void addNeedRequest(NeedRequest needRequest) {
        needRequestMap.put(needRequest.getUuid(), needRequest);
        saveNeedRequests();
    }

    private void saveNeedRequests() {
        try {
            storage.saveNeedRequest(new ArrayList<>(needRequestMap.values()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addVolunteer(Volunteer volunteer) {
        if (!volunteerExist(volunteer)) {
            volunteerMap.put(volunteer.getUuid(), volunteer);
            saveVolunteers();
        }
    }

    private void saveVolunteers() {
        try {
            storage.saveVolunteer(new ArrayList<>(volunteerMap.values()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean volunteerExist(Volunteer volunteer) {
        for (Volunteer element : volunteerMap.values()) {
            if (element.dataEquals(volunteer)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void updateVolunteer(Volunteer volunteer) {
        volunteerMap.replace(volunteer.getUuid(), volunteer);
        saveVolunteers();


    }

    @Override
    public void updateNeedRequest(NeedRequest needRequest) {
        needRequestMap.replace(needRequest.getUuid(), needRequest);
        saveNeedRequests();
    }

    @Override
    public Map<UUID, Volunteer> getVolunteerMap() {
        return new HashMap<>(volunteerMap);
    }

    @Override
    public Map<UUID, NeedRequest> getNeedRequestMap() {
        return new HashMap<>(needRequestMap);
    }
}

