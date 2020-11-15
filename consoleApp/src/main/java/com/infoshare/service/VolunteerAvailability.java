package com.infoshare.service;

import com.infoshare.domain.Volunteer;

import java.util.Scanner;

public class VolunteerAvailability {

    private static final String AVAILABILITY_HEADER = "Czy chcesz zmienić swoją dostępność? [ Y / N ] ";
    private static final String AVAILABILITY_ERROR = "***BŁĄD***";
    private static final String AVAILABILITY_STATUS = "Twoj obecny status w systemie to: ";
    private static final String GET_EMAIL = "Podaj adres e-mail podany podczas rejestracji";
    private static final String STATUS_AVAILABLE = "DOSTĘPNY";
    private static final String STATUS_UNAVAILABLE = "NIEDOSTĘPNY";

    private static boolean askAvailability(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(AVAILABILITY_HEADER);
        String availability = scanner.nextLine();

        if (availability.equals("Y")){
            return true;
        } else if (availability.equals("N")){
            return false;
        }
        else {
            System.out.println(AVAILABILITY_ERROR);
            return askAvailability();
        }

    }

    public static void changeAvailability(Volunteer volunteer){
        System.out.println(AVAILABILITY_STATUS);
        if (volunteer.isAvailable()){
            System.out.println(STATUS_AVAILABLE);
        }else {
            System.out.println(STATUS_UNAVAILABLE);
        }

        if (VolunteerAvailability.askAvailability()){
            if(volunteer.isAvailable()){
                volunteer.setAvailable(false);
            }else {
                volunteer.setAvailable(true);
            }
        }
    }

    private static String getEmail (){
        System.out.println(GET_EMAIL);
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        return email;
    }

    public static void updateAvailability(){
        // FileDb database = new FileDb();
        // Volunteer volunteerToUpdate = database.getVolunteer(getEmail);
        // changeAvailability(volunteerToUpdate);
        // database.saveVolunteer(volunteerToUpdate);
    }


}
