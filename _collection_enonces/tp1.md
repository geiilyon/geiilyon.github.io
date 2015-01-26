---
title: Introduction.
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

Suivez les instructions présentes dans la video suivante (disponible également sur [SPIRAL]("http://spiralconnect.univ-lyon1.fr/webapp/player/HtmlVideoPlayer.html?idMedia=4024274&typeMedia=false")) pour agencer les fenêtres et créer et exécuter votre premier projet Eclipse.

<video width="60%" height="100%" controls>
  <source src="http://spiralconnect.univ-lyon1.fr/spiral-files/download?mode=inline&data=4024274" type="video/mp4">
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

Créer une nouvelle classe `ExperimentationChaines2` qui devra afficher le même résultat mais en concaténant les 4 chaînes dans une seule chaîne qui contiendra le résultat et sera passée à une fenêtre de dialogue pour l’affichage.
Le retour à la ligne est codé différemment selon les systèmes d’exploitation :

* 0x0A (Unix, Linux, Mac OS X, ...)

* 0x0D (Commodore, ...)

* 0x0D 0x0A (Windows, ...)

Pour pallier ce problème, la classe System de java permet de récupérer la chaîne associée au retour à la ligne :

```java
String lineSep = System.getProperty("line.separator");
```

Remplacer l’utilisation de System.out.println par `JOptionPane.showMessageDialog(null,message);` où message est une variable de type `String` contenant le message à afficher. Vous aurez besoin d’importer la classe `JOptionPane` (utiliser les suggestions de résolution d’erreur d’Eclipse en cliquant sur la petite croix rouge en début de ligne).

