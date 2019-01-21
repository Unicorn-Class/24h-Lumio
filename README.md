# 24h du code 2019 - Unicorn.class

# Le sujet

Dans le cadre de ce sujet porté par le Haum nous devions prendre en main un ensemble de Laumio1 et de capteurs. Les laumios étaient dans un espace commun à toutes les équipes que nous devions partager. Le Haum avait également mis à notre disposition une documentation détaillée2.

Des séances collectives ont eu lieu tout au long de l&#39;événement pour faire le point et discuter des avancées.

Un canal IRC était également mis à disposition pour la communication.

## Les attentes

Dans un premier temps nous devions être capable de réaliser 6 actions de bases :

- Choisir la couleur des laumios.​
- Être capable d&#39;animer les laumios.​
- Gérer l&#39;allumage des laumios individuellement et par groupe. ​
- Réagir à des sources extérieures​
- Proposer une interface pour agir facilement avec l&#39;installation. ​
- Permettre de programmer soi-même des réactions aux événements. ​

Ensuite nous devrions implémenter différentes fonctions :

- La réaction à des sources extérieures.
- Une interface pour interagir facilement avec l&#39;installation.
- Une interface permettant de programmer soi-même des réactions aux événements.

## Technologies Utilisées

Nous avons développé une application Java proposant un serveur web Spring. Les pages web ont été réalisées en HTML, CSS et Javascript, ainsi que ThymeLeaf qui a été utilisé pour afficher certaines données au sein des pages web.

## Nos réalisations

Tout notre code source est disponible à l&#39;adresse [https://github.com/Unicorn-Class/24h-Lumio](https://github.com/Unicorn-Class/24h-Lumio)

Nos principales réalisations présentées à la démonstration ont été :

- Une interface de récupération de la météo d&#39;une ville via l&#39;api REST OpenWeatherMap3 et affichage lumineux du laumio en conséquence​.
- Une interface de monitoring présentant sous forme de graphiques les informations des différents capteurs​.
- Une Interface web de commande des différents laumios.​
- Un système d&#39;envoi d&#39;humeur au laumio, chaque humeur affichant une couleur différente sur le laumio du destinataire​.
- Une interface web d&#39;ajout de différentes animations​
- Un jeu de morpion et une memory contrôlable via la télécommande.
- Un système permettant de gérer la musique.



Nous avions en plus prévu d&#39;implémenter un jeu de Simon, une interface de gestion de la musique ainsi qu&#39;un système d&#39;allumage du laumio suivant les notifications reçu par mail ou via les réseaux sociaux, mais par manque de temps nous n&#39;avons pas pu les implémenter.

# Organisation

## Outils utilisés

Nous avons utilisé Sharepoint pour le partage des documents et URL utiles.

Le partage de snippets (lignes de codes) s&#39;est fait via [https://gist.github.com](https://gist.github.com).

Pour la gestion de versions, nous avons utilisé Github à l&#39;aide du logiciel GitKraken.

Nous avons également eu la chance d&#39;être placé à coté d&#39;un tableau que nous avons beaucoup utilisé, notamment en tant que Scrum Board.

Pour les tests en local, nous avons mis en place un serveur sur un Rapsberry Pi avec le broker MQTT Mosquitto.

Pour les tests d&#39;API, nous avons utilisé Postman

Nous avions décidé auparavant de travailler avec l&#39;IDE IntelliJ et d&#39;utiliser Java 8.

## Répartition des tâches

Dans un premier temps nous avons découpées les taches de bases en éléments atomiques : Axel s&#39;est occupé de la création du projet, de l&#39;installation du broker sur le Raspberry Pi et de l&#39;allumage individuel des LED, Afua de celui des anneaux, Elodie des couleurs, Nicolas du lancement des animations déjà configurées pendant que Victor s&#39;occupait de la création de nouvelles animations.

Nous avons ensuite pris en main les capteurs, puis nous nous sommes répartis en deux équipes : Axel et Elodie se sont chargés des interfaces web pendant que Afua, Nicolas et Victor travaillaient directement sur les laumios pour mettre en place d&#39;autres animations, la musique et la météo.

Problèmes rencontrés

Du fait du nombre d&#39;équipes important sur ce sujet (17) il fallait souvent patienter pour tester le code réalisé ou alors risquer de voir sa séquence interrompue par le lancement de celle d&#39;une autre équipe.

Nous avons eu également quelques problèmes avec Git, notamment des fichiers de configuration qui sont passés à travers le Gitignore. Sur certaines machines, GitKraken ne voulait pas afficher ni obtenir les derniers commits : c&#39;est notamment pourquoi Afua a dû utiliser un ordinateur que nous avions prévu en supplément.

Ressenti

Nous sommes globalement satisfaits de notre travail. Le sujet, nous laissant libre choix d&#39;imaginer des animations et des scénarios nous a permis de réfléchir et développer notre créativité.

Cependant nous avons trouvé le sujet assez difficile à appréhender car assez différent de ce que nous avions pu faire en préparation.

# Jetons

Une des nouveautés de cette année était la mise en place de jetons en guise de « monnaie d&#39;échange » pour favoriser l&#39;entraide et la collaboration entre les équipes. Chaque équipe disposait de 24 jetons au début de l&#39;évènement, qui pouvaient être dépensés contre de l&#39;aide auprès des autres équipes ou des porteurs de sujets.

Durant les 24 heures, notre équipe a fourni des conseils à d&#39;autres équipes participantes. Au début, nous demandions 1 jeton contre cette aide afin de respecter les consignes mises en place. Puis, lorsque certaines équipes était bloquées à des étapes que nous avions franchis depuis plusieurs heures, nous les avons aidés gratuitement afin qu&#39;elles puissent continuer leur projet. Certaines équipes sont donc alors venues nous remercier en nous donnant des jetons que nous n&#39;avions pas demandé. Ainsi, nous avons terminé les 24h du code avec 31 jetons, soit 7 de plus qu&#39;initialement.
