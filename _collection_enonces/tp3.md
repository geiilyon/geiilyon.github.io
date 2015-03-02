---
title: Héritage - classes abstraites et interfaces
layout: page
excerpt: Pour aller plus loin avec l'héritage
---

# Héritage - suite

## Classes abstraites

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

Les interfaces en Java sont des classes 100% abstraites. Elles définissent un jeu de méthodes qui pourront être appelées sur un objet qui implémente cette interface. Elles permettent de contourner une *limitation de Java* : l'absence d'héritage multiple. En effet une classe Java ne peut étendre qu'une seule classe. Par contre elle peut implémenter autant d'interfaces qu'elle le souhaite.

De très nombreuses classes de la bibliothèque Java s'appuient sur les interfaces. Pour définir une interface on utilise le mot clé `interface`. En cliquant sur la petite flèche située à côté du bouton de création d'une classe, on peut choisir de créer une nouvelle `interface`. Une interface est définie de la même manière qu'une classe, dans un fichier *.java* portant le même nom que l'interface.

* Créer une interface `UserInterface`qui définira les méthodes `displayMessage` et `getUserInputString` pour afficher un message et demander une entrée à l'utilisateur (le paramètre `query` est utilisé pour afficher la question à poser à l'utilisateur avant d'attendre sa réponse qu'elle retournera) :

    ```java
    public interface UserInterface {

        public void displayMessage(String message);

        public String getUserInputString(String query);
    }

    ```
    
    L'idée est de définir une interface commune pour différentes classes qui permettront d'interagir avec l'utilisateur (en mode console et avec des boîtes de dialogue).
    
    ![GuessTheNumberClassDiagram](/img/GuessTheNumber.png)
    ![Legende Eclispe UML](/img/EclipseUmlLegend.png)

* Créer une classe `ConsoleUserInterface` qui implémente l'interface `UserInterface`. Les messages seront affichés sur la sortie standard et les entrées proviendront de l'entrée standard.

    ```java
    public class ConsoleUserInterface implements UserInterface
    ```

* Créer une classe `GuessTheNumber` dont le constructeur prendra en paramètre un objet de type `UserInterface`. Cette classe possèdera une méthode `play()` pour lancer le jeu qui utilisera les méthodes définies dans l'interface pour interagir avec l'utilisateur. Cette classe implémentera le jeu classique qui consiste à tirer alétoirement un nombre entre 0 et 100 et à demander à l'utilisateur de le deviner en lui indiquant seulement à chaque saisie si le nombre est trop petit ou trop grand (bonus : vérifier expérimentalement et expliquer pourquoi il faut au maximum 7 coups pour trouver le bon résultat).

* Tester `GuessTheNumber` avec la classe `ConsoleUserInterface` et faire valider par un enseignant.

* Créer maintenant une nouvelle classe `DialogUserInterface` qui implémente l'interface `UserInterface` en s'appuyant sur la classe `JOptionPane`

* Tester `GuessTheNumber` avec cette nouvelle classe `DialogUserInterface` et faire valider par un enseignant.

---

## Mise en oeuvre : tri d'une liste d'étudiants

Les classes de collections telles que les listes (ex : `ArrayList`) peuvent être triées en utilisant les méthodes de la classe `Collections`. Cette dernière classe est l'équivalent de la classe `Arrays` qui était dédiée aux tableaux. Elle permet de manipuler les différents types de collections tels que `List`, `Set` (ensemble d'éléments uniques) et `Map`(tableaux associatifs : clé -> Valeur).

La classe `Collections` définit deux méthodes qui permettent de trier des listes. Nous allons nous intéresser à la première :

```java
public static <T extends Comparable<? super T>> void sort(List<T> list);
```
La signature de cette méthode est un peu intimidante. Pour simplifier, on peut dans un premier temps la voir de la façon suivante :

```java
public static void sort(List<T> list);
```

Cette méthode permet de trier un objet de type `List<T>`. Ceci soulève 2 questions :

* on a une ArrayList et pas une List, comment fait-on ?

* Comment la méthode `sort` peut-elle comparer deux étudiants ? La notion de supériorité/infériorité/égalité des étudiants ne peut pas être devinée automatiquement.

Pour répondre à la première question, une `ArrayList<T>` est une `List<T>`. Pour le savoir il faut aller sur la [javadoc de la classe ArrayList](http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html). L'information est présente dans l'en-tête de la description de la classe (*All implemented interfaces*) et dans la déclaration de la classe (juste en-dessous de la ligne horizontale) dont le contenu est :

```java
public class ArrayList<E>
extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, Serializable
```

La classe `ArrayList<E>` hérite de `AbstractList<E>` (classe qui regroupe les algorithmes communs à différents types de listes) et implémente plusieurs interfaces dont `List<E>`. Une `ArrayList<E>` est donc un objet du type `List<E>`, et grâce au polymorphisme on peut passer une `ArrayList<E>` à toutes les méthodes qui attendent un objet de type `List<E>`. Remarque : on peut utiliser la lettre de son choix E, T lors de la définition d'une classe ou méthode générique. Cette lettre est une variable de type.

La deuxième question concernait la possibilité de pouvoir comparer 2 objets de type `Etudiant`. C'est le sens de la partie obscure de la déclaration qui est là pour que le compilateur Java vérifie bien que les éléments de la liste implémentent l'interface Comparable. Il y a même une contrainte supplémentaire sur la possibilité de comparer des objets qui héritent de la classe `T` mais cela sort du cadre de ce cours. En résumé, pour que l'on puisse comparer deux étudiants, il faut que le classe `Etudiant` implémente l'interface `Comparable<Etudiant>`.

L'interface `Comparable<T>` est définie de la manière suivante :

```java
public interface Comparable<T> {
    public int compareTo(T o);
```

La javadoc de la méthode nous indique qu'il faut retourner un entier négatif (respectivement positif) si l'objet sur lequel est appelée la méthode est inférieur (respectivement supérieur) à l'objet passé en paramètre. Si les objets sont égaux, la méthode compareTo doit retourner 0.

* Modifier la classe `Etudiant` pour implémenter l'interface `Comparable<Etudiant>` en effectuant une comparaison sur le nom puis sur le prénom (pour départager les homonymes). Pour ce faire, il faudra comparer des chaînes de caractères en utilisant le fait que la classe `String` implémente l'interface `Comparable<String>`.

* Créer une classe de tests unitaires (JUnit Test Case) `TestsTriEtudiants` pour valider le bon fonctionnement de l'interface `Comparable<Etudiant>`

* Dans la classe de tests unitaires ajouter une méthode dans laquelle on remplira une liste d'étudiants en prenant soin de prendre des prénoms et noms permettant de valider le bon fonctionnement du tri (homonymes, ...) qu'on triera ensuite et dont on vérifiera qu'elle donne bien le bon résultat (utiliser `assertEquals` entre la liste triée et une liste créée avec les mêmes éléments dans l'ordre attendu).


**Remarque** : On vient de voir que le paramètre de la méthode `Collections.sort(List<T> list)` était du type List<T> (l'interface implémentée par toutes les listes Java : AbstractList, AbstractSequentialList, ArrayList, AttributeList, CopyOnWriteArrayList, LinkedList, RoleList, RoleUnresolvedList, Stack, Vector). C'est une bonne pratique en Java, qui consiste à manipuler les objets par leur interface plutôt que par leur classe contrète, on verra donc couramment le code suivant :

```java
List<Etudiant> etudiants = new ArrayList<Etudiant>();
```

Ainsi le reste du code ne dépend **que** des méthodes définies dans l'interface `List<E>` et il est possible par la suite de remplacer la classe concrète `ArrayList` par une autre implémentation de l'interface `List<E>` (par exemple `LinkedList`).

Si maintenant on souhaite trier notre liste d'étudiants en utilisant un autre critère, on arrive aux limites de l'interface `Comparable`. La solution consiste à créer un nouvel objet permettant de comparer deux instances de la classe `Etudiant`. Cet objet pourra être passé en paramètre de la deuxième méthode de tri de la classe `Collections` :

```java
public static <T> void sort(List<T> list, Comparator<? super T> c)
```

Cette méthode attend un objet de type `Comparator<? super T>` (quelque chose capable de comparer des instances de la classe T ou de ses sous-classes). Si on veut trier notre liste d'étudiants par *prénom* d'abord, puis par *nom*, il va falloir créer ce comparateur.

* Créer une classe `FirstThenLastNameComparator` qui implémentera l'interface `Comparator<Etudiant>` et ajouter une méthode de test dans la classe `TestsTriEtudiants` pour valider le bon fonctionnement. Il est possible de créer des variables d'instances dans la classe de test pour réutiliser des variables dans différentes méthodes de test. L'initialisation de ces variables partagées peut-être effectuée dans une méthode `setUp` marquée par l'annotation `@Before`, qui sera appelée avant d'exécuter chaque méthode de test. Exemple :

    ```java
    public class TestsTriEtudiants {

        private Etudiant abrahamLincoln;
        private Etudiant jamesBond;
        private Etudiant johnBond;
        private Etudiant johnDoe;
        private List<Etudiant> etudiants;

        @Before
        public void setUp() {
            abrahamLincoln = new BonEtudiant("Abraham", "Lincoln");
            jamesBond = new BonEtudiant("James", "Bond");
            johnBond = new MauvaisEtudiant("John", "Bond");
            johnDoe = new MauvaisEtudiant("John", "Doe");
            etudiants = new ArrayList<>();
            etudiants.add(abrahamLincoln);
            etudiants.add(johnBond);
            etudiants.add(johnDoe);	
            etudiants.add(jamesBond);	
        }

    ```

---

## Mise en oeuvre : Impression de la liste de courses au format texte ou html

* Modifier l'application de liste de courses de manière à ce que les items soient triés par ordre alphabétique (sans tenir compte de la casse) et en faisant figurer en début de liste les items non cochés.

* Ajouter un élément de menu permettant d'exporter la liste de courses dans un fichier. Lors du choix de cette option, l'utilisateur aura alors le choix du format de fichier : texte ou html.

* Créer une classe abstraite ListPrinter qui définit les méthodes suivantes :

    ```java
    public abstract class ListPrinter {

        public String printList(ShoppingList list) {
            ...
        }

        abstract protected String printHeader();

        abstract protected String printItemDescription(ShoppingListItem item);

        abstract protected String printFooter(ShoppingList list);
    }
    ```
    
* La méthode `printList` implémente l'algorithme commun :

    * impression d'une ligne d'en-tête (`printHeader`)
    * Boucle sur l'ensemble de la liste et affichage de la description de chacun des items par appel de (`printItemDescription`)
    * Affichage d'un pied de page (`printFooter`)

* Créer deux sous-classes de `ListPrinter` : `TextListPrinter` et `HtmlListPrinter` et redéfinir les méthodes abstraites afin de produire des chaînes de caractères conformes aux modèles suivants : 

    * Fichier texte :
        
        ```
        Liste de courses
        --------------------------------------------
        1	Beurre                        	[ ]
        2	Oeufs                         	[ ]
        3	Lait                          	[X]
        4	Rillettes                     	[X]
        5	Trombonnes                     	[X]
        --------------------------------------------
        Taille de la liste : 5.
        Progression : 60 %
        ```

    * Fichier html :
        
        ```html
        <!doctype html><html lang="fr">
        <head> <meta charset="utf-8"><title>Liste de courses</title></head>
        <body>
        <h1>Liste de courses</h1>
        <hr/>
        <table>
        <tr><td>1</td><td>Beurre</td><td> </td></tr>
        <tr><td>2</td><td>Oeufs</td><td> </td></tr>
        <tr><td>3</td><td>Lait</td><td>X</td></tr>
        <tr><td>4</td><td>Rillettes</td><td>X</td></tr>
        <tr><td>5</td><td>Trombonnes</td><td>X</td></tr>
        </table>
        <hr/>
        <p>Taille de la liste : 5.<br/>Progression : 60 %<p></body>
        </html>        
        ```
* Dans la classe gérant l'application, ouvrir une fenêtre de sélection de l'emplacement et du nom du fichier à enregistrer en utilisant la classe `JFileChooser`. Valider le bon fonctionnement du programme.
