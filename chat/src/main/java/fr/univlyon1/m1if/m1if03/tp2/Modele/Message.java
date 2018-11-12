package fr.univlyon1.m1if.m1if03.tp2.Modele;

import fr.univlyon1.m1if.m1if03.tp3.beans.UserBean;

public class Message {
    private UserBean user;
    private String texte;
    private int numero;

    public Message(String pseudo, String texte, int numero) {
        this.user.setPseudo(pseudo);
        this.texte = texte;
        this.numero = numero;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getNum() {
        return numero;
    }

    public void setNum(int numero) {
        this.numero = numero;
    }

    public String toString(){
        return user.getPseudo() + " : " + texte;
    }

}
