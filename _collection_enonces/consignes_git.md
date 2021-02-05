---
layout: page
title: Configuration eclipse et Git
excerpt: Configuration initiale du projet (eclipse, gitlab)
permalink: /config_git/
---

# Configuration d'Eclipse et GIT pour le module de POO

* Lancer eclipse-java

* Créer un workspace dans le dossier W : `W:\workspaceJava`

![Workspace](/img/git_config/A_Workspace.png)

* Dans eclipse, créer un nouveau projet nommé POO_IUT qui contiendra une première classe (HelloWorld) en suivant les indications de la vidéo ci-dessous

{% assign youtube_id = 'r5Y5tPb9w4Y' %}
{% include video.html %}

* Effectuer un clic droit sur le projet (POO_IUT dans la fenêtre Package Explorer - pas sur le fichier java) et choisir Team, puis Share Project...

![Team_share](/img/git_config/C-Team_share.png)

* Dans la fenêtre de configuration du dépôt GIT, cliquer sur le bouton Create...

![ConfigureGitRepo](/img/git_config/D-ConfigureGitRepo.png)

* Saisir le chemin `W:\git\poo`

![CreateLocalRepo](/img/git_config/F-CreateLocalRepo.png)

* Cliquer sur Finish

![ConfigLocalRepo](/img/git_config/G-ConfigLocalRepo.png)


* Effectuer un clic droit sur le projet, aller dans le menu Team et sélectionner Commit...

![Commit](/img/git_config/H-Commit.png)

* Agrandir le panneau du bas pour mieux visualiser le contenu de l'onglet Git Staging

![Commit](/img/git_config/I-Commit.png)

* Cliquer sur le bouton contenant deux signes `+` pour déplacer les fichier de la zone Unstaged Changes vers la zone Staged Changes

![Commit](/img/git_config/J-Commit.png)

* Saisir le message `Initial commit` dans la zone de text Commit Message

![Commit](/img/git_config/K-Commit.png)

* Cliquer sur le bouton `Commit and Push...` Le panneau suivant (Destination Git Repository) doit s'ouvrir :

![Push](/img/git_config/L-Push.png)

* Retourner dans le navigateur et vous rendre sur la page du projet Gitlab. Après avoir cliqué sur le bouton Clone (en bleu), cliquer sur l'icône permettant de copier l'URL (https)

![Copy_URL](/img/git_config/M-Copy_URL.png)

* Coller cette URL dans le champ URI du panneau Destination Git Repository d'eclipse et compléter les champs User et Password (avec vos identifiants CAS). Il est possible de cocher la case Store in Secure Store pour ne pas avoir à retaper le mot de passe à chaque fois. Puis cliquer sur Next (si eclipse propose d'ajouter des questions de sécurité pour récupérer le mot de passe, cliquer sur Cancel)

![ConfigRemote](/img/git_config/N-ConfigRemote.png)

* Cliquer sur Next

![ConfigRemote](/img/git_config/O-ConfigRemote.png)

* Cliquer sur Finish

![ConfigRemote](/img/git_config/P-ConfigRemote.png)

* Le message Pushed to ... doit s'afficher pour dire que le push s'est bien passé. Cliquer sur Close.

![Push](/img/git_config/Q-Push.png)

* La fenêtre doit maintenant se présenter comme sur l'image ci-dessous.

![Push](/img/git_config/R-Push_fin.png)

* En rafraîchissant la page du dépôt Gitlab, on doit maintenant voir le dernier commit avec l'ensemble des fichiers qui ont été poussés

![Vue_gitlab](/img/git_config/S-Vue_gitlab.png)

Remarques :

* **Ne pas modifier le dépôt depuis l'interface web : pas de suppression, renommage, modification du code. Tout doit se faire depuis eclipse sous peine de désynchroniser les deux dépôts (local et distant) et de devoir procéder à une resynchronisation avec une résolution des éventuels conflits !**

* Il est possible d'ouvrir dans eclipse une perspective Git (dans le même esprit que la perspective de Debug qui sera vue dans le premier TP). Cette perspective présente un groupe de fenêtres dédiées à la gestion de Git. Cela permet de diminuer la taille de la fenêtre du bas dans la perspective de développement (Java) pour laisser plus de place au code.

* Effectuer un commit et un push à chaque exercice terminé en indiquant clairement dans le message de commit le nom de l'exercice qui a été complété.

* Le menu Team propose un menu qui permet de faire un Push si la dernière modification a été faite en cliquant sur Commit plutôt que sur Commit and Push.

[Suite...]({{site.baseurl}}/enonces/tp1)
