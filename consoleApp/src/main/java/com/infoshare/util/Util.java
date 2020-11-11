package com.infoshare.util;

import com.infoshare.domain.TypeOfHelp;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    public static String readDataFromConsole(String message, ValidatorEnum validatorEnum){
        System.out.println(message);
        Scanner scanner=new Scanner(System.in);
        String data = scanner.nextLine();
        if(DataValidator.isDataValid(data,validatorEnum)){
            return data;
        }else {
            System.out.println(validatorEnum.getErrorMessage());
            return readDataFromConsole(message, validatorEnum);
        }
    }
    public static int readNumberFromUser(String message, int upperBound) {
        boolean numberOutOfRange=true;
        int readNumberFromUser=0;
        do {
            System.out.println(message);
            try {
                Scanner scanner = new Scanner(System.in);
                readNumberFromUser = scanner.nextInt();
                numberOutOfRange = (readNumberFromUser > upperBound || readNumberFromUser < 1);
                if(numberOutOfRange){
                    System.out.println("Nieprawidlowy zakres");
                }
            } catch (InputMismatchException ex){
                numberOutOfRange=true;
                System.out.println("Niedozwolone znaki");
            }

        }while(numberOutOfRange);
        return readNumberFromUser;
    }

    public static TypeOfHelp createTypeOfHelp() {
        System.out.println("Wybierz rodzaj pomocy: ");
        for (TypeOfHelp typeOfHelp: TypeOfHelp.values() ) {
            System.out.println((Arrays.asList(TypeOfHelp.values()).indexOf(typeOfHelp)+1)+". "+typeOfHelp.getTypeOfHelp());
        }
        int chosenTypeOfHelp= readNumberFromUser("Jaką opcję wybierasz ?", TypeOfHelp.values().length);
        return TypeOfHelp.values()[chosenTypeOfHelp-1];
    }
}
