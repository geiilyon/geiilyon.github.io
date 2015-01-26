---
title: Introduction
layout: page
excerpt: Prise en main d'Eclipse. Création de projets, classes, expérimentations sur les objets
---

# Prise en main d'Eclipse

Lors du lancement, Eclipse demande de choisir/créer un *workspace*. Ce dossier permettra de stocker plusieurs *projets*. Pour ce module nous utiliserons toujours le même workspace. Nommez le **workspace eclipse** et enregistrez le dans votre dossier Mes Documents.

![Dialogue Eclipse workspace](/img/EclipseWorkspaceDialogue.png)

## L'incontournable Hello World !

```java
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello world !");
    }
}
```

Suivez les instructions présentes dans la vidéo suivante (vous devez avoir une session SPIRAL active pour accéder à la vidéo. Suivre le [lien pour voir la video sur SPIRAL](http://spiralconnect.univ-lyon1.fr/webapp/player/HtmlVideoPlayer.html?idMedia=4024274&typeMedia=false)) pour agencer les fenêtres et créer et exécuter votre premier projet Eclipse.

<video width="60%" height="100%" controls>
  <source src="http://spiralconnect.univ-lyon1.fr/spiral-files/download?mode=inline&data=4024274" type="video/mp4">
  <source src="http://spiralconnect.univ-lyon1.fr/spiral-files/download?mode=inline&data=4025132" type="video/webm">
Your browser does not support the video tag.
</video>


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
    
<video width="60%" height="100%" controls>
    <source src="http://spiralconnect.univ-lyon1.fr/spiral-files/download?mode=inline&data=4025470" type="video/mp4">
    <source src="http://spiralconnect.univ-lyon1.fr/spiral-files/download?mode=inline&data=4025458" type="video/webm">
    Your browser does not support the video tag.
</video>



## Passage par valeur / références


## Une histoire de portes


## Etudiants


## Liste de courses


## 