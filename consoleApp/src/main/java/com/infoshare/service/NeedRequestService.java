package com.infoshare.service;

import com.infoshare.Menu;
import com.infoshare.TemporaryList.TempNeedRequest;
import com.infoshare.domain.HelpStatuses;
import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.PersonInNeed;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;
import sun.net.www.HeaderParser;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NeedRequestService {

    public void createNeedRequest() {
        PersonInNeed personInNeed=createPersonInNeed();
        TypeOfHelp typeOfHelp= Util.createTypeOfHelp();
        NeedRequest needRequest=new NeedRequest(typeOfHelp, HelpStatuses.NEW,new Date(),personInNeed);

    }
    public void updateNeedRequest(NeedRequest needRequest, HelpStatuses helpStatuses) {


        List<NeedRequest> needRequestList = new TempNeedRequest().getAll();
        Scanner scannerChangeStatus = new Scanner(System.in);
        int numberOfRequest = 0;


        needRequest.setHelpStatus(helpStatuses);
        System.out.println("Czy chcesz zmienić status zgłoszenia? Tak/nie");
        String input = scannerChangeStatus.nextLine();
        if (input.equalsIgnoreCase("TAK")) {
            System.out.println("Wybierz numer zgłoszenia, którego chcesz się podjąć");
            numberOfRequest = Integer.parseInt(scannerChangeStatus.nextLine());
            NeedRequest needRequest1 = needRequestList.get(-1);
        } else {
            input.equalsIgnoreCase("NIE");
            return;
        }
        System.out.println("Status zgłoszenia został zmieniony na 'Realizacja' ");

        NeedRequest selectedNeedRequest = needRequestList.get(numberOfRequest - 1);
        if (selectedNeedRequest.getStatusChange().equals(HelpStatuses.NEW)) {
            selectedNeedRequest.setHelpStatus(HelpStatuses.INPROGRESS);
        } else  {selectedNeedRequest.setHelpStatus(HelpStatuses.DONE);}

        }



    private PersonInNeed createPersonInNeed() {
        String name= Util.readDataFromConsole(Util.REGISTRATION_NAME, ValidatorEnum.ALPHA);
        String location=Util.readDataFromConsole(Util.REGISTRATION_LOCATION, ValidatorEnum.ALPHA);
        String phone=Util.readDataFromConsole(Util.REGISTRATION_PHONE_NUMBER, ValidatorEnum.PHONENUMBER);

        return new PersonInNeed(name,location,phone);
    }

}
