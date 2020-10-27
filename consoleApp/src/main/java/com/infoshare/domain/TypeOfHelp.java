package com.infoshare.domain;

public enum TypeOfHelp {
    SHOPPING("Zrobic zakupy"), WALKING_THE_DOG("Wyprowadzić psa"), HOUSE_HELP("Pomoc domowa");
    String typeOfHelp;

    TypeOfHelp(String typeOfHelp) {
        this.typeOfHelp = typeOfHelp;
    }

    public String getTypeOfHelp() {
        return typeOfHelp;
    }
}
