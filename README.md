Comment compiler le projet : 
javac -sourcepath src src/com/esiea/*.java

Architecture du projet LetterGame

2 packages : main / ressources

5 classes

Notre programme se découpe en 2 packages : Le package Main qui regroupe toutes les méthodes et classes de notre projet et le package ressources qui regroupe les données permettant la vérification grammaticale des mots (dictionnaire)

Dans le package Main, nous avons découpé le programme en 5 classes : Joueur, PotCommun, Mot, Jeux et main.

--La classe Joueur permet de gérer la banque de mot de chaque joueur qui sera instancié dans la classe main.
--La classe PotCommun permet d'initialiser les lettres à chaque nouveau tour afin de les placer dans le pot commun ou au contraire de gérer le retrait des lettres.
--La classe Mot permet à l'utilisateur d'enregistrer son mot et de le diviser afin d'effectuer les vérifications nécessaires sur le dictionnaire, le pot commun et les banques des joueurs.
--La classe Jeux contient les fonctions nécessaires au lancement du jeu ainsi que la fonction qui permet de définir quel joueur commence.
Principe SOLID

Notre programme est constitué de nombreuses classes qui n'ont qu'une seule fonction. Nous pouvons dire que la classe Mot ne s'occupera que des éléments en rapport avec le mot, de même pour les 4 autres classes qui s'occuperont chacune d'un axe que constitue notre projet. Le principe S du SOLID est donc bien respecté.
