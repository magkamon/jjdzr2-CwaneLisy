package com.infoshare;

import com.infoshare.database.JsonStorage;
import com.infoshare.domain.GlobalLists;
import com.infoshare.persistence.Persistence;
import com.infoshare.persistence.PersistenceImplementation;

public class App
{
    public static boolean isValidatorEnabled = false;

    public static void main( String[] args )
    {
        Persistence persistence=new PersistenceImplementation(new JsonStorage(),GlobalLists.INSTANCE.getVolunteerMap(),
                GlobalLists.INSTANCE.getNeedRequestMap());
        new Menu(persistence).start();
    }
}
