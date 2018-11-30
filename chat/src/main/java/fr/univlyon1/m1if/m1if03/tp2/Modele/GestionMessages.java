package fr.univlyon1.m1if.m1if03.tp2.Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionMessages {
    private static Map<String, ArrayList<Message>> messages = new HashMap<String, ArrayList<Message>>();


    public GestionMessages() {

    }

    public void setSalon(String salon){
        messages.put(salon, new ArrayList<Message>());
    }

    public ArrayList<Message> getMessagesList(String salon){
        return messages.get(salon);
    }

    public ArrayList<Message> getMessagesListAfter(String salon, int num) {

        ArrayList<Message> messagesAfter = new ArrayList<Message>();
        Map<String, ArrayList<Message>> newMessages = new HashMap<String, ArrayList<Message>>();


        for(Message m : messages.get(salon)) {
            if(m.getNum() > num) {
                messagesAfter.add(m);
            }
        }
        newMessages.put(salon,messagesAfter);
        return newMessages.get(salon);
    }

    public void setMessage(Message m, String salon){
        messages.get(salon).add(m);
    }

    public int getMessageNumber(String salon){
        return messages.get(salon).size();
    }


    public Message getLastMessageAdded(String salon) {

        for(Message m : messages.get(salon)) {
            if(m.getNum()-1 == messages.size()) {
                return m;
            }
        }
        return null;
    }
}
