---
title: Héritage et polymorphisme
layout: page
excerpt: Concepts et utilisation.
---

# Héritage - introduction

Une rapide introduction à ces 2 notions se trouve dans la deuxième partie du cours ([fichier PDF](http://spiralconnect.univ-lyon1.fr/spiral-files/download?mode=inline&data=3999567)).

Dans la programmation orientée objet, on constitue des hiérarchies d'héritage dans lesquelles les sous-classes héritent des champs et des méthodes de leur super-classe (classe mère).

Pour illustrer les principaux éléments de syntaxe Java liés à l'héritage nous allons nous appuyer sur la hiérarchie suivante :

![Diagramme de classes Vehicules](/img/Vehicules.png)


* La super-classe de toutes les classes est ici la classe `Vehicule`, elle possède :

    - une variable d'instance privée `double vitesse` qui stocke la vitesse du véhicule.
    
    - un getter `double getVitesse()`et un setter `void setVitesse(double vitesse)` pour permettre l'accès à la variable *encapsulée*
    
    - une méthode `void faireDuBruit()`
    
    - un constructeur par défaut (ajouté automatiquement par le compilateur Java)
    
    - Le code correspondant est :
    
        ```java
        package heritage;

        public class Vehicule {

            private double vitesse = 0.0;

            public double getVitesse() {
                return vitesse;
            }

            public void setVitesse(double vitesse) {
                this.vitesse = vitesse;
            }

            public void faireDuBruit() {
                System.out.println("Je roule à " + vitesse + " km/h");
            }

        }
        ```

    
* La sous-classe `Velo` hérite de `Vehicule`. On dit qu'elle *étend* la classe `Vehicule` et on utilise le mot clé Java `extends`. Un Velo **EST UN** Vehicule. La sous-classe spécialise sa super-classe. On la déclare de la manière suivante :

    ```java
    public class Velo extends Vehicule
    ```

    - la méthode `setVitesse` est un peu trop permissive pour le vélo, on peut donc la redéfinir (*override*). Pour reféfinir une méthode on réécrit une définition portant exactement la même signature que la méthode de la super-classe (même nom, même nombre d'arguments et mêmes types d'argument).
    
        ```java
        @Override
        public void setVitesse(double vitesse) {
            ...
        }    
        ```
    
    - L'annotation `@Override` n'est pas obligatoire mais elle permet de dire au compilateur que l'on souhaite redéfinir une méthode. Il va alors vérifier qu'il existe bien dans la hiérarchie (super-classe, super-super-classe, ...) une méthode ayant exactement la même signature. Si on a fait une faute de frappe, le compilateur pourra donc la détecter. Il est même possible d'utiliser Eclipse pour générer la déclaration des méthodes redéfinies (Menu *Source* puis *Override/Implement Methods...*)
    
    - Dans le corps de la méthode redéfinie on peut également faire un appel à la version de la super-classe, en utilisant le mot clé `super`.
    
        ```java
            @Override
            public void setVitesse(double vitesse) {
                if (vitesse >= 60) {
                    System.out.println("Doucement fada ! Je suis en vélo !");
                    vitesse = 60;
                } else if (vitesse < 0) {
                    System.out.println("De la marche arrière sur un vélo ?");
                    vitesse = 0;
                }
                super.setVitesse(vitesse);
            }
            
            @Override
	       public void faireDuBruit() {
		      super.faireDuBruit();
		      System.out.println("Dring dring !");
	}
        ```
    
    
* Créer ces 2 classes (`Vehicule` et `Velo`) puis une troisième classe pour faire des tests (`VehiculesTests`). Dans cette classe il faudra ajouter une méthode `main` pour créer un Vehicule et un Velo. Vérifier le comportement du programme lorsqu'on appelle chacune des méthodes.

* Vérifier qu'il est bien possible d'appeler la méthode `getVitesse` sur l'instance de la sous-classe `Velo`, bien qu'elle n'ait pas fait l'objet d'une redéfinition. Ceci vise à mettre en évidence le fait que les sous-classes héritent des méthodes définies dans leur super-classe.

* Vérifier en créant deux objets de type `Velo` distincts qu'ils peuvent bien avoir chacun une vitesse différente afin de mettre en évidence le fait que les sous-classes héritent des variables d'instance de leur super-classe.

* Compléter la hiérarchie d'héritage avec les classes suivantes en remplaçant les `...` par le code approprié

    ```java
    package heritage;
    
    public class Voiture extends Vehicule {

        @Override
        public void setVitesse(double vitesse) {

            if (vitesse > 130) {
                ...
            }

            ...
        }

        @Override
        public void faireDuBruit() {
            super.faireDuBruit();
            System.out.println("Vroom vroom");
        }

    }
    ```
    
    ```java
    package heritage;

    public class Train extends Vehicule {

        @Override
        public void faireDuBruit() {
            super.faireDuBruit();
            System.out.println("Tchou tchou");
        }

    }
    ```
    
    ```java
    package heritage;

    public class VoitureAutomatique extends Voiture {
        private int rapportDeVitesse = 1;

        public int getRapportDeVitesse() {
            return rapportDeVitesse;
        }

        @Override
        public void setVitesse(double vitesse) {
            rapportDeVitesse = Math.min(5, (int)(vitesse / 20) + 1);
            super.setVitesse(vitesse);
        }

        @Override
        public void faireDuBruit() {
            super.faireDuBruit();
            System.out.println("Et en plus je roule en vitesse : " + rapportDeVitesse);
        }
    }
    ```

* Cette dernière classe ajoute une variable d'instance `rapportDeVitesse` et le getter qui va avec.

* Dans la classe `VehiculesTests` créer des instances de chacune de ces classes et vérifier que vous pouvez invoquer les différentes méthodes et que le comportement correspond bien au type de la variable.

---

# Polymorphisme

Le polymorphisme consiste à écrire du code qui ne dépend pas du type concret des objets. Cela revient à utiliser des variables ou des paramètres de méthodes de type `Vehicule` qui recevront indifféremment des instances de n'importe laquelle des classes de la hiérarchie. Exemple :

```java
private static void triturerVehicule(Vehicule vehicule){
    vehicule.faireDuBruit();
    vehicule.setVitesse(vehicule.getVitesse() + 30);
    vehicule.faireDuBruit();
}
```

Le type d'une variable définit les méthodes que l'on peut appeler ainsi que les champs accessibles. On ne peut donc pas accéder aux spécificités de la sous-classe mais on peut la traiter comme une instance de la super-classe.

* Modifier le code de la classe `VehiculesTests`en créant un variable de type `Vehicule` qui référencera successivement un vélo, une voiture, une voiture automatique,...

    - Vérifier qu'il n'est possible d'appeler que les méthodes disponibles sur la classe `Vehicule` (impossible d'utiliser `getRapportVitesse()` même si l'objet effectivement référencé est de type `VoitureAutomatique`
    - Vérifier que l'appel de `faireDuBruit()` dépend bien du type concret de l'objet référencé et non pas du type de la variable

* Créer une liste de véhicules de type `ArrayList<Vehicule>` et la passer à une fonction prenant en paramètre une liste de véhicules qui appellera une combinaison de `faireDuBruit()`, `setVitesse(...)` sur chacun des éléments de la liste.

---

# Héritage et visibilité

Bien que présents dans les instances, les champs privés d'une super-classe ne sont pas accessibles directement depuis le code source des sous-classes. Dans la classe `Voiture` de l'exemple précédent, on ne peut pas utiliser directement la variable `vitesse`, il est par contre possible d'utiliser les *setters* et *getters* qui sont *public*. Il existe un mot clé supplémentaire si on veut rendre le champ visible aux sous-classes, il s'agit de `protected`.

En résumé, les modificateurs de visibilité sont (du plus sévère au plus laxiste) :

* `private` : accessible seulement depuis la classe dans laquelle la définition est écrite

* '*default*' : l'absence de mot clé donne une visibilité à toutes les classes appartenant au même package

* `protected` : accessible depuis les classes du même package et depuis toutes les sous-classes

* `public`: accessible depuis n'importe quelle classe

---

# Exercice : étudiants

* Créer une classe `Etudiant` et deux sous-classes `BonEtudiant`et `MauvaisEtudiant`conformément au diagramme ci-dessous

    ![Etudiants](/img/Etudiants.png)
    ![Legende Eclispe UML](/img/EclipseUmlLegend.png)
    
* Remarque importante : la classe Etudiant n'a pas de constructeur par défaut (sans argument). Or, lors de leur instanciation, les sous-classes doivent appeler le constructeur de leur super-classe. Le compilateur Java ne rajoute ces appels que pour les constructeurs sans argument. Dans le cas contraire, il faut créer des constructeurs explicitement et faire en sorte qu'ils délèguent le travail au super-constructeur approprié.

* La méthode `reagirAUneNote` est définie dans la classe `Etudiant` mais elle appelle des méthodes `protected` qui sont redéfinies dans les sous-classes (les versions de la super-classe se contenteront pour l'instant de retourner 0). Le code qui décrit la logique de l'algorithme n'est pas dupliqué certaines étapes peuvent être spécialisée par les sous-classes.

    ```java
        public void reagirAUneNote(double note) {
            System.out.print(prenom + " " + nom + " : J'ai eu " + note +"/20. ");
            if (note >= getSeuilCool()) {
                System.out.println("trop cool !");
            } else if (note >= getSeuilPasPire()) {
                System.out.println("pas pire.");
            } else if (note >= getSeuilLoose()) {
                System.out.println("la loose !");
            } else {
                System.out.println("la cata !");
            }
        }
    ```

    Pour un bon étudiant, on pourra régler les seuils 12, 14 et 16. Pour un mauvais étudiant on prendra 8, 10 et 12.
    
* Créer une classe `EtudiantsTests` pour valider le bon fonctionnement de vos classes et tester les réactions de vos étudiants à différentes notes (il est possible de faire une boucle for).

* On s'intéresse maintenant à la méthode `passerUnPartiel`.

    - Pour un bon étudiant la méthode se contentera d'afficher le message suivant sur la console :
    
        ```
            Tilalilalou : je sors mes fiches de synthèse
            Tiens j'ai déjà fini et je n'ai pas eu besoin de les regarder !
        ```
        
    - Pour un mauvais étudiant, la méthode commencera par prendre 2 feuilles doubles au bon étudiant référencé par la variable d'instance `etudiantATaxer` puis affichera le message suivant : 
    
        ```
            Est-ce qu'on a droit aux documents ?
            Si j'écris tout petit, il arrivera pas à me relire et me mettra les points dans le doute.
            Je vais gratter 5 minutes de plus avant de rendre ma copie.
            La loi d'Ohm c'est le carré de l'hypothénuse ? Ah non, je suis bête ça c'est Thales !
        ```

* Compléter les classes et tester.