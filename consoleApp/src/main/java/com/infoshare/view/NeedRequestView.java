package com.infoshare.view;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.service.NeedRequestService;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

import java.util.List;
import java.util.Scanner;

public class NeedRequestView {

    NeedRequestService needRequestService;

    public NeedRequestView(NeedRequestService needRequestService) {
        this.needRequestService = needRequestService;
    }

    public void showCreateNeedRequestMenu() {

        String name = Util.readDataFromConsole(Util.REGISTRATION_NAME, ValidatorEnum.ALPHA);
        String location = Util.readDataFromConsole(Util.REGISTRATION_LOCATION, ValidatorEnum.ALPHA);
        String phone = Util.readDataFromConsole(Util.REGISTRATION_PHONE_NUMBER, ValidatorEnum.PHONENUMBER);
        TypeOfHelp typeOfHelp = Util.createTypeOfHelp();

        needRequestService.createNeedRequest(name, location, phone, typeOfHelp);
    }

    public void pickupRequest (){
        String inputCity = Util.readDataFromConsole("Z jakiego miasta chcesz się podjąć zgłoszenia?",
                ValidatorEnum.POLISHSIGNS);
        TypeOfHelp inputType = Util.createTypeOfHelp();
        List<NeedRequest> filteredList = needRequestService.getNeedRequestFilteredList(inputCity,inputType);
        if (filteredList.isEmpty()) {
            System.out.println("Brak zgłoszeń pomocy o zadanych parametrach");
        } else {
            needRequestService.printNeedRequestsList(filteredList);
            int choice = Util.readNumberFromUser("Którego zgłoszenia chcesz się podjąć?",filteredList.size()-1);
            needRequestService.changeRequestStatus(filteredList, choice);
        }
    }
}
