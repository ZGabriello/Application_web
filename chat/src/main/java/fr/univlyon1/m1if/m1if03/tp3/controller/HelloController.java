package fr.univlyon1.m1if.m1if03.tp3.controller;

import fr.univlyon1.m1if.m1if03.tp2.Modele.GestionMessages;
import fr.univlyon1.m1if.m1if03.tp2.Modele.Message;
import fr.univlyon1.m1if.m1if03.tp3.beans.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/back-office")
public class HelloController {
    private HelloBean helloBean;
    private GestionMessages gestionMessages;

    @Autowired
    public HelloController(GestionMessages gestionMessages) {
        this.gestionMessages = gestionMessages;
    }

    @GetMapping
    public ModelAndView hello(@RequestParam(name="name") String name) {
        gestionMessages.setSalon(name);
        Map<String, ArrayList<Message>> map = new HashMap<String, ArrayList<Message>>();
        map.put("messages", gestionMessages.getMessagesList(name));
        return new ModelAndView("Affichage", map);
    }
}
