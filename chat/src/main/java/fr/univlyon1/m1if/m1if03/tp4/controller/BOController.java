package fr.univlyon1.m1if.m1if03.tp4.controller;

import fr.univlyon1.m1if.m1if03.tp2.Modele.GestionMessages;
import fr.univlyon1.m1if.m1if03.tp2.Modele.Message;
import fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/back-officeRest/*")
public class BOController {

    @Autowired
    private ServletContext servletContext;
    private GestionMessages gestionMessages;
   // private GestionUsersBean gestionUsers;

    public BOController() {

        this.gestionMessages = new GestionMessages();
    }


    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String getBackOffice(Model model) {

        // model.addAttribute("lobbies", this.gestionMessages.getLobbies());

        return "back-officeRest";
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

   @RequestMapping(value = "messages/{salon}", method = RequestMethod.GET)
   @ResponseBody
   public List<Message> listeMessages(@PathVariable String salon, Model model) {
       List<Message> liste = this.gestionMessages.getMessagesList(salon);

       return liste;
   }

    @RequestMapping(value = "messages/{salon}", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String listeMessageshtml(@PathVariable String salon, Model model) {
        List<Message> liste = this.gestionMessages.getMessagesList(salon);

        String s =  "<head><body><h1>Nom du salon: " + salon + "</h1>"
                + "<br><h2>Messages :</h2><br>";

        if (liste == null)
            return s;

        for (Message l : liste)
        {
            s += l.toString() + "<br>";
        }

        return s;
    }


    @RequestMapping(value = "/messages/{salon}/{messageNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Message getMessage(@PathVariable String salon, @PathVariable Integer messageNumber, Model model) {
        List<Message> list = this.gestionMessages.getMessagesList(salon);

        if (list != null && list.size() > messageNumber) {
            return list.get(messageNumber);
        }

        return null;
    }

    @RequestMapping(value = "/messages/{salon}/{messageNumber}", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String getMessagehtml(@PathVariable String salon, @PathVariable Integer messageNumber, Model model) {
        List<Message> list = this.gestionMessages.getMessagesList(salon);


        if (list != null && list.size() > messageNumber) {
            return "<h1>Le message numéro " + messageNumber + " est : </h1><br>" + list.get(messageNumber).toString() + "<div><a href='/Chat/back-office/'>Retour à l'accueil du back office</a></div>";

        }

        return "<h1> Message inexistant </h1> <div><a href='/Chat/back-office/'>Retour à l'accueil du back office</a></div>";
    }

    @RequestMapping(value = "messages/{salon}/nb", method = RequestMethod.GET)
    @ResponseBody
    public int nbMessage(@PathVariable String salon, Model model) {
        List<Message> liste = this.gestionMessages.getMessagesList(salon);

        return liste.size();
    }

    @RequestMapping(value = "messages/{salon}/nb", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String nbMessagehtml(@PathVariable String salon, Model model) {
        List<Message> liste = this.gestionMessages.getMessagesList(salon);

        return "<h1> Nombre de message du salon " + salon + ": " + liste.size() + "</h1> <div><a href='/Chat/back-office/'>Retour à l'accueil du back office</a></div>";
    }

    @RequestMapping(value = "/messages/{salon}/from/{messageNumber}", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> messageFrom(@PathVariable String salon, @PathVariable Integer messageNumber, Model model) {
        List<Message> list = this.gestionMessages.getMessagesList(salon);
        List<Message> res = new ArrayList<Message>();

        for (int i = messageNumber + 1; i < list.size(); i++) {
            res.add(list.get(i));
        }

        return res;
    }

    @RequestMapping(value = "/messages/{salon}/from/{messageNumber}", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String messageFromhtml(@PathVariable String salon, @PathVariable Integer messageNumber, Model model) {
        List<Message> list = this.gestionMessages.getMessagesList(salon);

        String s = "";

        for (int i = messageNumber + 1; i < list.size(); i++) {
            s += list.get(i).toString() + "<br>";
        }

        return s;
    }

    @RequestMapping(value = "messages/{salon}/add", method = RequestMethod.POST)
    @ResponseBody
    public Message ajoutMessage(@PathVariable String salon, @RequestParam(value = "user") String username, @RequestParam(value = "message") String message, Model model) {
        List<Message> liste = this.gestionMessages.getMessagesList(salon);
        if (liste == null) {
            return null;
        }

        Message m = new Message(GestionUsersBean.getUser(username), message);

        if (m.getUser() == null)
            return null;

        liste.add(m);

        return m;
    }

    @RequestMapping(value = "messages/{salon}/add", method = RequestMethod.POST, produces = "text/html")
    @ResponseBody
    public String ajoutMessagehtml(@PathVariable String salon, @RequestParam(value = "user") String username, @RequestParam(value = "message") String message, Model model) {
        List<Message> liste = this.gestionMessages.getMessagesList(salon);
        if (liste == null) {
            return "<h1>La liste est vide</h1>";
        }

        Message m = new Message(GestionUsersBean.getUser(username), message);

        if (m.getUser() == null)
            return "<h1>L'utilisateur est inexistant</h1>";

        liste.add(m);

        return m.toString();
    }

   /*@RequestMapping(value = "messages/{salon}/del", method = RequestMethod.DELETE)
    @ResponseBody
    public Salon del(@PathVariable String salon, Model model) {
        updateLastModified();
        return gestionMessages.deleteLobby(salon);
    }

    @RequestMapping(value = "messages/{lobbyName}/del", method = RequestMethod.DELETE, produces = "text/html")
    @ResponseBody
    public String delhtml(@PathVariable String lobbyName, Model model) {
        updateLastModified();

        Salon salon = messages.deleteLobby(lobbyName);

        String s =  "<head><body><h1>Nom du salon supprimé : " + lobbyName + "</h1>"
                + "<br><h2>Messages :</h2><br>";

        for (Message m : salon.getMessages())
        {
            s += m.toString() + "<br>";
        }

        return s;
    }

    @RequestMapping(value = "messages/{lobbyName}/delLast", method = RequestMethod.DELETE)
    @ResponseBody
    public Message deleteLastMessage(@PathVariable String lobbyName, Model model) {
        if (messages.getMessageNumber(lobbyName) <= 0) {
            return null;
        }

        Message m = messages.getMessages(lobbyName).get(messages.getMessageNumber(lobbyName) - 1);
        messages.getMessages(lobbyName).remove(messages.getMessageNumber(lobbyName) - 1);

        updateLastModified();

        return m;
    }

    @RequestMapping(value = "messages/{lobbyName}/delLast", method = RequestMethod.DELETE, produces = "text/html")
    @ResponseBody
    public String deleteLastMessagehtml(@PathVariable String lobbyName, Model model) {
        if (messages.getMessageNumber(lobbyName) <= 0) {
            return "<h1>Le message est inexistant</h1>";
        }

        Message m = messages.getMessages(lobbyName).get(messages.getMessageNumber(lobbyName) - 1);
        messages.getMessages(lobbyName).remove(messages.getMessageNumber(lobbyName) - 1);

        updateLastModified();

        return m.toString();
    }

    @RequestMapping(value = "messages/{lobbyName}/upLast", method = RequestMethod.PUT)
    @ResponseBody
    public Message updateLastMessage(@PathVariable String lobbyName, @RequestParam(value = "message") String message, Model model) {
        if (messages.getMessageNumber(lobbyName) <= 0) {
            return null;
        }

        Message m = messages.getMessages(lobbyName).get(messages.getMessageNumber(lobbyName) - 1);
        m.setMessage(message);

        updateLastModified();

        return m;
    }

    @RequestMapping(value = "messages/{lobbyName}/upLast", method = RequestMethod.PUT, produces = "text/html")
    @ResponseBody
    public String updateLastMessagehtml(@PathVariable String lobbyName, @RequestParam(value = "message") String message, Model model) {
        if (gestionMessages.getMessageNumber(lobbyName) <= 0) {
            return "<h1>Le message est inexistant</h1>";
        }

        Message m = gestionMessages.getMessagesList(lobbyName).get(gestionMessages.getMessageNumber(lobbyName) - 1);
        m.setMessage(message);

        updateLastModified();

        return m.toString();
    }*/




   /* @PostMapping("/ajoutMessage")
    public @ResponseBody Message ajoutMessage(@RequestParam(name="name") String name,@RequestParam(name="usr") String usr,@RequestParam(name="text") String text,@RequestParam(name="num") int num) {
        //int num = gestionMessages.getMessageNumber(name)+1;
        Message msg = new Message(usr,text,num);
        gestionMessages.setMessage(msg,name);
        return msg;
    }*/
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
