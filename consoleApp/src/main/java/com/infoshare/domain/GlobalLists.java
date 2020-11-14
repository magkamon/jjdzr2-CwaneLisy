package com.infoshare.domain;

import com.infoshare.database.DB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum GlobalLists {
    INSTANCE();

    DB storage;

    private Map<UUID, Volunteer> volunteerMap = new HashMap<>();
    private Map<UUID, NeedRequest> needRequestMap = new HashMap<>();

    private GlobalLists() {
    }

    public void setStorage(DB storage) {
        this.storage = storage;
        this.volunteerMap.clear();
        this.needRequestMap.clear();
        for (Volunteer volunteer : storage.getVolunteers()) {
            volunteerMap.put(volunteer.getUuid(), volunteer);
        }
        for (NeedRequest needRequest : storage.getAllNeedRequests()) {
            needRequestMap.put(needRequest.getUuid(), needRequest);
        }

    }

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

    public void updateVolunteer(Volunteer volunteer) {
        volunteerMap.replace(volunteer.getUuid(), volunteer);
        saveVolunteers();


    }

    public void updateNeedRequest(NeedRequest needRequest) {
        needRequestMap.replace(needRequest.getUuid(), needRequest);
        saveNeedRequests();
    }

    public Map<UUID, Volunteer> getVolunteerMap() {
        return new HashMap<>(volunteerMap);
    }

    public Map<UUID, NeedRequest> getNeedRequestMap() {
        return new HashMap<>(needRequestMap);
    }
}
