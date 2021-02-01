package com.infoshare;

import com.infoshare.database.DB;
import com.infoshare.database.FileDb;
import com.infoshare.service.NeedRequestService;
import com.infoshare.service.VolunteerService;
import com.infoshare.view.NeedRequestRepositoryView;
import com.infoshare.view.NeedRequestView;
import com.infoshare.view.VolunteerAvailabilityView;
import com.infoshare.view.VolunteerRegistrationView;
import com.infoshare.view.VolunteerRepositoryView;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    private static final String HEADER = "Witaj w Helpick!";
    private static final String[] OPTIONS = {"" +
        "1. Wprowadź nową ofertę wolontariatu",
        "2. Zgłoś osobę potrzebującą pomocy",
        "3. Wyświetl dostępnych wolontariuszy",
        "4. Wyświetl listę osób, potrzebujących pomocy",
        "5. Zmień status wolontariusza",
        "6. Podejmij zgłoszenie",
        "7. Aktualizuj status zgłoszeń",
        "0. Wyjdź z programu"};

    private final DB db;
    private NeedRequestService needRequestService;
    private VolunteerService volunteerService;

    public Menu() {
        this.db = new FileDb();
        this.needRequestService = new NeedRequestService(db);
        this.volunteerService = new VolunteerService(db);
    }

    public void start() {
        System.out.println(HEADER);
        handleUserChoice();
    }

    private void handleUserChoice() {
        int userChoice = 1;
        do {
            showMenu();
            System.out.println("Twój wybór: ");
            try {
                userChoice = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Podaj prawidłowe dane.");
            }

            switch (userChoice) {
                case 1: {
                    System.out.println("Wprowadź nową ofertę wolontariatu");
                    new VolunteerRegistrationView(volunteerService).showVolunteerRegisterMenu();
                    break;
                }
                case 2: {
                    new NeedRequestView(needRequestService).showCreateNeedRequestMenu();
                    break;
                }
                case 3: {
                    System.out.println("Wyświetl dostępnych wolontariuszy");
                    new VolunteerRepositoryView(volunteerService).showAvailableVolunteer();
                    break;
                }
                case 4: {
                    System.out.println("Wyświetl listę osób, potrzebujących pomocy");
                    new NeedRequestRepositoryView(needRequestService).showActiveNeedRequests();
                    break;
                }
                case 5: {
                    System.out.println("Zmień status wolontariusza");
                    new VolunteerAvailabilityView(volunteerService).handleVolunteerChangeAvailabilityProcess();
                    break;
                }
                case 6: {
                    new NeedRequestView(needRequestService).pickUpRequest();
                    break;
                }
                case 7: {
                    needRequestService.restoreStatusForExpiredRequests();
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

        } while (userChoice != 0);
    }

    private void showMenu() {
        for (String option : OPTIONS) {
            System.out.println(option);
        }
    }
}
