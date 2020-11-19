package com.infoshare.service;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.infoshare.util.Util.createTypeOfHelp;

public class VolunteerRepository {

    private static final String DB_FILE = "Volunteer.csv";
    private static final String CITY_CHOOSE_HEADER = "Z jakiego miasta chcesz wyszukac wolontariuszy?";

    public void printFilteredList(){
        String inputCity = Util.readDataFromConsole(CITY_CHOOSE_HEADER, ValidatorEnum.POLISHSIGNS);
        TypeOfHelp inputType = Util.createTypeOfHelp();
        List <Volunteer> availableVolunteers = readFromFile();
        List <Volunteer> filteredList;
        filteredList = availableVolunteers.stream().
                filter(Volunteer::isAvailable).
                filter(v-> v.getLocation().equalsIgnoreCase(inputCity)).
                filter(v -> v.getTypeOfHelp().equals(inputType)).
                collect(Collectors.toList());
        if (filteredList.isEmpty()){
            System.out.println("Brak dostępnych wolontariuszy");
        }
        else {
            for (Volunteer volunteer : filteredList) {
                System.out.println(volunteer.printDescription());
            }
        }

    }

    private List<Volunteer> readFromFile () {
        List<Volunteer> volunteersList = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File(DB_FILE));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splited = line.split(",");
                Volunteer volunteer = new Volunteer(splited[0],splited[1],splited[2],splited[3],
                        TypeOfHelp.valueOf(splited[4].toUpperCase()),Boolean.parseBoolean(splited[5]));
                volunteersList.add(volunteer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku z danymi, sprawdź lokalizację pliku.");
        }
        return volunteersList;
    }
}
