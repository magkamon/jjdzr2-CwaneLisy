package com.infoshare.database;

import com.infoshare.domain.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FileDb implements DB {
    private static final String VOLUNTEER_DB_FILE_NAME = "Volunteer.csv";
    private static final String REQUEST_DB_FILE = "NeedRequest.csv";
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // uzywamy df do formatowania i parsowania dat

    public FileDb() {
    }


    public static void initializeFiles(){
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
    @Override // zapis / aktualizacja danych  wolontariusza
    public void saveVolunteer(Set<Volunteer> volunteerSet) throws IOException {

        FileWriter fileWriter = new FileWriter(VOLUNTEER_DB_FILE_NAME, false);
        for (Volunteer volunteer: volunteerSet) {
            fileWriter.write(volunteer.getName() + "," + volunteer.getLocation() + "," + volunteer.getEmail() + ","
                    + volunteer.getPhone() + "," + volunteer.getTypeOfHelp() + "," + volunteer.isAvailable() + "\n");
        }
        fileWriter.close();
    }

    @Override// zapis zgłoszenia osob potrzebujacej pomocy wraz z rodzajem pomocy
    public void saveNeedRequest(List<NeedRequest> needRequestList) throws IOException {
        FileWriter fileWriter = new FileWriter(REQUEST_DB_FILE, false);
        for (NeedRequest needRequest: needRequestList
             ) {
            PersonInNeed person = needRequest.getPersonInNeed();
            fileWriter.write(needRequest.getTypeOfHelp() + "," + needRequest.getHelpStatus() + ","
                    + df.format(needRequest.getStatusChange()) + ",");

            fileWriter.write(person.getName() + "," + person.getLocation()
                    + "," + person.getPhone() + "\n");

        }
        fileWriter.close();
    }

    //odczyt danych osoby potrzebujacej pomocy wraz z rodzajem pomocy
    @Override
    public List<NeedRequest> getAllNeedRequests() {
        List<NeedRequest> result = new ArrayList<>();
        try {
        Scanner scanner = new Scanner(new File(REQUEST_DB_FILE));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splited = line.split(",");
            PersonInNeed person = new PersonInNeed(splited[3], splited[4], splited[5]);
            NeedRequest needRequest = new NeedRequest(TypeOfHelp.valueOf(splited[0]), HelpStatuses.valueOf(splited[1])
                    , df.parse(splited[2]), person);
            result.add(needRequest);
        }} catch (FileNotFoundException | ParseException exception){
            System.out.println("Problem z odczytem pliku z need requestami");
            }
        return result;
    }

    @Override
    public List<Volunteer> getVolunteers(){
        List<Volunteer> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(VOLUNTEER_DB_FILE_NAME));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] volunteerAtributes = line.split(",");
                result.add(new Volunteer(volunteerAtributes[0], volunteerAtributes[1], volunteerAtributes[2],
                        volunteerAtributes[3], TypeOfHelp.valueOf(volunteerAtributes[4]),
                        Boolean.parseBoolean(volunteerAtributes[5])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Problem z odczytem pliku z wolontariuszami");
        }
        return result;
    }
}
