package com.infoshare.service;

import com.infoshare.domain.HelpStatuses;
import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.PersonInNeed;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.util.Util;

import java.util.Arrays;
import java.util.Date;

public class NeedRequestService {

    public void createNeedRequest() {
        PersonInNeed personInNeed=createPersonInNeed();
        TypeOfHelp typeOfHelp=createTypeOfHelp();
        NeedRequest needRequest=new NeedRequest(typeOfHelp, HelpStatuses.NEW,new Date(),personInNeed);

    }

    private TypeOfHelp createTypeOfHelp() {
        System.out.println("Wybierz rodzaj pomocy: ");
        for (TypeOfHelp typeOfHelp: TypeOfHelp.values() ) {
            System.out.println((Arrays.asList(TypeOfHelp.values()).indexOf(typeOfHelp)+1)+". "+typeOfHelp.getTypeOfHelp());
        }
        int chosenTypeOfHelp=Util.readNumberFromUser("Jaką opcję wybierasz ?", TypeOfHelp.values().length);
        return TypeOfHelp.values()[chosenTypeOfHelp-1];
    }

    private PersonInNeed createPersonInNeed() {
        String name= Util.readFromUser("Podaj imię: ");
        String location=Util.readFromUser("Podaj miasto/ dzielnicę: ");
        String phone=Util.readFromUser("Podaj numer telefonu");

        return new PersonInNeed(name,location,phone);
    }

}
