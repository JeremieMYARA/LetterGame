package com.esiea;

import java.io.IOException;
import java.util.ArrayList;

public class Jeux {
    public Boolean J = true; // TRUE = JOUEUR 1 COMMENCE
    public Boolean Test ;
    Joueur J1 = new Joueur();
    Joueur J2 = new Joueur();
    Mot mot = new Mot();
    PotCommun pot = new PotCommun();

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";



    public void menu() throws IOException {
        System.out.println("Bienvenue dans LetterGame.\n\n");
        System.out.println("Joueur 1, veuillez appuyer sur Entrée...");
        appuyezSurEntree();

        System.out.println("Merci, vous êtes maintenant le Joueur 1.\n");

        Boolean Test = quiCommence(J);
        //nouveauTour(Test);
         startGame(Test);
    }

    public void startGame(Boolean J) throws IOException {
        System.out.println("\nDebut du jeu...");
        Boolean inGame = new Boolean(true);
        while( inGame) {
            nouveauTour(J);
            J = !J;

        }
    }

    public void appuyezSurEntree()
    {
        try { System.in.read(); }
        catch(Exception e) {}
    }

    public Boolean quiCommence(Boolean J) {                           //comparer qui commence
        System.out.println("Determination du Premier joueur...");
        Boolean joueurChoisi = false;
        String str1 = "La même lettre est tombée! Quel hasard! Relance en cours...";
        String str2 = "Le Premier joueur commence! Promis, il ne m'a pas donné de billet.";
        String str3 = "Le Deuxieme joueur commence! Ne sois pas jaloux.";
        Character J1 = null;
        Character J2 = null;

        while (!joueurChoisi) {
            J1 = pot.NewLetter();
            J2 = pot.NewLetter();
            int res = J1.compareTo(J2);

            if (res == 0) {
                System.out.println(str1);


            } else if (res > 0) {
                System.out.println(ANSI_BLUE +str2+ ANSI_RESET);
                J = true;
                joueurChoisi = true;

            } else if (res < 0) {
                System.out.println(ANSI_GREEN +str3+ ANSI_RESET);
                J = false;
                joueurChoisi = true;
            }
        }
        return J;
    }

    public boolean nouveauTour(Boolean J) throws IOException {    //BOUCLE DE CHAQUE TOUR
        int MotsJ1, MotsJ2;
        MotsJ1 = J1.compterMotJoueur();
        MotsJ2 = J2.compterMotJoueur();

        if (MotsJ1 == 10) {
            System.out.println(ANSI_RED +"Le Joueur 1 a Gagné!!"+ ANSI_RESET);
            System.exit(1);
            return false;

        } else if (MotsJ2 == 10) {
            System.out.println(ANSI_RED +"Le Joueur 2 a Gagné!!"+ ANSI_RESET);
            System.exit(1);
            return false;
        }

        Boolean TourFinis = false;
        while (!TourFinis) {

            pot.NewTurnRandomLettre();

            //AFFICHAGE
            Printatour(J);
            if (J) J1.showBanque();
             else J2.showBanque();
            pot.showPotCommun();


            //DEBUT SCAN
            String motScanne ;

            Boolean checkit; //Tant qu'un mot n'est pas valide, essayer
             do {
                motScanne = mot.scanMot();
                checkit = mot.verifierMot(motScanne);
            } while (!checkit);

            //System.out.println("Test");
            // ArrayList<String> motDiviser = new ArrayList<>();

            //VERIFICATION PC BANQUE
            // mot.diviserMot(motScanne, motDiviser);
            //J1.comparerBanque(motDiviser);


            TourFinis = true;
            System.out.println("Fin du Tour! \n");
        }
        return true;
    }


    public void Printatour(Boolean J)
    {
        if (J) //donc tour J1
            System.out.println(ANSI_BLUE +"Tour du Joueur 1. On t'attend, Cowboy\n" + ANSI_RESET);
        else System.out.println(ANSI_GREEN + "Tour du Joueur 2. Fais chauffer tes neurones!\n" + ANSI_RESET);
    }

}
