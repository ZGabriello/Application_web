package fr.univlyon1.m1if.m1if03.Modele;

public class Message {
    private final String pseudo;
    private String texte;

    public Message(String pseudo, String texte) {
        this.pseudo = pseudo;
        this.texte = texte;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
