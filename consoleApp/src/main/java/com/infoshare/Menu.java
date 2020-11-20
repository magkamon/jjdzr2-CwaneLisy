package com.infoshare;

import com.infoshare.service.NeedRequestService;
import com.infoshare.service.VolunteerRepository;
import com.infoshare.service.VolunteerAvailability;
import com.infoshare.service.UserRegistration;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final String HEADER = "Witaj w Helpick!";
    private static final String [] OPTIONS = {
            "1. Wprowadź nową ofertę wolontariatu",
            "2. Zgłoś osobę potrzebującą pomocy",
            "3. Wyświetl dostępnych wolontariuszy",
            "4. Wyświetl listę osób, potrzebujących pomocy",
            "5. Zmień status wolonatriusza",
            "0. Wyjdź z programu"
    };

    public void start (){
        System.out.println(HEADER);
        handleUserChoice();
    }

    private void handleUserChoice () {
        int userChoice = 1;
        do {
            showMenu();
            System.out.println("Twój wybór: ");
            try {
                userChoice = new Scanner(System.in).nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Podaj prawidłowe dane.");
            }

                switch (userChoice) {
                    case 1: {
                        System.out.println("Wprowadź nową ofertę wolontariatu");
                        new UserRegistration().register();
                        break;
                    }
                    case 2: {
                        new NeedRequestService().createNeedRequest();
                        break;
                    }
                    case 3: {
                        System.out.println("Wyświetl dostępnych wolontariuszy");
                        new VolunteerRepository().printFilteredList();
                        break;
                    }
                    case 4: {
                        System.out.println("Wyświetl listę osób, potrzebujących pomocy");
                        break;
                    }
                    case 5: {
                        System.out.println("Zmień status wolonatriusza");
                        new VolunteerAvailability().updateAvailability();
                        break;
                    }
                    case 0: {
                        System.out.println("Wyjdź z programu");
                        break;
                    }
                    default: {
                        System.out.println("Wybierz jedną z dostępnych opcji.");
                    }
                }

        }
        while (userChoice != 0);
    }

    private void showMenu(){
        for (String option: OPTIONS
        ) {
            System.out.println(option);
        }
    }
}
