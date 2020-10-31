package com.infoshare.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    public static String readFromUser(String message){
        System.out.println(message);
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
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
}
