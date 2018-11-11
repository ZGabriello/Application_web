package fr.univlyon1.m1if.m1if03.tp2.Modele;

public class Message {
    private String pseudo;
    private String texte;
    private int numero;

    public Message(String pseudo, String texte, int numero) {
        this.pseudo = pseudo;
        this.texte = texte;
        this.numero = numero;
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

    public int getNum() {
        return numero;
    }

    public void setNum(int numero) {
        this.numero = numero;
    }

    public String toString(){
        return pseudo + " : " + texte;
    }

}
