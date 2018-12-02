> Auteurs : Elodie MONTCARMEL (11710323) & Gabriello ZAFIFOMENDRAHA (11311399)

TP2 - Chat de base
===


Le but de ce TP est de développer une application WEB de chat. 

Chaque utilisateur doit entrer un pseudo ainsi qu'un nom de salon afin de s'y connecter. 
De ce salon il peut envoyer des messages et voir ceux envoyés par les personnes connectées à ce même salon.


Choix d'implémentation
---

Dans certaines questions, plusieurs choix d'implémentation étaient possibles. 

Concernant le refresh des pages toutes les 5 secondes, nous avons choisi de le mettre dans le header de la page.

Pour la partie "Refactoring de l'application", nous avons choisi d'utiliser le "MVC Pull-based" car c'est cette méthode qui nous a semblé la plus simple et la plus intuitive dans la façon dont on devait l'implémenter.


TP3 - Spring MVC
===

Dans ce TP nous avons continué le chat du TP précédent en lui ajoutant une partie back office. 
Pour tester chaque fonctionnalité il faut entrer une URL spécifique :

* L'URL pour accéder à la liste des messages d'un salon est : `.../test/back-office/salon?name=nomDuSalon`

* L'URL pour accéder à un message spécifique est : `.../test/back-office/message?name=nomDuSalon&num=numeroDuMessage`


Ensuite pour permettre à un utilisateur d'utiliser le chat, il faut d'abord l'ajouter en cliquant sur le lien "Ajouter un utilisateur" à l'accueil du chat.
L'utilisateur est alors renvoyé vers un formulaire où l'on peut préciser un pseudo pour l'ajouter à la liste des utilisateurs.

TP4 - REST
===

Le but de ce tp est d'apporter une interface REST à notre application.

Pour cela nous avons ajouté, comme demandé, les différentes requêtes vers des ressources de notre chat. Les URLs pour y accéder sont les suivantes :

* Récupérer pseudo et liste des salons auxquels l'utilisateur a participé : `curl -X GET localhost:8080/tpRest/test/back-officeRest/user/nomUtilisateur` 

* Modifier le pseudo : `curl -X PUT localhost:8080/tpRest/test/back-officeRest/user/updateName/ancienNom/NouveauNom `

* Récupérer la liste des messages : `curl -X GET localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon` 

* Récupérer le nombre de messages : `curl -X GET localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon/nb`

* Récupérer tous les messages envoyés après un id données : `curl -X GET localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon/from/idDuMessage `

* Ajouter un message :` curl -X POST -d "user=nomUtilisateur" -d "message=message" localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon/add `

* Supprimer un salon : `curl -X DELETE localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon/del `

* Récupérer les informations du message (auteur, texte) :` curl -X GET localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon/numeroDuMessage `
 
* Modifier le contenu du dernier message d'un salon : `curl -X PUT localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon/upLast?message=newMessage `

* Supprimer le dernier message d'un salon : `curl -X DELETE localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon/delLast `

Afin de demander le contenu en JSON, en ligne de commande il est possible de faire comme cela : `curl -X GET -H "Accept:application/json" localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon`

De même pour demander le contenu en XML : `curl -X GET -H "Accept:application/xml" localhost:8080/tpRest/test/back-officeRest/messages/nomDuSalon`

Si rien n'est précisé, le contenu est renvoyé en HMTL


Le filtre à été modifié mais ne marche pas complètement. Si l'utilisateur ne rentre aucun des champs(pseudo et salon) il est quand même redirigé sur l'interface mais ne peut pas ajouter de message.
Seuls les utilisateurs ajoutés à la liste peuvent se connecter et ajouter des messages au salon créé.
