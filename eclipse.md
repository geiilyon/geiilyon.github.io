---
layout: page
title: Eclipse
excerpt: Raccourcis claviers et astuces.
permalink: /eclipse/
---

# Utilisation du debugger

Exemple d'utilisation du debugger sur l'exemple vu en cours des références sur des objets de type Porte ([lien SPIRAL](http://spiralconnect.univ-lyon1.fr/webapp/player/HtmlVideoPlayer.html?idMedia=4025592&typeMedia=false)).

<video width="60%" height="100%" controls>
  <source src="http://spiralconnect.univ-lyon1.fr/spiral-files/download?mode=inline&data=4025592" type="video/mp4">
  <source src="http://spiralconnect.univ-lyon1.fr/spiral-files/download?mode=inline&data=4025593" type="video/webm">
  Your browser does not support the video tag.
</video>


Eclipse utilise le concept de *perspective* : dans la vidéo ci-dessus, le lancement du debugger provoque le passage dans la perspective debug et à la fin de la session de debuggage on revient à la perspective *Java*. Une perspective correspond à un ensemble de vues adaptées à une activité : développement, debuggage, gestion de versions, recherche de bugs par analyse statique du code...

# Raccourcis clavier

* <kbd>Ctrl</kbd>+<kbd>Espace</kbd> : complétion automatique

* <kbd>Ctrl</kbd>+<kbd>D</kbd> : supprime la ligne entière

* <kbd>Alt</kbd>+<kbd>Shift</kbd>+<kbd>R</kbd> : renommage intelligent (Refactor->Rename), permet de renommer une variable, une méthode, une classe en prenant soin de modifier tous les endroits du code où le nom apparaît (renomme même le fichier .java en cas de changement de nom de la classe).

* <kbd>Ctrl</kbd>+<kbd>Shift</kbd>+<kbd>F</kbd> : mise en forme du code source (corrige l'indentation, les sauts de lignes, l'emplacement des accolades, les lignes trop longues, ...)

* <kbd>Ctrl</kbd>+<kbd>Shift</kbd>+<kbd>O</kbd> : organise les imports (ajoute tous les imports de packages nécessaires)

* <kbd>Ctrl</kbd>+<kbd>Shift</kbd>+<kbd>T</kbd> : ouvre rapide d'une classe ou une interface

# Astuces

* <kbd>Ctrl</kbd>+clic sur une variable ou une méthode permet de sauter à sa définition.

* Utiliser les suggestions de corrections d'erreurs d'Eclipse pour générer le code manquant ou corriger des erreurs de programmation.

* Eclipse compile les fichiers lors de leur sauvegarde.

* Dans une boite de dialogue, taper les différents majuscules du nom de la classe (ou méthode)

    ![completion partielle](/img/majCompletion.png)

* Lors de l'exécution si une boîte de dialogue demande les ressources à sauvegarder, cocher la case "*Always save resources before launching*"

    ![Always save resources dialog](/img/AlwaysSaveResources.png)

* Pour ajouter des fichiers sources à un projet Java existant, les faire glisser depuis l'explorateur de fichiers directement sur la fenêtre package explorer d'Eclipse et sélectionner l'option permettant de les copier dans le répertoire du projet.

