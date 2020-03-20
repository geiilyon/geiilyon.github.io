---
title: Utilisation des interfaces pour comparer des objets
layout: page
excerpt: Tri de liste par implémentation des interfaces de comparaison.
---

# Tri d'une liste d'étudiants

Les classes de collections telles que les listes (ex : `ArrayList`) peuvent être triées en utilisant les méthodes de la classe `Collections`. Cette dernière classe est l'équivalent de la classe `Arrays` qui était dédiée aux tableaux. Elle permet de manipuler les différents types de collections tels que `List`, `Set` (ensemble d'éléments uniques) et `Map`(tableaux associatifs : clé -> Valeur).

La classe `Collections` définit deux méthodes qui permettent de trier des listes. 

![CollectionsSort](/img/CollectionsSort.png)

Nous allons nous intéresser à la première, qui possède la signature suivante :

~~~java
public static <T extends Comparable<? super T>> void sort(List<T> list);
~~~

La signature de cette méthode est un peu intimidante. Pour simplifier, on peut dans un premier temps la voir de la façon suivante :

~~~java
public static void sort(List<T> list);
~~~

Cette méthode permet de trier un objet de type `List<T>`. Ceci soulève 2 questions :

* on a une ArrayList et pas une List, comment fait-on ?

* Comment la méthode `sort` peut-elle comparer deux étudiants ? La notion de supériorité/infériorité/égalité des étudiants ne peut pas être devinée automatiquement.

Pour répondre à la première question, une `ArrayList<T>` est une `List<T>`. Pour le savoir il faut aller sur la [javadoc de la classe ArrayList](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html). L'information est présente dans l'en-tête de la description de la classe (*All implemented interfaces*) et dans la déclaration de la classe (juste en-dessous de la ligne horizontale) dont le contenu est :

~~~java
public class ArrayList<E>
extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, Serializable
~~~

La classe `ArrayList<E>` hérite de `AbstractList<E>` (classe qui regroupe les algorithmes communs à différents types de listes) et implémente plusieurs interfaces dont `List<E>`. Une `ArrayList<E>` est donc un objet du type `List<E>`, et grâce au polymorphisme on peut passer une `ArrayList<E>` à toutes les méthodes qui attendent un objet de type `List<E>`. Remarque : on peut utiliser la lettre de son choix E, T lors de la définition d'une classe ou méthode générique. Cette lettre est une variable de type.

La deuxième question concernait la possibilité de pouvoir comparer 2 objets de type `Etudiant`. C'est le sens de la partie obscure de la déclaration qui est là pour que le compilateur Java vérifie bien que les éléments de la liste implémentent l'interface Comparable. Il y a même une contrainte supplémentaire sur la possibilité de comparer des objets qui héritent de la classe `T` mais cela sort du cadre de ce cours. En résumé, pour que l'on puisse comparer deux étudiants, il faut que le classe `Etudiant` implémente l'interface `Comparable<Etudiant>`.

L'interface `Comparable<T>` est **déjà définie dans la bibliothèque Java** de la manière suivante (elle fait partie du package java.lang qui est importé automatiquement, cf. [javadoc](https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html)) :

~~~java
public interface Comparable<T> {
    public int compareTo(T o);
}
~~~

La javadoc de la méthode nous indique qu'il faut retourner **un entier négatif (respectivement positif) si l'objet sur lequel est appelée la méthode est inférieur (respectivement supérieur) à l'objet passé en paramètre. Si les objets sont égaux, la méthode compareTo doit retourner 0.**

## Prise en main - tri d'une liste de chaîne

* Créer une classe `TestCompare` contenant une méthode `main` et afficher les résultats renvoyés par la méthode compareTo de la classe `String` en testant différentes combinaisons de chaînes de caractères (Exemple : `"toto".compareTo("abc")`)

* Créer une liste de chaînes en utilisant la méthode `asList` de la classe `Arrays` :

~~~java
List<String> list = Arrays.asList("Mr. Burns", "Flanders", "Krusty", "Smithers", "Homer", "Bart", "Marge", "Lisa",
                "Maggie", "Moe");
~~~

* Utiliser la méthode `Collections.sort` pour trier la liste par ordre alphabétique. Afficher la liste avant et après le tri.

## Tri sur nom puis prénom

![ComparableEtudiant](/img/ComparableEtudiant.png)

* Dans la classe `Etudiant` :
    * Editer la déclaration de la classe afin de préciser que la classe implémente l'interface `Comparable<Etudiant>`
    * Implémenter la méthode `compareTo` qui effectuera une comparaison sur le nom puis sur le prénom (pour départager les étudiants ayant le même nom de famille). Pour ce faire, il faudra comparer des chaînes de caractères en utilisant le fait que la classe `String` implémente l'interface `Comparable<String>` ou en utilisant la méthode compareToIgnoreCase si on ne veut pas tenir compte de la casse.

* Créer une classe de tests unitaires (JUnit Test Case) `TestsTriEtudiants` pour valider le bon fonctionnement de l'interface `Comparable<Etudiant>`. Utiliser la méthode `assertTrue` pour tester que les valeurs retournées par l'appel de `compareTo` sont bien positives ou négatives.

* Dans la classe de tests unitaires ajouter une méthode dans laquelle on remplira une liste d'étudiants en prenant soin de prendre des prénoms et noms permettant de valider le bon fonctionnement du tri (homonymes, ...) qu'on triera ensuite et dont on vérifiera qu'elle donne bien le bon résultat (utiliser `assertEquals` entre la liste triée et une liste créée avec les mêmes éléments dans l'ordre attendu).


**Remarque** : On vient de voir que le paramètre de la méthode `Collections.sort(List<T> list)` était du type List<T> (l'interface implémentée par toutes les listes Java : AbstractList, AbstractSequentialList, ArrayList, AttributeList, CopyOnWriteArrayList, LinkedList, RoleList, RoleUnresolvedList, Stack, Vector). C'est une bonne pratique en Java, qui consiste à manipuler les objets par leur interface plutôt que par leur classe concrète, on verra donc couramment le code suivant :

~~~java
List<Etudiant> etudiants = new ArrayList<Etudiant>();
~~~

Ainsi le reste du code ne dépend **que** des méthodes définies dans l'interface `List<E>` et il est possible par la suite de remplacer la classe concrète `ArrayList` par une autre implémentation de l'interface `List<E>` (par exemple `LinkedList`).


## Tri sur prénom puis nom

Si maintenant on souhaite trier notre liste d'étudiants en utilisant un autre critère, on arrive aux limites de l'interface `Comparable`. En effet, celle-ci ne permet pas d'utiliser différents critères de comparaison. La méthode `sort` de la classe `Collections` est surchargée. On peut lui passer un deuxième argument, en plus de la liste, qui est une référence vers un objet capable de comparer deux éléments de la liste :

~~~java
public static <T> void sort(List<T> list, Comparator<? super T> c)
~~~

Cette méthode attend un objet de type `Comparator<? super T>` (quelque chose capable de comparer des instances de la classe T ou de ses sous-classes). Si on veut trier notre liste d'étudiants par *prénom* d'abord, puis par *nom*, il va falloir créer ce comparateur.

* Créer une classe `FirstThenLastNameComparator` qui implémentera l'interface `Comparator<Etudiant>` ([javadoc](https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html)) et ajouter une méthode de test dans la classe `TestsTriEtudiants` pour valider le bon fonctionnement. Il est possible de créer des variables d'instances dans la classe de test pour réutiliser des variables dans différentes méthodes de test. L'initialisation de ces variables partagées peut-être effectuée dans une méthode `setUp` marquée par l'annotation `@Before`, qui sera appelée avant d'exécuter chaque méthode de test. Exemple :

  ~~~java
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
        
        ...
    }

  ~~~
  
**Faire valider par un enseignant.**

[Suite...]({{site.baseurl}}/enonces/tp6)
