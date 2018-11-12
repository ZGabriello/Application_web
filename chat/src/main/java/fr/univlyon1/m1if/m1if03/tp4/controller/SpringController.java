package fr.univlyon1.m1if.m1if03.tp4.controller;

import fr.univlyon1.m1if.m1if03.tp2.Modele.GestionMessages;
import fr.univlyon1.m1if.m1if03.tp2.Modele.Message;
import fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.HelloBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.UserBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/rest/*")
public class SpringController {
    private HelloBean helloBean;
    private GestionMessages gestionMessages;
    private GestionUsersBean gestionUsers;

    @Autowired
    public SpringController(GestionMessages gestionMessages, GestionUsersBean gestionUsers) {

        this.gestionMessages = gestionMessages;
        this.gestionUsers = gestionUsers;
    }

    @GetMapping("/salon")
    public ModelAndView salon(@RequestParam(name="name") String name) {
        Map<String, ArrayList<Message>> map = new HashMap<String, ArrayList<Message>>();
        map.put("messages", gestionMessages.getMessagesList(name));
        return new ModelAndView("listeMessages", map);
    }

    @PostMapping("/users")
    public UserBean user(@ModelAttribute UserCreateRequest request) {
        UserBean user = new UserBean();
        gestionUsers.addUser(user);
        return user;
    }

    @GetMapping("/message")
    public ModelAndView message(@RequestParam(name="name") String name, @RequestParam(name="num") int num) {
        Map<String, String> map = new HashMap<String, String>();
        ArrayList<Message> liste = gestionMessages.getMessagesList(name);
        for (Message m : liste) {
            if (m.getNum() == num) {
                map.put("message", m.getTexte());
            }
        }

        return new ModelAndView("contenuMessage", map);
    }

}
