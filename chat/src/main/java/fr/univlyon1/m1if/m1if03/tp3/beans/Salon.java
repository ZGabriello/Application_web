package fr.univlyon1.m1if.m1if03.tp3.beans;

import fr.univlyon1.m1if.m1if03.tp2.Modele.Message;

import java.util.ArrayList;
import java.util.List;

public class Salon {

    private String nom;
    private final List<Message> messages;
    
    public Salon(String nom) {
        this.nom = nom;
        this.messages = new ArrayList<Message>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void addMessage(Message message) {
        if (message == null) {
            return;
        }
        
        message.getUser().addSalon(this.getNom());
        
        this.messages.add(message);
    }
    
    public List<Message> getMessages() {
        return this.messages;
    }
    
    @Override
    public boolean equals(Object nom) {
        if (nom == null)
            return false;

        return this.nom.equals((String)nom);
    }
}
