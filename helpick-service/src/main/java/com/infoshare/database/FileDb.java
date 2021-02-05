package com.infoshare.database;

import com.infoshare.domain.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class FileDb implements DB {

    private static final String VOLUNTEER_DB_FILE_NAME = "Volunteer.csv";
    private static final String REQUEST_DB_FILE = "NeedRequest.csv";
    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public FileDb() {
        if (!Files.exists(Paths.get(VOLUNTEER_DB_FILE_NAME))) {
            try {
                Files.createFile(Paths.get(VOLUNTEER_DB_FILE_NAME));
            } catch (IOException e) {
                System.out.println("Plik" + VOLUNTEER_DB_FILE_NAME + " nie moze zostac stworzony");
            }
        }
        if (!Files.exists(Paths.get(REQUEST_DB_FILE))) {
            try {
                Files.createFile(Paths.get(REQUEST_DB_FILE));
            } catch (IOException e) {
                System.out.println("Plik" + REQUEST_DB_FILE + " nie moze zostac stworzony");
            }
        }
    }

    @Override
    public void saveVolunteer(Volunteer volunteer) {
        try {
            if (getVolunteer(volunteer.getEmail()) == null) {
                try (FileWriter fileWriter = new FileWriter(VOLUNTEER_DB_FILE_NAME, true)) {
                    fileWriter.write(
                            volunteer.getName() + "," + volunteer.getLocation() + "," + volunteer.getEmail() + ","
                                    + volunteer.getPhone() + "," + volunteer.getTypeOfHelp() + "," + volunteer.isAvailable()
                                    + "," + volunteer.getUuid() + "\n");
                }
            } else {
                List<Volunteer> allVolunteers = getVolunteers();
                int index = -1;
                for (int i = 0; i < allVolunteers.size(); i++) {
                    Volunteer v = allVolunteers.get(i);
                    if (v.getEmail().equals(volunteer.getEmail())) {
                        index = i;
                    }
                }
                allVolunteers.set(index, volunteer);  // gdy chce usunac .remove
                try (FileWriter writer = new FileWriter(VOLUNTEER_DB_FILE_NAME, false)) {
                    for (Volunteer v : allVolunteers) {
                        writer.write(
                                v.getName() + "," + v.getLocation() + "," + v.getEmail() + "," + v.getPhone() + "," + v
                                        .getTypeOfHelp() + "," + v.isAvailable() + "," + v.getUuid() + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveVolunteerWithUuid(Volunteer volunteer) {
        List<Volunteer> allVolunteers = getVolunteers();
        boolean isNewVolunteer = true;
        for (int i = 0; i < allVolunteers.size(); i++) {
            Volunteer volunteerFromDb = allVolunteers.get(i);
            if (volunteerFromDb.getUuid().equals(volunteer.getUuid())) {
                isNewVolunteer = false;
                allVolunteers.set(i, volunteer);
                break;
            }
        }
        if (isNewVolunteer) {
            allVolunteers.add(volunteer);
        }

        try {
            try (FileWriter writer = new FileWriter(VOLUNTEER_DB_FILE_NAME, false)) {
                for (Volunteer v : allVolunteers) {
                    writer.write(v.getName() + "," +
                            v.getLocation() + "," +
                            v.getEmail() + "," +
                            v.getPhone() + "," +
                            v.getTypeOfHelp() + "," +
                            v.isAvailable() + "," +
                            v.getUuid() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveNeedRequest(NeedRequest needRequest) {
        List<NeedRequest> needRequests = getNeedRequests();
        Optional<Integer> optionalIndex = needRequests.stream()
                .filter(needRequest1 -> needRequest1.getUuid().equals(needRequest.getUuid()))
                .map(needRequests::indexOf)
                .findAny();
        if (optionalIndex.isPresent()) {
            needRequests.set(optionalIndex.get(), needRequest);
        } else {
            needRequests.add(needRequest);
        }
        saveNeedRequestList(needRequests);
    }

    private void saveNeedRequestList(List<NeedRequest> needRequests) {
        try {
            try (FileWriter fileWriter = new FileWriter(REQUEST_DB_FILE, false)) {
                for (NeedRequest needRequest : needRequests) {
                    PersonInNeed person = needRequest.getPersonInNeed();
                    fileWriter.write(needRequest.getTypeOfHelp() + "," + needRequest.getHelpStatus() + "," + df
                            .format(needRequest.getStatusChange()) + ",");
                    fileWriter.write(person.getName() + "," + person.getLocation() + "," + person.getPhone() +
                            "," + needRequest.getUuid() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUpdatedNeedRequest(List<NeedRequest> needRequestList) {
        saveNeedRequestList(needRequestList);
    }

    @Override
    public List<NeedRequest> getNeedRequests() {

        List<NeedRequest> result = new ArrayList<>();
        try {
            try (Scanner scanner = new Scanner(new File(REQUEST_DB_FILE))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] splited = line.split(",");
                    PersonInNeed person = new PersonInNeed(splited[3], splited[4], splited[5]);
                    NeedRequest needRequest = new NeedRequest(TypeOfHelp.valueOf(splited[0]),
                            HelpStatuses.valueOf(splited[1]), df.parse(splited[2]), person, UUID.fromString(splited[6]));
                    result.add(needRequest);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Volunteer> getVolunteers() {
        List<Volunteer> result = new ArrayList<>();
        try {
            try (Scanner scanner = new Scanner(new File(VOLUNTEER_DB_FILE_NAME))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] volunteerAtributes = line.split(",");
                    result.add(new Volunteer(volunteerAtributes[0], volunteerAtributes[1], volunteerAtributes[2],
                            volunteerAtributes[3], TypeOfHelp.valueOf(volunteerAtributes[4]),
                            Boolean.parseBoolean(volunteerAtributes[5]), UUID.fromString(volunteerAtributes[6])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Volunteer getVolunteer(String email) {

        try {
            try (Scanner scanner = new Scanner(new File(VOLUNTEER_DB_FILE_NAME))) {

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] volunteerAtributes = line.split(",");
                    if (volunteerAtributes.length >= 6 && volunteerAtributes[2].equalsIgnoreCase(email)) {
                        return new Volunteer(volunteerAtributes[0], volunteerAtributes[1], volunteerAtributes[2],
                                volunteerAtributes[3], TypeOfHelp.valueOf(volunteerAtributes[4]),
                                Boolean.parseBoolean(volunteerAtributes[5]), UUID.fromString(volunteerAtributes[6]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Volunteer> getVolunteer(UUID uuid) {
        return getVolunteers().stream()
                .filter(v -> v.getUuid().equals(uuid))
                .findFirst();
    }

}
