---
title: Amélioration de la liste de courses
layout: page
excerpt: Utilisation des interfaces pour enrichir les fonctionnalités et supprimer du code dupliqué.
---

# Interfaces - suite

## Mise en oeuvre : Impression de la liste de courses au format texte ou html

* Modifier l'application de liste de courses de manière à ce que les items soient triés par ordre alphabétique (sans tenir compte de la casse) et en faisant figurer en début de liste les items non cochés.

* Ajouter un élément de menu permettant d'exporter la liste de courses dans un fichier. Lors du choix de cette option, l'utilisateur aura alors le choix du format de fichier : texte ou html.

* Créer une classe abstraite ListPrinter qui définit les méthodes suivantes :

  ~~~java
    public abstract class ListPrinter {

        public String printList(ShoppingList list) {
            ...
        }

        abstract protected String printHeader();

        abstract protected String printItemDescription(ShoppingListItem item);

        abstract protected String printFooter(ShoppingList list);
    }
  ~~~
    
* La méthode `printList` implémente l'algorithme commun :

    * impression d'une ligne d'en-tête (`printHeader`)
    * Boucle sur l'ensemble de la liste et affichage de la description de chacun des items par appel de (`printItemDescription`)
    * Affichage d'un pied de page (`printFooter`)

* Créer deux sous-classes de `ListPrinter` : `TextListPrinter` et `HtmlListPrinter` et redéfinir les méthodes abstraites afin de produire des chaînes de caractères conformes aux modèles suivants : 

    * Fichier texte :
        
      ~~~
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
      ~~~

    * Fichier html :
        
      ~~~html
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
      ~~~
* Dans la classe gérant l'application, ouvrir une fenêtre de sélection de l'emplacement et du nom du fichier à enregistrer en utilisant la classe `JFileChooser`, puis effectuer l'enregistrement du fichier sur le disque au bon format (utiliser les classes : `BufferedWriter` et `FileWriter`).

    * L'enregistrement est une opération qui est source d'erreurs (sélection d'un dossier au lieu d'un fichier, espace insuffisant, problèmes de droits, erreurs d'entrées/sorties, répertoires en lecture seule,...)
    * Les fonctions d'entrées/sorties sur fichiers ne peuvent donc pas être appelées sans avoir géré les **exceptions**. Une exception est un objet qui est lancé par une méthode lorsqu'elle détecte une condition d'erreur et qui peut/doit être intercepté par le code qui a appelé la méthode.
    * La syntaxe des exceptions s'appuie sur les mots clés du langage Java suivants :
    
        * `throw` : pour lancer une exception
        * `throws` : pour indiquer qu'une méthode est susceptible de lancer des exceptions (cette clause est suivie de la liste des classes d'exceptions qui peuvent être lancées)
        
        * `try` : pour démarrer un bloc de code qui s'exécutera intégralement si aucune exception n'est levée
        * `catch` : pour intercepter un ou plusieurs types d'exceptions (les exceptions sont des instances de classes qui identifient la nature de l'exception. Il est possible d'avoir plusieurs blocs `catch` pour associer un traitement qui dépend de la nature de l'erreur)
        * `finally` : pour avoir un bloc qui s'exécute quoiqu'il arrive (exception ou non). Ce bloc de code permet de libérer des ressources, fermer des fichiers/connexions réseau/...
        
    * Dans le cas présent, les méthodes à invoquer sont susceptibles de lancer l'exception `IOException`
    
    * Remarque : le compilateur Java impose la gestion des exceptions pour les exceptions qui héritent de la super-classe `Exception` sauf  la branche qui hérite de `RuntimeException`


**Faire valider par un enseignant.**


---


## Mise en oeuvre : Suppression de code dupliqué dans la liste de courses

Les méthodes `toggleCheckMarkDialog` et `removeItemDialog` sont quasiment identiques : la séquence et les vérifications sont les mêmes. Elles diffèrent seulement dans le texte affiché et dans l'action réalisée. L'idée est d'appliquer la même approche que celle utilisée pour les classes `ListPrinter` , `HtmlListPrinter` et `TextListPrinter` pour extraire tout le code commun dans une super-classe abstraite `AccessByNumberItemDialog`.

* Effectuer cette modification. Tester et valider le bon fonctionnement.

* Créer une archive (zip) contenant les fichiers sources de votre application dont le nom utilisera le format : G40x_NomDeFamille_ShoppingList_v1.zip. Déposer cette archive sous SPIRAL dans la zone de dépôt ShoppingList v1 du module MC-POO.

<!---
[Suite...]({{site.baseurl}}/enonces/tp7)
-->
