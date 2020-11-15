package com.infoshare.domain;

import lombok.*;

import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class Volunteer {
    private UUID uuid;
    private String name;
    private String location;
    private String email;
    private String phone;
    private TypeOfHelp typeOfHelp;
    private boolean isAvailable;

    public Volunteer(String name, String location, String email, String phone, TypeOfHelp typeOfHelp,
                     boolean isAvailable) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.typeOfHelp = typeOfHelp;
        this.isAvailable = isAvailable;
    }


    public boolean dataEquals(Volunteer v) {
        return name.equals(v.name) && location.equals(v.location) && email.equals(v.email) && phone
                .equals(v.phone) && typeOfHelp.equals(v.typeOfHelp);
    }

}
