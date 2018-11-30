package fr.univlyon1.m1if.m1if03.tp4.controller;

import fr.univlyon1.m1if.m1if03.tp2.Modele.GestionMessages;
import fr.univlyon1.m1if.m1if03.tp2.Modele.Message;
import fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/back-officeRest/*")
public class BOController {
    private GestionMessages gestionMessages;
    private GestionUsersBean gestionUsers;
    private ServletContext servletContext;

    @Autowired
    public BOController(GestionMessages gestionMessages, GestionUsersBean gestionUsers) {

        this.gestionMessages = gestionMessages;
        this.gestionUsers = gestionUsers;
    }

   @GetMapping("/messages")
    public ModelAndView listeMessages(@RequestParam(name="name") String name) {
        Map<String, ArrayList<Message>> map = new HashMap<String, ArrayList<Message>>();
        map.put("messages", gestionMessages.getMessagesList(name));
        return new ModelAndView("listeMessages", map);
    }

   @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
   public String getBackOffice(Model model) {

      // model.addAttribute("lobbies", this.gestionMessages.getLobbies());

       return "back-officeRest";
   }
    /*@RequestMapping(value = "messages/{lobbyName}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Message> get(@PathVariable String lobbyName, Model model) {
        ArrayList<Message> liste = this.gestionMessages.getMessagesList(lobbyName);

        return liste;
    }*/

    @GetMapping("/messages/nb")
    public ModelAndView nbMessages(@RequestParam(name="name") String name) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("nombre", gestionMessages.getMessageNumber(name));
        return new ModelAndView("nbMessages", map);
    }

    @GetMapping("/messages/after")
    public ModelAndView messagesUlterieur(@RequestParam(name="name") String name,@RequestParam(name="num") int num) {
        Map<String, ArrayList<Message>> map = new HashMap<String, ArrayList<Message>>();
        map.put("messages", gestionMessages.getMessagesListAfter(name,num));
        return new ModelAndView("listeMessages", map);
    }

    @PostMapping("/ajoutMessage")
    public @ResponseBody Message ajoutMessage(@RequestParam(name="name") String name,@RequestParam(name="usr") String usr,@RequestParam(name="text") String text,@RequestParam(name="num") int num) {
        //int num = gestionMessages.getMessageNumber(name)+1;
        Message msg = new Message(usr,text,num);
        gestionMessages.setMessage(msg,name);
        return msg;
    }
/*
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
    }*/

}
