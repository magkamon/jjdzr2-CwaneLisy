package com.infoshare;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SavingUtil {

    public static boolean saveToFile(String path, NewUser user){
        try {
            PrintWriter pw = new PrintWriter(path);
            pw.println(user.username);
            pw.println(user.location);
            pw.println(user.telNumber);
            pw.println(user.email);
            pw.println(user.helpType);

            pw.close();

            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



}
