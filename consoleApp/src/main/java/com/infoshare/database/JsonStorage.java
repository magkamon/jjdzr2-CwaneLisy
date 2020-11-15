package com.infoshare.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.Volunteer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonStorage implements Storage {
    private static final String VOLUNTEER_DB_FILE_NAME = "Volunteer.json";
    private static final String REQUEST_DB_FILE = "NeedRequest.json";
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS"); // uzywamy df do

    public JsonStorage(){
        initializeFiles();
    }
    private  void initializeFiles(){
        if (!Files.exists(Paths.get(VOLUNTEER_DB_FILE_NAME))){
            try {
                Files.createFile(Paths.get(VOLUNTEER_DB_FILE_NAME));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!Files.exists(Paths.get(REQUEST_DB_FILE))){
            try {
                Files.createFile(Paths.get(REQUEST_DB_FILE));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveVolunteer(List<Volunteer> volunteer) throws IOException {

        ObjectWriter objectMapper = new ObjectMapper().writerWithDefaultPrettyPrinter();
        try {
            objectMapper.writeValue(new File(VOLUNTEER_DB_FILE_NAME), volunteer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveNeedRequest(List<NeedRequest> needRequest) throws IOException {
        ObjectWriter objectMapper = new ObjectMapper().writerWithDefaultPrettyPrinter();
        try {
            objectMapper.writeValue(new File(REQUEST_DB_FILE), needRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Volunteer> getVolunteers() {
        List<Volunteer> returnList= new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            returnList = Arrays.asList(objectMapper.readValue(new File(VOLUNTEER_DB_FILE_NAME), Volunteer[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnList;
    }

    @Override
    public List<NeedRequest> getAllNeedRequests() {
        List<NeedRequest> returnList= new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            returnList = Arrays.asList(objectMapper.readValue(new File(REQUEST_DB_FILE), NeedRequest[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnList;
    }
}
