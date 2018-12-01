package fr.univlyon1.m1if.m1if03.tp3.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionUsersBean {
    private static List<UserBean> users = new ArrayList<UserBean>();

    public GestionUsersBean() {

    }

    public static void addUser(String user){
        users.add(new UserBean(user));
    }

    public static List<UserBean> getUsersList(){
        return users;
    }

    public static UserBean getUser(String name) {
        for (UserBean u : users) {
            if (u.getPseudo().equals(name)) {
                return u;
            }
        }

        return null;
    }


}
