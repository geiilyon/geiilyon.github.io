---
title: Introduction
layout: page
excerpt: Prise en main d'Eclipse. Création de projets, classes, expérimentations sur les objets
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


La complétion automatique de code sous Eclipse est activée par le raccourci clavier <kbd>Ctrl</kbd>+<kbd>Espace</kbd>.

Il existe de nombreux *templates* pour compléter automatiquement des blocs de codes. Les plus utiles sont les suivants :

* `sysout` (taper syso puis <kbd>Ctrl</kbd>+<kbd>Espace</kbd>)

* `main`

* `new`

* `foreach`

* `ifelse`

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

* Créer une nouvelle classe `ExperimentationChaines2` qui devra afficher le même résultat mais en concaténant les 4 chaînes dans une seule chaîne qui contiendra le résultat et sera passée à une fenêtre de dialogue pour l’affichage.

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
    Pour la comparaison des lettres des deux mots, elle peut se faire en 3 lignes de code en utilisant 2 méthodes de la classe `Arrays` ([javadoc de la classe Arrays](http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html)).
    
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

* Compléter le code source des méthodes de la classe `Porte` et créer une classe de tests `PorteTests`permettant de produire l'affichage suivant sur la console :

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
    
* Ajouter du code à votre classe `PorteTests` permettant de mettre en évidence que chaque instance de porte possède une couleur mais que lorsque l'on modifie la hauteur d'une porte, toutes les autres changent également.

* Le mot clé `static` est très utilisé pour les méthodes qui ont un comportement de fonctions (au sens mathématique) :

    * les mêmes entrées produisent les mêmes sorties
    * pas de dépendance à un état de l'objet ou du programme
    * pas de modification de l'état de l'objet ou du programme
    * c'est le cas des fonctions mathématiques de la classe `Math` (abs, cos, floor, cf. [javadoc de la classe Math](http://docs.oracle.com/javase/7/docs/api/java/lang/Math.html))

---
    
* Créer une classe `Conversion` qui contiendra des méthodes statiques :

    ```java
    double toRpm(double radPerSec)
    double toRadPerSec(double rpm)
    double toFahrenheitDegrees(double celsiusDegrees)
    double toCelsiusDegrees(double fahrenheitDegrees)
    ```
    
Rappel : la formule reliant la température en degrés Fahrenheit à la température en degrés Celsius est Tf = ( Tc x 1.8 ) + 32

## Etudiants


## Liste de courses


