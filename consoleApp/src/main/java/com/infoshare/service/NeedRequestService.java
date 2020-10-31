package com.infoshare.service;

import com.infoshare.domain.HelpStatuses;
import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.PersonInNeed;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.util.Util;

import java.util.Date;

public class NeedRequestService {

    public void createNeedRequest() {
        PersonInNeed personInNeed=createPersonInNeed();
        TypeOfHelp typeOfHelp=createTypeOfHelp();
        NeedRequest needRequest=new NeedRequest(typeOfHelp, HelpStatuses.NEW,new Date(),personInNeed);

    }

    private TypeOfHelp createTypeOfHelp() {
        System.out.println("Wybierz rodzaj pomocy: ");
        int i=1;
        for (TypeOfHelp typeOfHelp: TypeOfHelp.values() ) {
            System.out.println(i+". "+typeOfHelp.getTypeOfHelp());
            i++;
        }
        int chosenTypeOfHelp=Util.readNumberFromUser("Jaka opcje wybierasz :?", TypeOfHelp.values().length);
        return TypeOfHelp.values()[chosenTypeOfHelp-1];
    }

    private PersonInNeed createPersonInNeed() {
        String name= Util.readFromUser("Podaj imie: ");
        String location=Util.readFromUser("Podaj miasto/ dzielnica: ");
        String phone=Util.readFromUser("Podaj numer telefonu");

        return new PersonInNeed(name,location,phone);
    }

}
