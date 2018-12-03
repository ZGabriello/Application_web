package fr.univlyon1.m1if.m1if03.tp4.controller;

import fr.univlyon1.m1if.m1if03.tp2.Modele.GestionMessages;
import fr.univlyon1.m1if.m1if03.tp2.Modele.Message;
import fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.Salon;
import fr.univlyon1.m1if.m1if03.tp3.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/back-officeRest/*")
public class BOController {

    @Autowired
    private ServletContext servletContext;
    private GestionMessages gestionMessages;

    public BOController() {

        this.gestionMessages = new GestionMessages();
    }

    @RequestMapping(value = "user/{pseudo}", method = RequestMethod.GET)
    @ResponseBody
    public UserBean salonParticipate(@PathVariable("pseudo") String pseudo) {
        return GestionUsersBean.getUser(pseudo);
    }

    @RequestMapping(value = "user/{pseudo}", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String salonParticipatehtml(@PathVariable("pseudo") String pseudo) {
        String s = "<h1>" + GestionUsersBean.getUser(pseudo).getPseudo() + " a participé aux salons :</h1>";

        if (GestionUsersBean.getUser(pseudo).getSalons().isEmpty())
        {
            s = "<h1>" + GestionUsersBean.getUser(pseudo).getPseudo() + " n'a participé à aucun salon</h1>";
        }
        for (String salon : GestionUsersBean.getUser(pseudo).getSalons())
        {
            s += "- " + salon + "<br>";
        }

        return s;
    }

    @RequestMapping(value = "user/updateName/{pseudo}/{newname}", method = RequestMethod.PUT)
    @ResponseBody
    public UserBean modifPseudo(@PathVariable("newname") String newName, @PathVariable("pseudo") String pseudo) {

        UserBean u = GestionUsersBean.getUser(pseudo);
        if (u == null)
            return null;

        u.setPseudo(newName);

        return u;
    }

    @RequestMapping(value = "user/updateName/{pseudo}/{newname}", method = RequestMethod.PUT, produces = "text/html")
    @ResponseBody
    public String modifPseudohtml(@PathVariable("newname") String newName, @PathVariable("pseudo") String pseudo) {

        UserBean usr = GestionUsersBean.getUser(pseudo);
        if (usr == null)
            return "<h1>L'utilisateur est inexistant</h1>";

        usr.setPseudo(newName);

        return usr.getPseudo().toString();
    }


    @RequestMapping(value = "users/add", method = RequestMethod.POST)
    public UserBean postUsers(@RequestParam("username") String nomUtilisateur, Model model) {
        model.addAttribute("requete", "POST");

        for (UserBean u : GestionUsersBean.getUsersList()) {
            if (u.getPseudo().equals(nomUtilisateur)) {
                model.addAttribute("user", "dejaPresentDansLaListe");

                return u;
            }
        }

        GestionUsersBean.addUser(nomUtilisateur);
        model.addAttribute("user", nomUtilisateur);

        return GestionUsersBean.getUser(nomUtilisateur);
    }

    @RequestMapping(value = "users/add", method = RequestMethod.POST, produces = "text/html")
    @ResponseBody
    public String postUsershtml(@RequestParam("username") String nomUtilisateur, Model model) {
        for (UserBean u : GestionUsersBean.getUsersList()) {
            if (u.getPseudo().equals(nomUtilisateur)) {

                return "<h1>L'utilisateur est déjà dans la liste</h1>";
            }
        }
        GestionUsersBean.addUser(nomUtilisateur);

        return "<h1>L'utilisateur "+ GestionUsersBean.getUser(nomUtilisateur) + " a bien été ajouté à la liste</h1>";
    }

   @RequestMapping(value = "salon/{salon}", method = RequestMethod.GET)
   @ResponseBody
   public List<Message> listeMessages(@PathVariable String salon, Model model) {
       List<Message> liste = this.gestionMessages.getMessagesList(salon);

       return liste;
   }

    @RequestMapping(value = "salon/{salon}", method = RequestMethod.GET, produces = "text/html")
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


    @RequestMapping(value = "salon/{salon}/nb", method = RequestMethod.GET)
    @ResponseBody
    public int nbMessage(@PathVariable String salon, Model model) {
        List<Message> liste = this.gestionMessages.getMessagesList(salon);

        return liste.size();
    }

    @RequestMapping(value = "salon/{salon}/nb", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String nbMessagehtml(@PathVariable String salon, Model model) {
        List<Message> liste = this.gestionMessages.getMessagesList(salon);

        return "<h1> Nombre de message du salon " + salon + ": " + liste.size() + "</h1> ";
    }

    @RequestMapping(value = "/salon/{salon}/from/{messageNumber}", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> messageFrom(@PathVariable String salon, @PathVariable Integer messageNumber, Model model) {
        List<Message> list = this.gestionMessages.getMessagesList(salon);
        List<Message> res = new ArrayList<Message>();

        for (int i = messageNumber + 1; i < list.size(); i++) {
            res.add(list.get(i));
        }

        return res;
    }

    @RequestMapping(value = "/salon/{salon}/from/{messageNumber}", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String messageFromhtml(@PathVariable String salon, @PathVariable Integer messageNumber, Model model) {
        List<Message> list = this.gestionMessages.getMessagesList(salon);

        String s = "";

        for (int i = messageNumber + 1; i < list.size(); i++) {
            s += list.get(i).toString() + "<br>";
        }

        return s;
    }

    @RequestMapping(value = "salon/{salon}/add", method = RequestMethod.POST)
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

    @RequestMapping(value = "salon/{salon}/add", method = RequestMethod.POST, produces = "text/html")
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

   @RequestMapping(value = "salon/{salon}/del", method = RequestMethod.DELETE)
    @ResponseBody
    public Salon supprimerSalon(@PathVariable String salon, Model model) {

        return gestionMessages.deleteSalon(salon);
    }

    @RequestMapping(value = "salon/{salon}/del", method = RequestMethod.DELETE, produces = "text/html")
    @ResponseBody
    public String supprimerSalonhtml(@PathVariable String salon, Model model) {

        Salon sl = gestionMessages.deleteSalon(salon);

        String s =  "<head><body><h1>Salon " + salon + "supprimé : " + "</h1>"
                + "<br><h2>Messages :</h2><br>";

        for (Message m : sl.getMessages())
        {
            s += m.toString() + "<br>";
        }

        return s;
    }

    @RequestMapping(value = "/message/{salon}/{messageNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Message getMessage(@PathVariable String salon, @PathVariable Integer messageNumber, Model model) {
        List<Message> list = this.gestionMessages.getMessagesList(salon);

        if (list != null && list.size() > messageNumber) {
            return list.get(messageNumber);
        }

        return null;
    }

    @RequestMapping(value = "/message/{salon}/{messageNumber}", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String getMessagehtml(@PathVariable String salon, @PathVariable Integer messageNumber, Model model) {
        List<Message> list = this.gestionMessages.getMessagesList(salon);


        if (list != null && list.size() > messageNumber) {
            return "<h1>Le message numéro " + messageNumber + " est : </h1><br>" + list.get(messageNumber).toString();

        }

        return "<h1> Message inexistant </h1>" ;
    }


    @RequestMapping(value = "message/{salon}/delLast", method = RequestMethod.DELETE)
    @ResponseBody
    public Message supprLastMessage(@PathVariable String salon, Model model) {
        if (gestionMessages.getMessageNumber(salon) <= 0) {
            return null;
        }

        Message msg = gestionMessages.getMessagesList(salon).get(gestionMessages.getMessageNumber(salon) - 1);
        gestionMessages.getMessagesList(salon).remove(gestionMessages.getMessageNumber(salon) - 1);

        return msg;
    }

    @RequestMapping(value = "message/{salon}/delLast", method = RequestMethod.DELETE, produces = "text/html")
    @ResponseBody
    public String supprLastMessagehtml(@PathVariable String salon, Model model) {
        if (gestionMessages.getMessageNumber(salon) <= 0) {
            return "<h1>Le message est inexistant</h1>";
        }

        Message msg = gestionMessages.getMessagesList(salon).get(gestionMessages.getMessageNumber(salon) - 1);
        gestionMessages.getMessagesList(salon).remove(gestionMessages.getMessageNumber(salon) - 1);


        return msg.toString();
    }

    @RequestMapping(value = "message/{salon}/upLast", method = RequestMethod.PUT)
    @ResponseBody
    public Message modifLastMessage(@PathVariable String salon, @RequestParam(value = "message") String message, Model model) {
        if (gestionMessages.getMessageNumber(salon) <= 0) {
            return null;
        }

        Message msg = gestionMessages.getMessagesList(salon).get(gestionMessages.getMessageNumber(salon) - 1);
        msg.setTexte(message);

        return msg;
    }

    @RequestMapping(value = "message/{salon}/upLast", method = RequestMethod.PUT, produces = "text/html")
    @ResponseBody
    public String modifLastMessagehtml(@PathVariable String salon, @RequestParam(value = "message") String message, Model model) {
        if (gestionMessages.getMessageNumber(salon) <= 0) {
            return "<h1>Le message est inexistant</h1>";
        }

        Message m = gestionMessages.getMessagesList(salon).get(gestionMessages.getMessageNumber(salon) - 1);
        m.setTexte(message);

        return m.toString();
    }


    /*
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
    	if ((BindException)e != null || (HttpMessageNotReadableException)e != null || (MethodArgumentNotValidException)e != null || (MissingServletRequestParameterException)e != null || (MissingServletRequestPartException)e != null || (TypeMismatchException)e != null) {
    		model.addAttribute("error", 400);
    	}
    	else if ((ConversionNotSupportedException)e != null || (HttpMessageNotWritableException)e != null || (MissingPathVariableException)e != null)
    	{
    		model.addAttribute("error", 500);
    	}
    	else if ((HttpRequestMethodNotSupportedException)e != null) {
    		model.addAttribute("error", 405);
    	}
    	else if ((HttpMediaTypeNotSupportedException)e != null) {
    		model.addAttribute("error", 415);
    	}
    	else if ((HttpMediaTypeNotAcceptableException)e != null) {
    		model.addAttribute("error", 406);
    	}
    	else
    		model.addAttribute("error", 404);

        System.out.println("ERROR HANDLER");
    	return "error-page";
    }
*/

}
