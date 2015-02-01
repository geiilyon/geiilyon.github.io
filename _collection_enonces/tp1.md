---
title: Introduction
layout: page
excerpt: Prise en main d'Eclipse. Création de projets, classes, expérimentations sur les objets.
---

# Prise en main d'Eclipse

Lors du lancement, Eclipse demande de choisir/créer un *workspace*. Ce dossier permettra de stocker plusieurs *projets*. Pour ce module nous utiliserons toujours le même workspace. Nommez le **workspace eclipse** et enregistrez le dans votre dossier Mes Documents.

![Dialogue Eclipse workspace](/img/EclipseWorkspaceDialogue.png)

Toutes les classes seront pour l'instant créées dans le package par défaut (*default package*).

## L'incontournable Hello World !

```java
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello world !");
    }
}
```

Suivez les instructions présentes dans la vidéo suivante pour agencer les fenêtres et créer et exécuter votre premier projet Eclipse (vous devez avoir une session SPIRAL active pour accéder à la vidéo et utiliser firefox, chrome ou safari. Suivre le [lien pour voir la video sur SPIRAL](http://spiralconnect.univ-lyon1.fr/webapp/player/HtmlVideoPlayer.html?idMedia=4024274&typeMedia=false)).

{% assign mp4_id = 4024274 %}
{% assign webm_id = 4025132 %}
{% include video.html %}

Configurez Eclipse pour qu'il utilise l'encodage UTF-8 pour les fichiers sources (et tous les fichiers textes). Cet encodage est aujourd'hui le standard pour échanger des fichiers entre plusieurs systèmes (Linux, Windows, Mac). Pour ce faire, effectuez la manipulation décrite dans la vidéo suivante [lien SPIRAL](http://spiralconnect.univ-lyon1.fr/webapp/player/HtmlVideoPlayer.html?idMedia=4058934&typeMedia=false).

{% assign mp4_id = 4058934 %}
{% assign webm_id = 4058935 %}
{% include video.html %}


La complétion automatique de code sous Eclipse est activée par le raccourci clavier <kbd>Ctrl</kbd>+<kbd>Espace</kbd>.

Il existe de nombreux *templates* pour compléter automatiquement des blocs de codes. Les plus utiles sont les suivants :

* `sysout` (taper syso puis <kbd>Ctrl</kbd>+<kbd>Espace</kbd>)

* `main`

* `new`

* `foreach`, `for`

* `if`, `ifelse`

* `switch`


## Expérimentations sur les chaînes de caractères

### Exercice 1

On désire créer un programme affichant sur la console le texte suivant :

```bash
Portez ce vieux whisky au juge blond qui fume
The quick brown fox jumps over the lazy dog
La phrase française comporte ? caractères
La phrase anglaise comporte ? caractères
````

où les `?` auront été remplacés par le nombre de caractères.

* Créer une classe `ExperimentationChaines` qui contiendra une méthode main.

* Créer des variables de type `String` et leur affecter les phrases à afficher.

Exemple : 

```java
String phraseFr = "Portez ce vieux whisky au juge blond qui fume";
````

* Construire l’affichage souhaité en appelant `System.out.println` pour chacune des 4 lignes à afficher.

### Exercice 2

* Créer une nouvelle classe `ExperimentationChaines2` qui devra afficher le même résultat mais en concaténant les 4 chaînes dans **une seule chaîne** qui contiendra le résultat et sera passée à une fonction pour affichage (console ou fenêtre de dialogue).

    Le retour à la ligne est codé différemment selon les systèmes d’exploitation :

    * 0x0A (Unix, Linux, Mac OS X, ...)

    * 0x0D (Commodore, ...)

    * 0x0D 0x0A (Windows, ...)

Pour pallier ce problème, la classe System de java permet de récupérer la chaîne associée au retour à la ligne :

```java
String lineSep = System.getProperty("line.separator");
```

* Tester votre programme avec un affichage sur la console (`System.out.println`)

* Remplacer l’utilisation de `System.out.println` par `JOptionPane.showMessageDialog(null,message);` où message est une variable de type `String` contenant le message à afficher. Vous aurez besoin d’importer la classe `JOptionPane` (utiliser les suggestions de résolution d’erreur d’Eclipse en cliquant sur la petite croix rouge en début de ligne).

### Exercice 3 - Anagrammes

* Créer une nouvelle classe `Anagrams` qui contiendra une méthode : 

    ```java 
    public static boolean isAnagram(String firstWord, String secondWord)
    ```

    qui renvoie `true`si les deux mots sont des anagrammes.
    
    Utiliser les méthodes de la classe `String` ([javadoc de la classe String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html)) pour tenir compte de la présence de majuscules (qui doivent être ignorées) et pour convertir une chaîne en un tableau de caractères (`char`).
    Pour la comparaison des lettres des deux mots, elle peut se faire en 3 lignes de code en utilisant 2 méthodes de la classe `Arrays` ([javadoc de la classe Arrays](http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html)). La classe `Arrays` contient des méthodes statiques destinées à manipuler les tableaux (tri, comparaison, remplissage, ...). Ces méthodes s'appellent directement sur la classe. Exemple de remplissage d'un tableau avec des 0 :
    
    ```java
    Arrays.fill(tableau,0);
    ```
    
* Créer une nouvelle classe `AnagramsTests` qui contiendra une méthode `main` permettant de valider le bon fonctionnement de la méthode `isAnagram`.

* Validation par des tests unitaires.

    * Télécharger le [fichier de tests unitaires](http://spiralconnect.univ-lyon1.fr/spiral-files/download?mode=inline&data=4025308)
    
    * Depuis l'explorateur de fichier du système d'exploitation, glisser-déposer le fichier .java sur (default package) dans la vue *Package Explorer* d'Eclipse
    
    * Exécuter ce fichier. Il s'agit d'un fichier contenant des tests **JUnit** (framework de tests unitaires). Il est reconnu automatiquement par Eclipse comme tel et est exécuté par le moteur de tests unitaires qui affiche ensuite les résultats des tests dans une fenêtre dédiée.
    
    * Vidéo de la manipulation à effectuer ([lien SPIRAL](http://spiralconnect.univ-lyon1.fr/webapp/player/HtmlVideoPlayer.html?idMedia=4025470&typeMedia=false)).

{% assign mp4_id = 4025470 %}
{% assign webm_id = 4025458 %}
{% include video.html %}


* Si le résultat des tests montre un échec, corriger le code de votre méthode `isAnagram`.

Le principe de JUnit est le suivant :

* Les méthodes qui portent l'annotation `@Test` seront exécutées automatiquement par JUnit

* Ces méthodes doivent contenir des assertions (*En programmation informatique, une assertion est une expression qui doit être évaluée à vrai*)

* Les assertions classiques sont :

    * `assertEquals(expected, actual)` : permet de comparer le résultat d'un calcul avec la valeur attendue
    
    * `assertEquals(expected, actual, delta)` : idem mais pour les nombres codés en flottant (`float`et `double`) pour lesquels on ne peut pas faire de tests d'égalité stricte. On vérifie ici que (expected - delta) < actual < (expected + delta)
    
    * `assertTrue(condition)` et `assertFalse(condition)` : vérifie qu'une condition est vraie ou fausse
    
    * Il existe une variante qui utilise la syntaxe `assertThat` qui donne des tests plus lisibles mais qui est plus délicate à mettre en oeuvre.
    
## Passage par valeur / références

* Créer une nouvelle classe `PassageParValeur` qui contiendra le code suivant :

```java
public class PassageParValeur {

	public static void main(String[] args) {
		int nbCookies = 5;
		
		mangerDesCookies(nbCookies);
		
		System.out.println("Il reste " + nbCookies + " cookies !");
		
	}

	private static void mangerDesCookies(int nbCookies) {
		nbCookies = nbCookies - 2;
		System.out.println("Je viens de manger 2 cookies et il en reste : " + nbCookies);
	}

}

```

* Placer un point d'arrêt en face de la méthode mangerDesCookies (double cliquer dans la colonne située à gauche des numéros de lignes  et lancer le débugger en cliquant sur l'icône avec un insecte (*bug*) située à côté du bouton *Run* (voir [exemple d'utilisation du  debugger](/eclipse/)).

* Vérifier et interpréter le comportement de ce programme.

* Créer maintenant deux nouvelles classes `PassageParReference` et `PaquetCookies`

```java


public class PassageParReference {

	public static void main(String[] args) {
		PaquetCookies paquet = new PaquetCookies(5);

		mangerDesCookies(paquet);
		
		System.out.println("Il reste " + paquet.nbCookies + " cookies !");
	}

	private static void mangerDesCookies(PaquetCookies paquet) {
		paquet.nbCookies = paquet.nbCookies - 2;
		System.out.println("Je viens de manger 2 cookies et il en reste : " + paquet.nbCookies);
	}

}

```

```java

public class PaquetCookies {

	int nbCookies;

	public PaquetCookies(int nbCookies) {
		this.nbCookies = nbCookies;
	}
	
}

```

* A l'aide du debugger, analyser le comportement de ce programme et interpréter le résultat.


## Une histoire de portes

* Créer une nouvelle classe `Porte` correspondant au diagramme de classe suivant :

    ![Diagramme UML Porte](/img/Porte_UML.png)
    
    Ce diagramme correspond au squelette de code source suivant. On peut noter que le constructeur sans argument est généré automatiquement par le compilateur java lorsqu'il ne trouve aucun constructeur.

    ```java

    public class Porte {

        public boolean estOuverte = false;
        public String couleur;

        public void ouvrir(){
            ...
        }

        public void fermer(){
            ...
        }

        public void franchir(){
            ...
        }	

    }

    ```

* Compléter le code source des méthodes de la classe `Porte` et créer une classe de tests `PorteTests`permettant de produire l'affichage suivant sur la console en ne créant qu'une seule porte et sans accéder directement à la variable d'instance estOuverte :

    ```
    Tentative de franchissement : Aïe !
    Tentative de fermeture : Fermer une porte déjà fermée hmmm...faut-il que je cloue des planches ?
    Tentative d'ouverture : Ouverture réussie
    Tentative d'ouverture : Ouvrir une porte déjà ouverte est un concept qui me dépasse...mais après tout je ne suis qu'une porte
    Tentative de franchissement : Quelqu'un franchit la porte.
    Tentative de fermeture : Fermeture réussie
    Tentative de franchissement : Aïe !
    ```

## Le mot clé static

* Modifier la classe `Porte` pour lui ajouter une variable `static` (variable de classe) :

    ```java
    public static double hauteur;
    ```
    
* Ajouter du code à votre classe `PorteTests` permettant de mettre en évidence que chaque instance de `Porte` possède une couleur mais que lorsque l'on modifie la hauteur d'une porte, toutes les autres changent également.

* Le mot clé `static` est très utilisé pour les méthodes qui ont un comportement de fonctions (au sens mathématique) :

    * les mêmes entrées produisent les mêmes sorties
    * pas de dépendance à un état de l'objet ou du programme
    * pas de modification de l'état de l'objet ou du programme
    * c'est le cas des fonctions mathématiques de la classe `Math` (abs, cos, floor, cf. [javadoc de la classe Math](http://docs.oracle.com/javase/7/docs/api/java/lang/Math.html))

---
    
* Créer une classe `Conversion` qui contiendra des méthodes statiques :

    ```java
    public static double toRpm(double radPerSec)
    public static double toRadPerSec(double rpm)
    ```
    
* Créer une classe de tests unitaires JUnit pour valider le bon fonctionnement de votre classe en vous inspirant de la vidéo suivante ([lien SPIRAL](http://spiralconnect.univ-lyon1.fr/webapp/player/HtmlVideoPlayer.html?idMedia=4032708&typeMedia=false)).

{% assign mp4_id = 4032708 %}
{% assign webm_id = 4032707 %}
{% include video.html %}
    
## Liste de courses

### Première partie

Dans cette partie, nous allons mettre en oeuvre la liste de courses qui a été vue en [TD](/cours/) en ajoutant quelques méthodes et une classe pour en faire une petite application.

Afin de structurer un peu les choses, nous allons regrouper les classes de cette petite application dans un package. Les packages servent à constituer des groupes de classes (qui se traduisent par des répertoires différents). Lorsque l'on veut utiliser des classes situées dans un autre package on utilise la directive `import`. Exemple :

```java
import javax.swing.JOptionPane;
```

La ligne précédente nous indique que l'on importe la classe `JOptionPane` située dans le package `javax.swing`.

Pour créer un package, il faut cliquer sur l'icône ![Icone package](/img/package_obj.png). Nous allons créer ici un package **shopping**. Les noms de packages doivent être en minuscules. Pour éviter que plusieurs utilisateurs utilisent le même nom de package, la recommandation est de débuter le nom du package par l'inverse du nom de domaine de l'entreprise (Exemple : `fr.univ_lyon1.iut.geii.shopping`). Si le package est sélectionné lors de la création d'une classe, celle-ci sera automatiquement ajoutée dans ce package. Sinon il est possible de choisir le package dans la boîte de dialogue de création de la classe. Quand une classe fait partie d'un package, son fichier source commence par une déclaration de package :

```java
package shopping;
```

Il est toujours possible a posteriori de faire glisser une classe vers un package dans eclipse. Les déclarations de package et les imports sont alors automatiquement mis à jour.

* Créer les classes `ShoppingList`et `ShoppingListItem` s'appuyant sur la classe `ArrayList` respectant le diagramme de classe ce-dessous
  
    ![](/img/CDC_ShoppingList.png)

    ![](/img/EclipseUmlLegend.png)

    * On utilise des variables d'instances privées ainsi que des accesseurs (*getters* et *setters*) pour y accéder (**encapsulation**). Les accesseurs peuvent être créées automatiquement dans Eclipse (menu *Source* puis *Generate Getters and Setters...*)

* Ecrire une classe `ShoppingListTest`contenant une méthode `main`dans laquelle vous validerez la possibilité de créer plusieurs listes et d'y ajouter/enlever des items, de les cocher/décocher. Vous pourrez utiliser le debugger pour valider le bon fonctionnement du programme.


### Deuxième partie : application en mode console

* Créer une classe `ShoppingListApp` qui permettra de gérer une liste de courses en ligne de commande. L'extrait suivant donne un exemple de déroulement du programme.

Le programme affiche le contenu de la liste et un menu.

```
--------------------------------------------------------------------------------------------
La liste ne contient aucun élément
+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
```
L'utilisateur tape <kbd>+</kbd> puis <kbd>Entrée</kbd>. Le système affiche alors :

```
Que voulez-vous ajouter à la liste de courses ?
````

L'utilisateur saisit "Lait" puis appuie sur <kbd>Entrée</kbd>. Le système affiche :

```
--------------------------------------------------------------------------------------------
1 Lait [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
```

Un nouvel appui sur <kbd>+</kbd> provoque l'affichage ci-dessous, suivi d'une alternance de saisies et de messages :

```
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
Saisir le numéro de l'item que vous voulez cocher/décocher (0 si aucun) ?
3
--------------------------------------------------------------------------------------------
1 Lait   [ ]
2 Beurre [ ]
3 Eau    [X]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
x
Saisir le numéro de l'item que vous voulez cocher/décocher (0 si aucun) ?
3
--------------------------------------------------------------------------------------------
1 Lait   [ ]
2 Beurre [ ]
3 Eau    [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
x
Saisir le numéro de l'item que vous voulez cocher/décocher (0 si aucun) ?
2
--------------------------------------------------------------------------------------------
1 Lait   [ ]
2 Beurre [X]
3 Eau    [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
-
Saisir le numéro de l'item que vous voulez supprimer (0 si aucun) ?
2
--------------------------------------------------------------------------------------------
1 Lait [ ]
2 Eau  [ ]

+ : Ajouter un item 	 - : enlever un item 	 x : (Dé)cocher un item 	 q : quitter
q
Fermeture de l'application
```

* On pourra utiliser indifféremment des minuscules et majuscules (x ou X, q ou Q)
* Pour récupérer des données saisies par l'utilisateur, on utilise l'entrée standard `System.in`. Cet objet est de type `InputStream` et les méthodes disponibles ne sont pas très commodes (lecture brute d'octets). On utilise donc la classe `Scanner` qui va *décorer* l'entrée standard en ajoutant des méthodes plus pratiques ([javadoc](http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html)).
    * On crée un scanner sur l'entrée standard de la façon suivante :
    
    ```java
    Scanner sc = new Scanner(System.in);
    ```
    
    * `sc.nextInt()` retourne l'entier saisi. Si les caractères saisis ne peuvent pas être convertis en un entier cela provoque une exception. On peut tester si le prochain élément saisi est un int avant d'appeler cette méthode en utilisant `sc.hasNextInt()`.
    
    * `sc.nextLine()` renvoie une objet de type String contenant le reste de la ligne saisie jusqu'au caractère de fin de ligne (qui n'est pas retourné par la méthode). Utilisé pour :
    
        * lire une chaîne de caractères.
        
        * purger le reste de la ligne après avoir lu un int ou un long par exemple. En effet `sc.nextInt()`ne consomme que l'entier et pas le caractère fin de ligne.
        
        ![](/img/scanner.png)
          
    
* Pour formatter les lignes `1 Lait [ ]` on pourra utiliser la méthode statique `format` de la classe `String`qui accepte une chaîne de formattage semblable au printf ([description des formatteurs](http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax) et [javadoc de la méthode](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#format(java.lang.String,%20java.lang.Object...))).

* La comparaison de chaînes de caractères doit se faire avec la méthode `equals` plutôt qu'avec l'opérateur `==`. En effet ce dernier compare les références (en quelques sorte les adresses en mémoire) alors que la méthode `equals` compare le contenu des chaînes de caractères

* A la fin de l'exécution de l'exemple précédent, on a le diagramme d'objets suivant (qui représente les objets créés en mémoire, leurs associations, ainsi que la valeur de leurs champs principaux). Sur cette représentation chaque objet est identifié de la manière suivante : `nomObjet:ClasseObjet`. On peut noter sur l'association le nom de la variable d'instance par laquelle se fait le lien entre les objets.

![](/img/ShoppingListObjectDiagram.png)

* Le squelette de la classe est le suivant, remplacer les `...` pour obtenir le comportement décrit.

```java

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
		while (true) {
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

	private String listContentString(ShoppingList list) {
		String listContent = "";
		...
		return listContent;
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
```
Remarque : en Java on peut faire un `switch` sur une chaîne de caractères.

