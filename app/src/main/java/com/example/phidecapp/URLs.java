package com.example.phidecapp;

public class URLs {
    private static final String ROOT_URL = "http://192.168.1.104/PhidecApp/Admin/registrationapi.php?apicall=";
    public static final String URL_REGISTER = ROOT_URL + "signup";
    public static final String URL_LOGIN= ROOT_URL + "login";
    public static final String URL_Client= "http://192.168.1.104/PhidecApp/Admin/user_management/api_user.php";
    public static final String ADD_Client= "http://192.168.1.104/PhidecApp/Admin/user_management/add_user.php";
    public static final String EDIT_PROFILE= "http://192.168.1.104/PhidecApp/Admin/user_management/edit_profile.php";
}
