package com.infoshare.controller;

import com.infoshare.service.NeedRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Slf4j
public class ScheduledTasks {

    private NeedRequestService needRequestService;

    public ScheduledTasks(NeedRequestService needRequestService) {
        this.needRequestService = needRequestService;
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void updateRequests(){
        log.info("Start refresh request status task");
        needRequestService.restoreStatusForExpiredRequests();
        log.info("Refresh status task done");
    }
}
