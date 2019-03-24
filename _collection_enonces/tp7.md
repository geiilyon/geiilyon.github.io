---
title: Machine à café
layout: page
excerpt: Utilisation de l'héritage pour coder une machine d'état.
---

# Interfaces - suite

## Mise en oeuvre : *Design Pattern* Etat - la cafetière Sensespresso (le retour)

L'approche orientée objet de la programmation d'une machine d'état consiste à définir une super-classe abstraite possédant une méthode pour chaque évènement auquel le système doit réagir. Cette classe abstraite (ici, `CoffeeMachineState`) peut définir une implémentation par défaut de ces méthodes qui généralement ne fait rien. Cela permet aux sous-classes de ne redéfinir que les méthodes correspondant aux évènements qu'elles souhaitent gérer. Chaque évènement est en effet traité en écrivant une sous-classe spécifique.

La classe principale (ici, `CoffeeMachine`) possède une variable d'instance référençant l'état courant (cette variable est de type `CoffeeMachineState`). Grâce au polymorphisme l'objet référencé est l'une des sous-classe de la classe abstraite `CoffeeMachineState`. Les transitions sont gérées en remplaçant cette référence par une référence vers le nouvel état actif.

* Créer un nouveau projet nommé Sensepresso. Télécharger le [code de la cafetière](/files/Sensespresso.zip), extraire l'archive, sélectionner les dossiers et les **glisser/déposer** sur le dossier *src* du projet Eclipse.

* Télécharger les bibliothèques [SteelSeries.jar](/files/SteelSeries.jar) et [trident.jar](/files/trident.jar) et les copier dans votre projet (avec un glisser/deposer sur le projet). Faire ensuite un clic droit sur chacune d'elle et sélectionner *Build Path* puis *Add To Build Path*

Le diagramme d'état décrivant le fonctionnement de la cafetière est le suivant :

![Cafetiere](/img/Sensespresso.png)


* Suggestion de nommage pour les classes de gestion des différents états :

    * `CoffeeMachineHeatingState`

    * `CoffeeMachineMissingWaterState`

    * `CoffeeMachineOffState`

    * `CoffeeMachinePrepareState`

    * `CoffeeMachineReadyState`


* Compléter la méthode `transitionToState` de la classe `CoffeeMachineState`, puis créer les 5 sous-classes de `CoffeeMachineState` permettant d'assurer le bon fonctionnement de la cafetière selon le diagramme ci-dessous. En fonction du nombre de tasses, la transition entre l'état `CoffeeMachinePrepareState` et l'état `CoffeeMachineHeatingState` se fera à l'aide d'une temporisation de 6 ou 12 secondes selon le nombre de tasses choisies. La temporisation sera gérée à l'aide de la classe `Timer` du package `javax.swing`.

    **Faire valider par un enseignant.**

* Créer une archive (zip) contenant les fichiers sources de votre application dont le nom utilisera le format : G40x_NomDeFamille_Sensespresso.zip. Déposer cette archive sous SPIRAL dans la zone de dépôt Sensespresso v1 du module MC-POO.

