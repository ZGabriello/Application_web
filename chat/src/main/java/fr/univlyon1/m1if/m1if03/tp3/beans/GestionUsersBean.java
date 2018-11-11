package fr.univlyon1.m1if.m1if03.tp3.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionUsersBean {
    private static ArrayList<String> users = new ArrayList<String>();

    public GestionUsersBean() {

    }

    public void addUser(String user){
        users.add(user);
    }

    public ArrayList<String> getUsersList(){
        return users;
    }


}
