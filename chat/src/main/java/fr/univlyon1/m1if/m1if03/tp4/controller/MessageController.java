package fr.univlyon1.m1if.m1if03.tp4.controller;

import fr.univlyon1.m1if.m1if03.tp2.Modele.GestionMessages;
import fr.univlyon1.m1if.m1if03.tp2.Modele.Message;
import fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.HelloBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/message/*")
public class MessageController {
    private HelloBean helloBean;
    private GestionMessages gestionMessages;
    private GestionUsersBean gestionUsers;
    private Map<String, ArrayList<Message>> salons;

    @Autowired
    public MessageController(GestionMessages gestionMessages, GestionUsersBean gestionUsers) {

        this.gestionMessages = gestionMessages;
        this.gestionUsers = gestionUsers;
    }

    @GetMapping("/listeMessages")
    public ModelAndView listeMessages(@RequestParam(name="name") String name) {
        Map<String, ArrayList<Message>> map = new HashMap<String, ArrayList<Message>>();
        map.put("messages", gestionMessages.getMessagesList(name));
        return new ModelAndView("listeMessages", map);
    }

    @GetMapping("/nbMessages")
    public ModelAndView nbMessages(@RequestParam(name="name") String name) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("nombre", gestionMessages.getMessageNumber(name));
        return new ModelAndView("nbMessages", map);
    }

    @GetMapping("/messagesUlterieur")
    public ModelAndView messagesUlterieur(@RequestParam(name="name") String name,@RequestParam(name="num") int num) {
        Map<String, ArrayList<Message>> map = new HashMap<String, ArrayList<Message>>();
        map.put("messages", gestionMessages.getMessagesListAfter(name,num));
        return new ModelAndView("listeMessages", map);
    }

    @PutMapping(value = "/modifierDernierMessage")
    public ModelAndView updateLastMessage(@PathVariable(value = "salon") String salon,
                                          @PathVariable(value = "user") String user,
                                          HttpSession session){
        salons = (HashMap<String, ArrayList<Message>>) session.getServletContext().getAttribute("salon");
        Map<String, ArrayList<Message>> messages = new HashMap<String, ArrayList<Message>>();

        int numeroInt = Integer.valueOf(salons.get(salon).size()) - 1;
        if (numeroInt <= 0) {
            numeroInt = 0;
        }
        if (salons.get(salon) != null) {
            if (salons.get(salon).size() > numeroInt) {
                if(user.equals(salons.get(salon).get(numeroInt).getUser()))
                    gestionMessages.setMessage(messages.get(salon).get(numeroInt), salon);
            }
        }
        ModelAndView model = new ModelAndView("messages_all");
        ArrayList<Message> messagesL = salons.get(salon);
        model.addObject("messagesList", messagesL);
        model.addObject("user", user);
        return model;
    }

    @DeleteMapping(value = "/deleteLastMessage")
    public ModelAndView deleteLastMessage(@RequestParam(value = "salon") String salond,
                                          @PathVariable(value = "salon") String salon,
                                          @PathVariable(value = "user") String user) {
        int numeroInt = Integer.valueOf(salons.get(salon).size()) - 1;
        if (numeroInt <= 0) {
            numeroInt = 0;
        }
        if (salons.get(salon) != null) {
            if (salons.get(salon).size() > numeroInt) {
                if(user.equals(salons.get(salon).get(numeroInt).getUser()))
                    salons.get(salon).remove(numeroInt);
            }
        }
        ModelAndView model = new ModelAndView("messages_all");
        ArrayList<Message> messages = salons.get(salon);
        model.addObject("messagesList", messages);
        model.addObject("user", user);
        return model;
    }


}

