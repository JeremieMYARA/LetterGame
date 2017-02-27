package com.esiea;

/**
 * Created by Gen on 08/02/2017.
 */
public class Jeux {

    public void menu() {
        System.out.println("Bienvenue dans LetterGame.\n\n");
        System.out.println("Joueur 1, veuillez appuyer sur Entrée...");
        appuyezSurEntree();
        System.out.println("Merci, vous êtes maintenant le Joueur 1. N'oublie pas, connard.\n");
        startGame();
    }


    private void startGame() {
        System.out.println("Debut du jeu...\n");
    }

    private void appuyezSurEntree()
    {
        try { System.in.read(); }
        catch(Exception e) {}
    }
}
