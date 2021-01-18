package com.infoshare.view;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.service.NeedRequestService;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;
import java.util.List;

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

    public void pickUpRequest(){
        String inputCity = Util.readDataFromConsole(Util.PICKUPREQUEST_LOCATION,
                ValidatorEnum.POLISHSIGNS);
        TypeOfHelp inputType = Util.createTypeOfHelp();
        List<NeedRequest> filteredList = needRequestService.getNeedRequestFilteredList(inputCity,inputType);
        if (filteredList.isEmpty()) {
            System.out.println(Util.PICKUPERQUEST_EMPTYLIST);
        } else {
            needRequestService.printNeedRequestsList(filteredList);
            int choice = Util.readNumberFromUser(Util.PICKUPERQUEST_CHOOSE_REQUEST,filteredList.size());
            needRequestService.changeRequestStatus(filteredList, choice);
        }
    }
}
