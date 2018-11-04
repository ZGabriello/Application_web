package fr.univlyon1.m1if.m1if03.Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionMessages {
    private static Map<String, ArrayList<Message>> messages = new HashMap<>();
    //private ArrayList<Salon> salon;

    public GestionMessages() {

    }

    public void setSalon(String salon){
        messages.put(salon, new ArrayList<Message>());
    }

    public ArrayList<Message> getMessagesList(String salon){
        return messages.get(salon);
    }

    public void setMessage(Message m, String salon){
        messages.get(salon).add(m);
    }

    public int getMessageNumber(String salon){
        return messages.get(salon).size();
    }



}
