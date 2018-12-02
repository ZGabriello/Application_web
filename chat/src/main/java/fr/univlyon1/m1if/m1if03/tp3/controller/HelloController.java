package fr.univlyon1.m1if.m1if03.tp3.controller;

import fr.univlyon1.m1if.m1if03.tp2.Modele.GestionMessages;
import fr.univlyon1.m1if.m1if03.tp2.Modele.Message;
import fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.HelloBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("/back-office/*")
public class HelloController {
    private HelloBean helloBean;
    private GestionMessages gestionMessages;
    private GestionUsersBean gestionUsers;

    @Autowired
    public HelloController(GestionMessages gestionMessages, GestionUsersBean gestionUsers) {

        this.gestionMessages = gestionMessages;
        this.gestionUsers = gestionUsers;
    }

    @GetMapping("/salon")
    public ModelAndView salon(@RequestParam(name="name") String name) {
        Map<String, List<Message>> map = new HashMap<String, List<Message>>();
        map.put("messages", gestionMessages.getMessagesList(name));
        return new ModelAndView("listeMessages", map);
    }


    @GetMapping("/message")
    public ModelAndView message(@RequestParam(name="name") String name, @RequestParam(name="num") int num) {
        Map<String, String> map = new HashMap<String, String>();
        List<Message> liste = gestionMessages.getMessagesList(name);
        //List<Message> res = new ArrayList<Message>();
        Message msg = new Message("",null);
        for (int i = 0; i < liste.size(); i++) {
            if(i == num) {
                //res.add(liste.get(i));
                msg = liste.get(i);
            }
        }
        map.put("message", msg.getTexte());

        return new ModelAndView("contenuMessage", map);
    }

    @RequestMapping(value = "users/add", method = RequestMethod.POST)
    public String postUsers(@RequestParam("username") String nomUtilisateur, Model model) {
        model.addAttribute("requete", "POST");

        for (UserBean u : GestionUsersBean.getUsersList()) {
            if (u.getPseudo().equals(nomUtilisateur)) {
                model.addAttribute("user", "dejaPresentDansLaListe");

                return "back-officeRest-utilisateurs";
            }
        }

        GestionUsersBean.addUser(nomUtilisateur);
        model.addAttribute("user", nomUtilisateur);

        return "back-officeRest-utilisateurs";
    }

    /*@Autowired
    public HelloController(HelloBean helloBean) {
        this.helloBean = helloBean;
    }

    @GetMapping
    public ModelAndView hello(@RequestParam(name="name") String name) {
        helloBean.setUser(name);
        Map<String, Object> map = new HashMap<>();
        map.put("message", helloBean.getGreetings());
        return new ModelAndView("hello", map);
    }*/
}
