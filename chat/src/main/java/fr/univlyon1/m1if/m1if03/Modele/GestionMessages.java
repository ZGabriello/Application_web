package fr.univlyon1.m1if.m1if03.Modele;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionMessages {
    private ServletContext servletContext;
    public static Map<String, ArrayList<Message>> salons = new HashMap<String, ArrayList<Message>>();
    private ArrayList<Salon> salon;

    public GestionMessages() {
        setSalon(new ArrayList<Salon>());
    }

    public void addSalon(String nameSalon) {
        salons.put(nameSalon, new ArrayList<Message>());
    }

    public void addMessage(String nameSalon, Message message) {
        this.getMessageList(nameSalon).add(message);
    }

    public ArrayList<Message> getMessageList(String nameSalon) {
        return salons.get(nameSalon);
    }

    public void setMessageList(Map<String, ArrayList<Message>> salonMessages) {
        this.salons = salons;
    }

    public int getMessageNumber(String nameSalon) {
        return salons.get(nameSalon).size();
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
        salons = (HashMap<String, ArrayList<Message>>) this.servletContext.getAttribute("salon");
    }

    public ArrayList<Salon> getSalon() {
        return salon;
    }

    public void setSalon(ArrayList<Salon> salon) {
        this.salon = salon;
    }

    public Salon getSalon(String salon){
        for (Salon getSal: this.salon
             ) {
            if(salon == getSal.getName())
                return getSal;

        }
        return null;
    }
}
