package com.infoshare;

import com.infoshare.database.FileDb;
import com.infoshare.database.JsonDB;
import com.infoshare.domain.GlobalLists;

public class App
{
    public static boolean isValidatorEnabled = false;

    public static void main( String[] args )
    {
        GlobalLists.INSTANCE.setStorage(new JsonDB());
        new Menu().start();
    }
}
