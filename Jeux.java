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

        System.out.println("Merci, vous êtes maintenant le Joueur 1. N'oublie pas, connard.\n");

        Boolean Test = quiCommence(J);
        //nouveauTour(Test);

        startGame(Test);
    }

    public void startGame(Boolean J) throws IOException {
        System.out.println("\nDebut du jeu...");

        nouveauTour(J);
        //TODO: START_GAME where all the magic happens
    }




    public void appuyezSurEntree()
    {
        try { System.in.read(); }
        catch(Exception e) {}
    }

    public Boolean quiCommence(Boolean J) {                           //comparer qui commence
        System.out.println("Determination du Premier joueur...");
        Boolean joueurChoisi = false;
        String str1 = "La même lettre est tombé! On aurait dit Romeo & Juliette. Recalculating...";
        String str2 = "Le Premier joueur commence! Promis il m'a pas donner de billet";
        String str3 = "Le Deuxieme joueur commence! Ne soit pas jaloux.";
        Character J1 = null;
        Character J2 = null;

        while (!joueurChoisi) {
            J1 = pot.NewLetter();
            J2 = pot.NewLetter();
            int res = J1.compareTo(J2);

            if (res == 0) {
                System.out.println(str1);
                //TODO: REMOVE LES LETTRES DU PC

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


    public void nouveauTour(Boolean J) throws IOException {    //BOUCLE DE CHAQUE TOUR
        Boolean TourFinis = false;
        while (!TourFinis) {

            pot.NewTurnRandomLettre();

            //AFFICHAGE
            Printatour(J);
            if (J) J1.showBanque();
             else J2.showBanque();
            pot.showPotCommun();


            //DEBUT SCAN
            String motScanne = mot.scanMot();
            mot.verifierMot(motScanne);
            ArrayList<String> motDiviser = new ArrayList<>();

            //VERIFICATION PC BANQUE

            mot.diviserMot(motScanne, motDiviser);

            //mot.verifier banque
            //if (J) J1.ajouterABanque();
            //else J2.ajouterABanque();




            J1.comparerBanque(motDiviser);


            TourFinis = true;
            System.out.println("Fin du Tour! \n");
        }
    }


    public void Printatour(Boolean J)
    {
        if ( J == Boolean.TRUE) //donc tour J1
            System.out.println(ANSI_BLUE +"Tour du Joueur 1. On t'attend, Cowboy\n" + ANSI_RESET);
        else System.out.println(ANSI_GREEN + "Tour du Joueur 2. Pecheur, va pecher!\n" + ANSI_RESET);
    }




}
