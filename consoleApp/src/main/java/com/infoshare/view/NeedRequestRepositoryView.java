package com.infoshare.view;

import com.infoshare.domain.NeedRequest;
import com.infoshare.domain.TypeOfHelp;
import com.infoshare.service.NeedRequestService;
import com.infoshare.util.Util;
import com.infoshare.util.ValidatorEnum;
import java.util.List;


public class NeedRequestRepositoryView {
    private static final String CITY_CHOOSE_HEADER = "Z jakiego miasta wyświetlić zgłoszenia pomocy?";
    NeedRequestService needRequestService;

    public NeedRequestRepositoryView(NeedRequestService needRequestService) {
        this.needRequestService = needRequestService;
    }

    public void showActiveNeedRequests() {
        String city = Util.readDataFromConsole(CITY_CHOOSE_HEADER, ValidatorEnum.POLISHSIGNS);
        TypeOfHelp typeOfHelp = Util.createTypeOfHelp();
        List<NeedRequest> filteredList = needRequestService.getNeedRequestFilteredList(city, typeOfHelp);
        if (filteredList.isEmpty()) {
            System.out.println("Brak zgłoszeń pomocy o zadanych parametrach");
        } else {
            for (NeedRequest needRequest : filteredList) {
                needRequest.printDescription();
            }
        }

    }
}

