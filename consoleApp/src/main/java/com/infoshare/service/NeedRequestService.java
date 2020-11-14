package com.infoshare.service;

import com.infoshare.domain.*;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

import java.util.Date;

public class NeedRequestService {

    public void createNeedRequest() {
        PersonInNeed personInNeed=createPersonInNeed();
        TypeOfHelp typeOfHelp= Util.createTypeOfHelp();
        NeedRequest needRequest=new NeedRequest(typeOfHelp, personInNeed);
        GlobalLists.INSTANCE.addNeedRequest(needRequest);

    }

    private PersonInNeed createPersonInNeed() {
        String name= Util.readDataFromConsole("Podaj imię: ", ValidatorEnum.ALPHA);
        String location=Util.readDataFromConsole("Podaj miasto/ dzielnicę: ", ValidatorEnum.ALPHA);
        String phone=Util.readDataFromConsole("Podaj numer telefonu", ValidatorEnum.PHONENUMBER);

        return new PersonInNeed(name,location,phone);
    }

}
