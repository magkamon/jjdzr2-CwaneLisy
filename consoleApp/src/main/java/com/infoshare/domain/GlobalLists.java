package com.infoshare.domain;

import com.infoshare.database.DB;
import com.infoshare.database.FileDb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum GlobalLists {
    INSTANCE;
    DB storage = new FileDb();

    private Set<Volunteer> volunteerList = new HashSet<>();
    private List<NeedRequest> needRequestList = new ArrayList<>();

    private GlobalLists() {
        volunteerList=new HashSet<>(storage.getVolunteers());
        needRequestList=storage.getAllNeedRequests();
    }

    public void addNeedRequest(NeedRequest needRequest){
        needRequestList.add(needRequest);
        try {
            storage.saveNeedRequest(needRequestList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addVolunteer(Volunteer volunteer){
        volunteerList.add(volunteer);
        try {
            storage.saveVolunteer(volunteerList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Volunteer> getVolunteerList() {
        return new HashSet<>(volunteerList);
    }

    public List<NeedRequest> getNeedRequestList() {
        return new ArrayList<>(needRequestList);
    }
}
