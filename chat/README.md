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

Pour la partie "Refactoring de l'application", nous avons choisi d'utiliser le pattern "MVC Pull-based" car cette méthode nous a semblé la plus simple à implémenter.


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

* Récupérer la liste des messages : `curl -X GET localhost:8080/tpRest/test/back-officeRest/salon/nomDuSalon` 

* Récupérer le nombre de messages : `curl -X GET localhost:8080/tpRest/test/back-officeRest/salon/nomDuSalon/nb`

* Récupérer tous les messages envoyés après un id données : `curl -X GET localhost:8080/tpRest/test/back-officeRest/salon/nomDuSalon/from/idDuMessage `

* Ajouter un message :` curl -X POST -d "user=nomUtilisateur" -d "message=message" localhost:8080/tpRest/test/back-officeRest/salon/nomDuSalon/add `

* Supprimer un salon : `curl -X DELETE localhost:8080/tpRest/test/back-officeRest/salon/nomDuSalon/del `

* Récupérer les informations du message (auteur, texte) :` curl -X GET localhost:8080/tpRest/test/back-officeRest/message/nomDuSalon/numeroDuMessage `
 
* Modifier le contenu du dernier message d'un salon : `curl -X PUT localhost:8080/tpRest/test/back-officeRest/message/nomDuSalon/upLast?message=newMessage `

* Supprimer le dernier message d'un salon : `curl -X DELETE localhost:8080/tpRest/test/back-officeRest/message/nomDuSalon/delLast `

Afin de demander le contenu en JSON, en ligne de commande il est possible de faire comme cela : `curl -X GET -H "Accept:application/json" localhost:8080/tpRest/test/back-officeRest/salon/nomDuSalon`

De même pour demander le contenu en XML : `curl -X GET -H "Accept:application/xml" localhost:8080/tpRest/test/back-officeRest/salon/nomDuSalon`

Si rien n'est précisé, le contenu est renvoyé en HMTL


Le filtre à été modifié et est à présent fonctionnel.



TP5 : AJAX 
===

Le but de ce TP est de traiter des données reçues de manière asynchrone côté client.

Pour cela, il nous fallait refaire une version de notre application. Nous l'avons donc ajouté dans l'accueil du chat, en-dessous de l'ancienne version. 
De cette façon, nous pouvons utiliser les 2 versions de notre chat.

Dans la nouvelle version, il ne faut plus entrer de nom de salon, il suffit de se connecter avec son pseudo. De cette manière, nous accédons à une page qui permet de voir la liste des salons disponibles, mais aussi de créer de nouveau salons.

Nous pouvons également accéder à chaque salon en cliquant sur ceux-ci dans la liste des salons. Une fois connecté au salon, nous accédons à la liste des messages, et il est également possible d'en envoyer des nouveaux. 

Enfin, il est possible de supprimer le dernier message d'une conversation, mais pas de le modifier. 

Pour accéder à l'application il faut renseigner l'url : `localhost:8080/tpAjax`
