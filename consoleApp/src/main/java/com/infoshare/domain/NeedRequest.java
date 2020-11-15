package com.infoshare.domain;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter

public class NeedRequest {
    private UUID uuid;
    private TypeOfHelp typeOfHelp;
    private HelpStatuses helpStatus;
    private Date statusChange;
    private PersonInNeed personInNeed;


    public NeedRequest(TypeOfHelp typeOfHelp, PersonInNeed personInNeed) {
        this.uuid = UUID.randomUUID();
        this.typeOfHelp = typeOfHelp;
        this.helpStatus = HelpStatuses.NEW;
        this.statusChange = new Date();
        this.personInNeed = personInNeed;
    }


}

