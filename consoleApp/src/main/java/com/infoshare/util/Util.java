package com.infoshare.util;

import com.infoshare.domain.TypeOfHelp;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    public static final String REGISTRATION_NAME = "Podaj imie/nickname (min 3 znaki): ";
    public static final String REGISTRATION_LOCATION = "Podaj swoją lokalizację (bez polskich znaków): ";
    public static final String REGISTRATION_PHONE_NUMBER = "Podaj numer telefonu: ";
    private static final String BAD_RANGE = "Nieprawidlowy zakres";
    private static final String ILLEGAL_CHARACTERS = "Niedozwolone znaki";
    private static final String CHOOSE_TYPE_OF_HELP = "Wybierz rodzaj pomocy: ";
    private static final String CHOOSE_OPTION = "Jaką opcję wybierasz ?";

    private Util() {
    }

    public static String readDataFromConsole(String message, ValidatorEnum validatorEnum) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        if (DataValidator.isDataValid(data, validatorEnum)) {
            return data;
        } else {
            System.out.println(validatorEnum.getErrorMessage());
            return readDataFromConsole(message, validatorEnum);
        }
    }

    public static int readNumberFromUser(String message, int upperBound) {
        boolean numberOutOfRange = true;
        int readNumberFromUser = 0;
        do {
            System.out.println(message);
            try {
                Scanner scanner = new Scanner(System.in);
                readNumberFromUser = scanner.nextInt();
                numberOutOfRange = (readNumberFromUser > upperBound || readNumberFromUser < 1);
                if (numberOutOfRange) {
                    System.out.println(BAD_RANGE);
                }
            } catch (InputMismatchException ex) {
                numberOutOfRange = true;
                System.out.println(ILLEGAL_CHARACTERS);
            }

        } while (numberOutOfRange);
        return readNumberFromUser;
    }

    public static TypeOfHelp createTypeOfHelp() {
        System.out.println(CHOOSE_TYPE_OF_HELP);
        for (TypeOfHelp typeOfHelp : TypeOfHelp.values()) {
            System.out
                .println((Arrays.asList(TypeOfHelp.values()).indexOf(typeOfHelp) + 1) + ". " + typeOfHelp.getType());
        }
        int chosenTypeOfHelp = readNumberFromUser(CHOOSE_OPTION, TypeOfHelp.values().length);
        return TypeOfHelp.values()[chosenTypeOfHelp - 1];
    }
}
