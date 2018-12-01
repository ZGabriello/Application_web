package fr.univlyon1.m1if.m1if03.tp3.beans;

import java.util.LinkedHashSet;
import java.util.Set;

public class UserBean {

    private String pseudo;
    private final Set<String> salons;

    public UserBean(String pseudo) {
        this.pseudo = pseudo;
        this.salons = new LinkedHashSet<String>();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return this.pseudo;
    }

    public Set<String> getSalons() {
        return salons;
    }

    public void addSalon(String s) {
        this.salons.add(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        UserBean u = (UserBean) o;
        return u.getPseudo().equals(this.pseudo);
    }


}
