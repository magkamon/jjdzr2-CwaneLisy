package com.infoshare.domain;

import com.infoshare.database.DB;
import com.infoshare.database.FileDb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public enum GlobalLists {
    INSTANCE;
    DB storage = new FileDb();

    private List<Volunteer> volunteerList = new ArrayList<>();
    private List<NeedRequest> needRequestList = new ArrayList<>();
    private GlobalLists() {
        try {
            volunteerList=storage.getVolunteers();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            needRequestList=storage.getAllNeedRequests();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void addNeedRequest(NeedRequest needRequest){
        needRequestList.add(needRequest);
        try {
            storage.saveNeedRequest(needRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
