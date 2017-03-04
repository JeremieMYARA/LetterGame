Comment compiler le projet : 

javac -sourcepath src src/com/esiea/*.java

Problème rencontré :

Nous souhaitions vous exposer nos difficultés à réaliser une fonction du projet. 
Suite à des semaines de travail, nous n’avons pas pu accomplir la totalité des fonctionnalités demandées pour faire fonctionner le jeu. Pour la première fois, nous nous sommes réellement penchés sur la programmation Java qui n’est pas notre principal atout puisque nous n’avions que peu de notions avant de commencer à programmer ce projet. Nous avons traduit le projet en pseudo-code ce qui nous a permis de comprendre en détail ce projet et ce langage. Nous avons été stoppé dans notre élan par la méthode « ComparerBanque() ». 


Cette fonction avait pour but de comparer le mot d'un joueur dans sa banque avec la mot saisi par l'utilisateur. Pour cela, nous comparons chaque mot de la banque, en le divisant dans une ArrayList de caractères, toutes les lettres de celui-ci devront être contenues dans les lettres du mot saisi. C'est à cet endroit de la fonction que cela ne marche pas comme prévu. Le comportement du compilateur n'est pas régulier ce qui nous a empêché de trouver la solution.
Par la suite, nous aurions pu récupérer le reste des lettres du mot saisi qui auraient pu être comparées ensuite avec les lettres présentes dans le Pot Commun. A ce moment là, le mot aurait pu être validé, ce qui aurait eu pour effet de retirer le mot à l'adversaire.
Toutefois nous tenons à préciser que toutes les autres fonctionnalités sont correctement mises en place et que notre volonté de répondre aux besoins du projet a été notre priorité.

EXERCICES :

Architecture du projet LetterGame

2 packages : main / ressources

5 classes

Notre programme se découpe en 2 packages : Le package Main qui regroupe toutes les méthodes et classes de notre projet et le package ressources qui regroupe les données permettant la vérification grammaticale des mots (dictionnaire)

Dans le package Main, nous avons découpé le programme en 5 classes : Joueur, PotCommun, Mot, Jeux et main.

--La classe Joueur permet de gérer la banque de mot de chaque joueur qui sera instanciée dans la classe main.
--La classe PotCommun permet d'initialiser les lettres à chaque nouveau tour afin de les placer dans le pot commun ou au contraire de gérer le retrait des lettres.
--La classe Mot permet à l'utilisateur d'enregistrer son mot et de le diviser afin d'effectuer les vérifications nécessaires sur le dictionnaire, le pot commun et les banques des joueurs.
--La classe Jeux contient les fonctions nécessaires au lancement du jeu ainsi que la fonction qui permet de définir quel joueur commence.

Principe SOLID

Notre programme est constitué de nombreuses classes qui n'ont qu'une seule fonction. Nous pouvons dire que la classe Mot ne s'occupera que des éléments en rapport avec le mot, de même pour les 4 autres classes qui s'occuperont chacune d'un axe que constitue notre projet. Le principe S du SOLID est donc bien respecté.
