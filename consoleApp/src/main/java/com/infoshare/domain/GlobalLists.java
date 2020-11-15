package com.infoshare.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum GlobalLists {
    INSTANCE();


    private Map<UUID, Volunteer> volunteerMap = new HashMap<>();
    private Map<UUID, NeedRequest> needRequestMap = new HashMap<>();

    private GlobalLists() {
    }

    public Map<UUID, Volunteer> getVolunteerMap() {
        return volunteerMap;
    }

    public Map<UUID, NeedRequest> getNeedRequestMap() {
        return needRequestMap;
    }
}
