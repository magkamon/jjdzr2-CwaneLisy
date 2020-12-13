package com.infoshare.domain;

public enum TypeOfHelp {
    SHOPPING("Zrobic zakupy"), WALKING_THE_DOG("Wyprowadzić psa"), HOUSE_HELP("Pomoc domowa");
    String type;

    TypeOfHelp(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
