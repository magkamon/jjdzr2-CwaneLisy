package com.infoshare.TemporaryList;

import com.infoshare.domain.NeedRequest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TempNeedRequest {
    List<NeedRequest> needRequestList = new ArrayList<>();


    public List<NeedRequest> getNeedRequestList() {
        return needRequestList;
    }

    public List<NeedRequest> getAll() {
        return needRequestList;
    }
}
