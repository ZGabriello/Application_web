package fr.univlyon1.m1if.m1if03.tp3.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionUsersBean {
    private static ArrayList<UserBean> users = new ArrayList<UserBean>();

    public GestionUsersBean() {

    }

    public void addUser(UserBean user){
        users.add(user);
    }

    public ArrayList<UserBean> getUsersList(){
        return users;
    }


}
