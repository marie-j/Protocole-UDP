Mercier Tony
Jones Marie

TP1 Réseaux : Protocole UDP 

Multicast 

Q1 : 

Pour émettre un paquet UDP en multicast il faut d'abord encoder le message puis envoyer le paquet crée à l'aide de ce message sur une socket multicast créée qui sera ensuite fermée

Pour recevoir un paquet, en revanche , il faut d'abord rejoindre le groupe auquel correspond l'adresse du multicast avant de recevoir le paquet et le décoder 

Q2 : 
Pour l'émission, il faut gérer le cas où l'adresse sur laquelle on essaye de se connecter n'est pas multicast. Dans notre cas , l'adresse est donnée , pas besoin de vérification. 
Si l'adresse était saisie par l'utilisateur il faudrait initialiser l'adresse à null dans un premier cas (pour supprimer les warnings de non initialisation) et sortir du programme si l'adresse n'est
pas valide.


Programme de Tchat 

Q1 : 
On utilise les threads pour créer plusieurs actions simultanée: un sera chargé de recevoir les paquets et l'autre de les envoyer.

Q2: 
Pour associer un nom d'utilisateur au message reçu , il faut récupérer l'adresse associé au paquet envoyé ( la SocketAddress) et de cette 
adresse, par la suite récupérer le nom de l'utilisateur.