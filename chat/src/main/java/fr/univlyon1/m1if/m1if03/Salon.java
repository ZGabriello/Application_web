package fr.univlyon1.m1if.m1if03;

import java.util.ArrayList;
import java.util.List;

public class Salon {

    private String name;
    private List<Message> messages = new ArrayList<Message>();

    public Salon(String name, List<Message> messages) {
        this.name = name;
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


}
