package com.infoshare;

import com.infoshare.domain.Volunteer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SavingUtil {

    public static boolean saveToFile(String path, Volunteer newVolunteer){
        try {
            PrintWriter pw = new PrintWriter(path);
            pw.println(newVolunteer.toString());
            pw.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



}
