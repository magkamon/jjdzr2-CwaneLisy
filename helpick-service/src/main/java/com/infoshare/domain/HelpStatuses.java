package com.infoshare.domain;


public enum HelpStatuses {
    NEW("Nowe"), INPROGRESS("Realizacja"), DONE("Wykonane");

    String status;

    HelpStatuses(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
