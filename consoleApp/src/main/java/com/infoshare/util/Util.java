package com.infoshare.util;

import java.util.Scanner;

public class Util {

    public static String readFromUser(String message){
        System.out.println(message);
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
}
