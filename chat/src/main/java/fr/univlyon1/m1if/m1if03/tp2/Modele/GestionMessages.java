package fr.univlyon1.m1if.m1if03.tp2.Modele;

import fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.Salon;
import fr.univlyon1.m1if.m1if03.tp3.beans.UserBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionMessages {
    private static Map<String, List<Message>> messages = new HashMap<String, List<Message>>();
    private static final List<Salon> salons = new ArrayList<Salon>();


    private Salon salon;


    public GestionMessages() {

    }

    public void setSalon(String salon){
        messages.put(salon, new ArrayList<Message>());
    }

    /*public void setSalon(String nom) {
        for (Salon s : salons) {
            if (s.getNom().equals(nom)) {
                this.salon = s;
                return;
            }
        }

        this.salon = new Salon(nom);
        salons.add(this.salon);
    }
*/
    public List<Message> getMessagesList(String salon){
        return messages.get(salon);
    }

    public void addMessage(Message message) {
        if (this.salon == null)
            return;

        if (message.getUser() == null)
            return;

        this.salon.addMessage(message);
    }

    public void setMessage(Message m, String salon){
        messages.get(salon).add(m);
    }

    public void addMessage(String message, UserBean author) {
        this.addMessage(new Message(author,message));
    }

    public void addMessage(String message, String author) {
        this.addMessage(new Message(GestionUsersBean.getUser(author), message));
    }

    public int getMessageNumber(String salon){
        return messages.get(salon).size();
    }


}
