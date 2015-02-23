---
title: Héritage - classes abstraites et interfaces
layout: page
excerpt: Pour aller plus loin avec l'héritage
---

# Héritage - suite

# Classes abstraites

Dans l'exemple de la classe `Etudiant` étudié dans la partie précédente, les méthodes `getSeuilCool()`, `getSeuilLoose()` et `getSeuilPasPire()` avaient besoin d'être définies dans la classe Etudiant seulement dans le but d'être redéfinies dans les sous-classes. Dans ce cas là, pour ne pas être obligé de fournir une implémentation, on peut déclarer ces méthodes comme étant abstraites (`abstract`) :

```java
    abstract protected double getSeuilLoose();
```

Lorsque l'on déclare une méthode abstraite, on ne fournit pas de corps à la méthode (les sous-classes se chargeront de l'implémenter).

Dès lors qu'elle contient une méthode abstraite une classe doit elle aussi être déclarée abstraite :

```java
    public abstract class Etudiant
```
En effet, son implémentation étant incomplète, elle ne peut pas être instanciée. On ne peut instancier que des classes concrètes. Les classes abstraites servent à factoriser du code commun ou à définir des types très généraux qui permettront de manipuler des classes concrètes par polymorphisme.

* Modifier les classes précédentes comme indiqué et vérifier qu'il n'est maintenant plus possible de créer d'instance de la classe Etudiant. Vérifier par contre que votre code précédent fonctionne toujours.


## Les interfaces

Les interfaces en Java sont des classes 100% abstraites. Elles définissent un jeu de méthodes qui pourront être appelées sur un objet qui implémente cette interface. Elles permettent de contourner une *limitation de Java* : l'absence d'héritage multiple. En effet une classe Java ne peut étendre qu'une seule classe. Par contre elle peut implémenter autant d'interface qu'elle le souhaite.

De très nombreuses classes de la bibliothèque Java s'appuient sur les interfaces. Pour définir une interface on utilise le mot clé `interface`. En cliquant sur la petite flèche située à côté du bouton de création d'une classe, on peut choisir de créer une nouvelle `interface`. Une interface est définie de la même manière qu'une classe, dans un fichier *.java* portant le même nom que l'interface.

* Créer une interface `UserInterface`qui définira les méthodes `displayMessage` et `getUserInputString` pour afficher un message et demander une entrée à l'utilisateur (le paramètre `query` est utilisé pour afficher la nature de l'entrée demandée à l'utilisateur) :

    ```java
    public interface UserInterface {

        public void displayMessage(String message);

        public String getUserInputString(String query);
    }

    ```

* Créer une classe `ConsoleUserInterface` qui implémente l'interface `UserInterface`. Les messages seront affichés sur la sortie standard et les entrées proviendront de l'entrée standard.

    ```java
    public class ConsoleUserInterface implements UserInterface
    ```

* Créer une classe `GuessTheNumber` dont le constructeur prendra en paramètre un objet de type `UserInterface` et qui utilisera les méthodes définies dans l'interface pour interagir avec l'utilisateur. Cette classe implémentera le jeu classique qui consiste à tirer alétoirement un nombre entre 0 et 100 et à demander à l'utilisateur de le deviner en lui indiquant seulement à chaque saisie si le nombre est trop petit ou trop grand (bonus : vérifier expérimentalement et expliquer pourquoi il faut au maximum 7 coups pour trouver le bon résultat).

* Tester `GuessTheNumber` avec la classe `ConsoleUserInterface

* Créer maintenant une nouvelle classe `DialogUserInterface` qui implémente l'interface `UserInterface` en s'appuyant sur la classe JOptionPane

* Tester `GuessTheNumber` avec cette nouvelle classe `DialogUserInterface`


## Mise en oeuvre : tri d'une liste d'étudiants

Les classes de collections telles que les listes peuvent être triées en utilisant les méthodes de la classe `Collections`. Cette dernière classe est l'équivalent de la classe `Arrays` qui était dédiée aux tableaux. Elle permet de manipuler les différents types de collections tels que `List`, `Set` (ensemble d'éléments uniques) et `Map`(tableaux associatifs : clé -> Valeur).

Maintenant que vous avez vu les interfaces, vous pouvez revoir la définition de la classe `ArrayList` ([javadoc](http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)). Repérer la super-classe et les interfaces implémentées.

Une bonne pratique en Java consiste à manipuler les objets par leur interface, on verra donc couramment le code suivant :

```java
List<Etudiant> etudiants = new ArrayList<Etudiant>();
```

Le reste du code ne dépend **que** des méthodes définies dans l'interface `List` et il est possible par la suite de remplacer la classe concrète `ArrayList` par une autre implémentantion de l'interface `List` (par exemple `LinkedList`).

* Créer une classe de tests unitaires `TestsTriEtudiants` : dans la boîte de dialogue, faire générer une méthode setUp dans laquelle on remplira une liste d'étudiants en prenant soin de prendre des prénoms et noms permettant de valider le bon fonctionnement du tri (homonymes, ...).

