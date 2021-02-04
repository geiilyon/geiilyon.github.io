---
layout: page
title: Configuration eclipse et Git
excerpt: Configuration initiale du projet (eclipse, gitlab)
permalink: /config_git/
---

# Configuration d'Eclipse et GIT pour le module de positions

1. Lancer eclipse-java
2. Créer un workspace dans le dossier W : `W:\workspaceJava`
![Workspace](/img/git_conf/img/git_conf/A-Workspace.png)
3. Dans eclipse, créer un nouveau projet (File->New Java Project) nommé POO_IUT
![Projet](/img/git_conf/B-Projet.png)
4. Effectuer un clic droit sur le projet (dans la fenêtre Package Explorer) et choisir Team, puis Share Project...
![Team_share](/img/git_conf/C-Team_share.png)
5. Dans la fenêtre de configuration du dépôt GIT, cliquer sur le bouton Create...
![Config Repo](/img/git_conf/D-ConfigureGitRepo.png)
1. Saisir le chemin  `W:\git\poo`
![Create local repo](/img/git_conf/F-CreateLocalRepo.png)
8. Cliquer sur Finish
![Config local repo](/img/git_conf/G-ConfigLocalRepo.png)
1. Créer une nouvelle classe java intitulée HelloWorld dans le projet et lui ajouter une méthode main (elle peut rester vide dans un premier temps)
2. Effectuer un clic droit sur le projet, aller dans le menu Team et sélectionner Commit...
![Commit](/img/git_conf/H-Commit.png)
1.  Agrandir le panneau du bas pour mieux visualiser le contenu de l'onglet Git Staging
![Commit](/img/git_conf/I-Commit.png)
1. Cliquer sur le bouton contenant deux signes `+` pour déplacer les fichier de la zone Unstaged Changes vers la zone Staged Changes
![Commit](/img/git_conf/J-Commit.png)
1. Saisir le message `Initial commit` dans la zone de text Commit Message
![Commit](/img/git_conf/K-Commit.png)
1. Cliquer sur le bouton `Commit and Push...` Le panneau suivant (Destination Git Repository), doit s'ouvrir. Ne rien faire pour l'instant
![Push](/img/git_conf/L-Push.png)
1.  Retourner dans le navigateur et vous rendre sur la page du projet Gitlab. Après avoir cliqué sur le bouton Clone (en bleu), cliquer sur l'icone permettant de copier l'URL (https)
![Copy URL](/img/git_conf/M-Copy_URL.png)
1.  Coller cette URL dans le champ URI du panneau Destination Git Repository d'eclipse et compléter les champs User et Password. Il est possible de cocher la case Store in Secure Store pour ne pas avoir à retaper le mot de passe à chaque fois. Puis cliquer sur Next (si eclipse propose d'ajouter des questions de sécurité pour récupérer le mot de passe, cliquer sur annuler)
![Config remote](/img/git_conf/N-ConfigRemote.png)
1. Cliquer sur Next
![Config remote](/img/git_conf/O-ConfigRemote.png)
1. Cliquer sur Finish
![Config remote](/img/git_conf/P-ConfigRemote.png)
1. Le message Pushed to ... doit s'afficher pour dire que le push s'est bien passé. Cliquer sur Close.
![Push](/img/git_conf/Q-Push.png)
1. La fenêtre doit maintenant se présenter comme sur l'image ci-dessous.
![Pushed](/img/git_conf/R-Push_fin.png)
1. En rafraichissant la page du dépôt Giltlab, on doit maintenant voir le dernier commit avec l'ensemble des fichiers qui ont été poussés
![Gitlab](/img/git_conf/S-Vue_gitlab.png)


Remarques :
* Ne pas modifier le dépôt depuis l'interface web : pas de suppression, renommage, modification du code. Tout doit se faire depuis eclipse sous peine de désynchroniser les deux dépôts (local et distant) et de devoir procéder à une resynchronisation avec une résolution des éventuels conflits !
* Il est possible d'ouvrir dans eclipse une perspective Git (dans le même esprit que la perspective de Debug qui sera vue dans le premier TP). Cette perspective présente un groupe de fenêtres dédiées à la gestion de Git. Cela permet de minimiser la fenêtre du bas dans la perspective de développement (Java).
* Effectuer un commit et un push à chaque exercice terminé en indiquant clairement dans le message de commit l'exercice qui a été complété.
* Le menu Team, propose un menu qui permet de faire un Push si la dernière modification a été faite en cliquant sur Commit plutôt que sur Commit and Push.