package com.infoshare.service;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.domain.Volunteer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VolunteerRepository {

    private static final String DB_FILE = "Volunteer.csv";

    public void printFilteredList(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Z jakiego miasta chcesz wyszukac wolontariuszy?");
        String inputCity = scan.nextLine();
        System.out.println("Jakiego typu pomocy szukasz?");
        printTypesOfHelp();
        String inputTypeOfHelp = scan.nextLine();
        try {
            List <Volunteer> availableVolunteers = readFromFile();
            List <Volunteer> filteredList;
            filteredList = availableVolunteers.stream().
                    filter(Volunteer::isAvailable).
                    filter(v -> v.getLocation().toLowerCase().equals(inputCity.toLowerCase())).
                    filter(v -> v.getTypeOfHelp().getTypeOfHelp().toLowerCase().equals(inputTypeOfHelp.toLowerCase())).
                    collect(Collectors.toList());

            if (filteredList.size() == 0){
                System.out.println("Brak dostępnych wolontariuszy");
            }
            else {
                for (Volunteer volunteer : filteredList) {
                    System.out.println(volunteer.printDescription());
                }
            }
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println("Podałeś nieprawidłowe dane");
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

    private void printTypesOfHelp(){
        for (TypeOfHelp type : TypeOfHelp.values()) {
            System.out.println(type.getTypeOfHelp());
        }
    }

}
