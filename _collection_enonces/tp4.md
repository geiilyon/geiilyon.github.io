---
title: Héritage - classes abstraites et interfaces
layout: page
excerpt: Pour aller plus loin avec l'héritage (mots clés abstract et interface). Guess the number.
---

# Héritage - suite

## Classes abstraites

Dans l'exemple de la classe `Etudiant` étudié dans la partie précédente, les méthodes `getSeuilCool()`, `getSeuilLoose()`,  `getSeuilPasPire()` et `passerUnPartiel()` avaient besoin d'être définies dans la classe Etudiant seulement dans le but d'être redéfinies dans les sous-classes. Dans ce cas là, pour ne pas être obligé de fournir une implémentation, on peut déclarer ces méthodes comme étant abstraites (`abstract`) :

~~~java
    abstract protected double getSeuilLoose();
~~~

Lorsque l'on déclare une méthode abstraite, on ne fournit pas de corps à la méthode (les sous-classes se chargeront de l'implémenter).

Dès lors qu'elle contient une méthode abstraite une classe doit elle aussi être déclarée abstraite :

~~~java
    public abstract class Etudiant
~~~

En effet, son implémentation étant incomplète, elle ne peut pas être instanciée. On ne peut instancier que des classes concrètes. Les classes abstraites servent à factoriser du code commun ou à définir des types très généraux qui permettront de manipuler des classes concrètes par polymorphisme.

* Modifier les classes précédentes comme indiqué et vérifier qu'il n'est maintenant plus possible de créer d'instance de la classe Etudiant. Vérifier par contre que votre code précédent fonctionne toujours.


## Les interfaces

Les interfaces en Java sont des classes 100% abstraites. Elles définissent un jeu de méthodes qui pourront être appelées sur un objet qui implémente cette interface. Elles permettent de contourner une *limitation de Java* : l'absence d'héritage multiple. En effet une classe Java ne peut étendre qu'une seule classe. Par contre elle peut implémenter autant d'interfaces qu'elle le souhaite.

De très nombreuses classes de la bibliothèque Java s'appuient sur les interfaces. Pour définir une interface on utilise le mot clé `interface`. En cliquant sur la petite flèche située à côté du bouton de création d'une classe, on peut choisir de créer une nouvelle `interface`. Une interface est définie de la même manière qu'une classe, dans un fichier *.java* portant le même nom que l'interface.

* Créer une interface `UserInterface`qui définira les méthodes `displayMessage` et `getUserInputString` pour afficher un message et demander une entrée à l'utilisateur (le paramètre `query` est utilisé pour afficher la question à poser à l'utilisateur avant d'attendre sa réponse qu'elle retournera) :

  ~~~java
    public interface UserInterface {

        public void displayMessage(String message);

        public String getUserInputString(String query);
    }

  ~~~
    
    L'idée est de définir une interface commune pour différentes classes qui permettront d'interagir avec l'utilisateur (en mode console et avec des boîtes de dialogue). La classe `GuessTheNumber` implémentera la logique du jeu et possédera une référence vers un objet de type `UserInterface` pour afficher des messages et récupérer des saisies de l'utilisateur.
    
    ![GuessTheNumberClassDiagram](/img/GuessTheNumber.png)
    ![Legende Eclispe UML](/img/EclipseUmlLegend.png)

* Créer une classe `ConsoleUserInterface` qui implémente l'interface `UserInterface`. Les messages seront affichés sur la sortie standard et les entrées proviendront de l'entrée standard.

  ~~~java
    public class ConsoleUserInterface implements UserInterface
  ~~~

* Créer une classe `GuessTheNumber` dont le constructeur prendra en paramètre un objet de type `UserInterface`. Cette classe possédera une méthode `play()` pour lancer le jeu qui utilisera les méthodes définies dans l'interface pour interagir avec l'utilisateur. Cette classe implémentera le jeu classique qui consiste à tirer aléatoirement un nombre entre 0 et MAXIMUM (on prendra la valeur 100) et à demander à l'utilisateur de le deviner en lui indiquant seulement à chaque saisie si le nombre est trop petit ou trop grand (bonus : vérifier expérimentalement et expliquer pourquoi on pourrait parier qu'on est capable de trouver le bon résultat en 7 coups maximum pour un tirage entre 0 et 100). Pour la conversion d'une chaîne en nombre, utiliser `Integer.parseInt` ou un `Scanner`.

* Créer une classe `ConsoleGame` permettant de jouer au jeu `GuessTheNumber` avec une interface en mode console (en utilisant la classe `ConsoleUserInterface`).

* Créer maintenant une nouvelle classe `DialogUserInterface` qui implémente l'interface `UserInterface` en s'appuyant sur la classe `JOptionPane`

* Tester `GuessTheNumber` avec cette nouvelle classe `DialogUserInterface`.

    **Faire valider par un enseignant.**


[Suite...]({{site.baseurl}}/enonces/tp5)
