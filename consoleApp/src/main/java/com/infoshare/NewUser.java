package com.infoshare;


public class NewUser {

    String username;
    String location;
    String telNumber;
    String email;
    String helpType;

    private static final String SEPARATOR = ";";

    public NewUser(){}

    public String convertUser(){
        return username + SEPARATOR + location + SEPARATOR + telNumber + SEPARATOR + email + SEPARATOR + helpType;
    }




}
