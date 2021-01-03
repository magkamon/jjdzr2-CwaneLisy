package com.infoshare.view;

import com.infoshare.domain.TypeOfHelp;
import com.infoshare.service.NeedRequestService;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;

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

}
