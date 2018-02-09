---
title: Première application en mode console
layout: page
excerpt: Gestion d'une liste de course (affichage et saisie utilisateur en mode console).
---
# Liste de courses

## Première partie

Dans cette partie, nous allons mettre en oeuvre la liste de courses qui a été vue en [TD](/cours/) en ajoutant quelques méthodes et une classe pour en faire une petite application.

Afin de structurer un peu les choses, nous allons regrouper les classes de cette petite application dans un package. Les packages servent à constituer des groupes de classes (qui se traduisent par des répertoires différents). Lorsque l'on veut utiliser des classes situées dans un autre package on utilise la directive `import`. Exemple :

~~~java
import javax.swing.JOptionPane;
~~~

La ligne précédente nous indique que l'on importe la classe `JOptionPane` située dans le package `javax.swing`.

Pour créer un package, il faut cliquer sur l'icône ![Icone package](/img/package_obj.png). Nous allons créer ici un package **shopping**. Les noms de packages doivent être en minuscules. Pour éviter que plusieurs utilisateurs utilisent le même nom de package, la recommandation est de débuter le nom du package par l'inverse du nom de domaine de l'entreprise (Exemple : `fr.univ_lyon1.iut.geii.shopping`). Si le package est sélectionné lors de la création d'une classe, celle-ci sera automatiquement ajoutée dans ce package. Sinon il est possible de choisir le package dans la boîte de dialogue de création de la classe. Quand une classe fait partie d'un package, son fichier source commence par une déclaration de package :

~~~java
package shopping;
~~~

Il est toujours possible a posteriori de faire glisser une classe vers un package dans eclipse. Les déclarations de package et les imports sont alors automatiquement mis à jour.

* Créer les classes `ShoppingList`et `ShoppingListItem` s'appuyant sur la classe `ArrayList` respectant le diagramme de classe ci-dessous

    ![](/img/CDC_ShoppingList.png)

    ![](/img/EclipseUmlLegend.png)

    * On utilise des variables d'instances privées ainsi que des accesseurs (*getters* et *setters*) pour y accéder (**encapsulation**). Les accesseurs peuvent être créées automatiquement dans Eclipse (menu *Source* puis *Generate Getters and Setters...*)

* Ecrire une classe `ShoppingListTest`contenant une méthode `main`dans laquelle vous validerez la possibilité de créer plusieurs listes et d'y ajouter/enlever des items, de les cocher/décocher. Vous pourrez utiliser le debugger pour valider le bon fonctionnement du programme.

**FAIRE VALIDER PAR UN ENSEIGNANT**

## Deuxième partie : application en mode console

* Créer une classe `ShoppingListApp` qui permettra de gérer une liste de courses en ligne de commande. L'extrait suivant donne un exemple de déroulement du programme.

Le programme affiche le contenu de la liste et un menu.

~~~
--------------------------------------------------------------------------------------------
La liste ne contient aucun élément
+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
~~~
L'utilisateur tape <kbd>+</kbd> puis <kbd>Entrée</kbd>. Le système affiche alors :

~~~
Que voulez-vous ajouter à la liste de courses ?
~~~

L'utilisateur saisit "Lait" puis appuie sur <kbd>Entrée</kbd>. Le système affiche :

~~~
--------------------------------------------------------------------------------------------
1 Lait [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
~~~

Une nouvelle séquence de saisies (<kbd>+</kbd>, <kbd>Entrée</kbd>, "Beurre", <kbd>Entrée</kbd>, <kbd>+</kbd>, <kbd>Entrée</kbd>, "Eau", <kbd>Entrée</kbd>, <kbd>x3</kbd>, <kbd>Entrée</kbd>, ...) provoquerait l'affichage ci-dessous :

~~~
Que voulez-vous ajouter à la liste de courses ?
Beurre
--------------------------------------------------------------------------------------------
1 Lait   [ ]
2 Beurre [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
+
Que voulez-vous ajouter à la liste de courses ?
Eau
--------------------------------------------------------------------------------------------
1 Lait   [ ]
2 Beurre [ ]
3 Eau    [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
x3
Entrée invalide
--------------------------------------------------------------------------------------------
1 Lait   [ ]
2 Beurre [ ]
3 Eau    [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
x
Saisir le numéro de l'item que vous voulez cocher/décocher (0 si aucun)
3
--------------------------------------------------------------------------------------------
1 Lait   [ ]
2 Beurre [ ]
3 Eau    [X]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
x
Saisir le numéro de l'item que vous voulez cocher/décocher (0 si aucun)
3
--------------------------------------------------------------------------------------------
1 Lait   [ ]
2 Beurre [ ]
3 Eau    [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
x
Saisir le numéro de l'item que vous voulez cocher/décocher (0 si aucun)
2
--------------------------------------------------------------------------------------------
1 Lait   [ ]
2 Beurre [X]
3 Eau    [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
-
Saisir le numéro de l'item que vous voulez supprimer (0 si aucun)
2
--------------------------------------------------------------------------------------------
1 Lait [ ]
2 Eau  [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
q
Fermeture de l'application
~~~

* On pourra utiliser indifféremment des minuscules et majuscules (x ou X, q ou Q)
* Pour récupérer des données saisies par l'utilisateur, on utilise l'entrée standard `System.in`. Cet objet est de type `InputStream` et les méthodes disponibles ne sont pas très commodes (lecture brute d'octets). On utilise donc la classe `Scanner` qui va *décorer* l'entrée standard en ajoutant des méthodes plus pratiques ([javadoc](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html)).
    * On crée un scanner sur l'entrée standard de la façon suivante :

      ~~~java
      Scanner sc = new Scanner(System.in);
      ~~~

    * `sc.nextInt()` retourne l'entier saisi. Si les caractères saisis ne peuvent pas être convertis en un entier cela provoque une exception. On peut tester si le prochain élément saisi est un int avant d'appeler cette méthode en utilisant `sc.hasNextInt()`.

    * `sc.nextLine()` renvoie une objet de type String contenant le reste de la ligne saisie jusqu'au caractère de fin de ligne (qui n'est pas retourné par la méthode). Utilisé pour :

        * lire une chaîne de caractères.

        * purger le reste de la ligne après avoir lu un int ou un long par exemple. En effet `sc.nextInt()`ne consomme que l'entier et pas le caractère fin de ligne.

        ![](/img/scanner.png)


* Pour formater les lignes `1 Lait [ ]` on pourra utiliser la méthode statique `format` de la classe `String`qui accepte une chaîne de formatage semblable au printf ([description des formateurs](https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax) et [javadoc de la méthode](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#format(java.lang.String,%20java.lang.Object...))).

* La comparaison de chaînes de caractères doit se faire avec la méthode `equals` plutôt qu'avec l'opérateur `==`. En effet ce dernier compare les références (en quelques sorte les adresses en mémoire) alors que la méthode `equals` compare le contenu des chaînes de caractères

* A la fin de l'exécution de l'exemple précédent, on a le diagramme d'objets suivant (qui représente les objets créés en mémoire, leurs associations, ainsi que la valeur de leurs champs principaux). Sur cette représentation chaque objet est identifié de la manière suivante : `nomObjet:ClasseObjet`. Quand les objets sont stockés dans une liste on ne dispose pas de variable ayant un nom pour accéder à un élément (on note alors `:ClasseObjet`).

![](/img/ShoppingListObjectDiagram.png)

* Le squelette de la classe est le suivant, remplacer les `...` pour obtenir le comportement décrit. Pour chaque méthode faire un organigramme et le faire valider par l'enseignant.

~~~java
import java.util.Scanner;

public class ShoppingListApp {

	private Scanner sc = new Scanner(System.in);
	private ShoppingList list...;

	public static void main(String[] args) {
		ShoppingListApp app = new ShoppingListApp();
		app.launch();
	}

	private void launch() {
		// Boucle d'interaction
		boolean keepGoing = true;
		while (keepGoing) {
			displayListContent();
			displayMenu();
			String input = sc.nextLine();
			...
			if (input.equals(...)) {
				System.out.println("Fermeture de l'application");
				...
			} else {
				processInput(input);
			}
		}
	}


	private void displayListContent() {
		...
	}

	private void displayMenu() {
		System.out.println("+ : Ajouter un item \t - : enlever un item \t x : (Dé)cocher un item \t q : quitter");
	}

	private void processInput(String input) {
		switch (input) {
		case "+":
			newItemDialog();
			break;

		case "-":
			removeItemDialog();
			break;

		case "x":
			toggleCheckMarkDialog();
			break;

		default:
			System.out.println("Entrée invalide");
			break;
		}
	}

	private void newItemDialog() {
		...
	}

	private void removeItemDialog() {
		...
	}

	private void toggleCheckMarkDialog() {
		...
	}

}
~~~
Remarque : en Java, à partir de la version 7, on peut faire un `switch` sur une chaîne de caractères.

Penser à valider les points suivants :

* Lors de la saisie d'un numéro d'item pour le supprimer ou pour le cocher, il faut vérifier que le programme ne génère pas d'exception dans les cas suivants :
    * Saisie d'un chaîne qui ne représente pas un nombre
    * Saisie d'un indice au delà de la fin de la liste
    * Saisie d'un 0 (on doit retourner au menu sans modifier le contenu de la liste)
    * Saisie d'un nombre négatif
    * Saisie d'une chaîne vide dans la description d'un item

* Vérifier qu'après la saisie d'un numéro d'item il n'y a pas d'affichage du texte "entrée invalide" avant l'affichage du menu (si c'est le cas relire le paragraphe sur l'utilisation du scanner).

**FAIRE VALIDER PAR UN ENSEIGNANT**

[Suite...]({{site.baseurl}}/enonces/tp3)
