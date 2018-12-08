package fr.univlyon1.m1if.m1if03.tp2.Modele;

import fr.univlyon1.m1if.m1if03.tp3.beans.UserBean;

public class Message {
    private UserBean user = new UserBean(null);
    private String texte;

    public Message(UserBean user, String texte) {
        this.user = user;
        this.texte = texte;
    }

    public Message(String pseudo, String texte) {
        this.user.setPseudo(pseudo);
        this.texte = texte;
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

    public String toString(){
        if (!"".equals(this.texte)) {
            return user.getPseudo() + " : " + texte;
        } else {
            return this.user + " a rejoint la salle !";
        }
    }

}
