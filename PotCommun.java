package com.esiea;

import java.util.ArrayList;

import static com.esiea.Jeux.ANSI_RED;
import static com.esiea.Jeux.ANSI_RESET;

public class PotCommun {

    //TODO: VERIFIER_POT verifier avec le pot et coordonner avec la banque joueur
    private ArrayList<Character> potCommun = new ArrayList<>();

    public Character randomination(){
        //fonction genereal qui va prendre une lettre au hasard
        String Alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZAEOIUAEOIU";
        int character=(int)(Math.random()*36);
        String dassaut = Alpha.substring(character, character+1);

        Character L = dassaut.charAt(0);

        //System.out.println("La lettre au hasard est: "+dassaut+"\n");
        return L;
    }


    public Character NewLetter() {
        System.out.println("Generation de nouvelle lettre...");
        Character L = randomination();
        AddToPotCommun(L);

        return L;
    }


    public void NewTurnRandomLettre(){
        Character L = randomination();
        AddToPotCommun(L);
        Character M = randomination();
        AddToPotCommun(M);
        System.out.println("Nouveau tour, nouvel lettre: "+ L + " et "+ M +". Bonne peche!");
    }

    public void AddToPotCommun( Character L) {
        potCommun.add(L);
    }

    public void RemoveFromPotCommun(Character L) {
        potCommun.remove(L);
    }

    public void showPotCommun() {

        System.out.println("Le Pot commun: ");
        for(int i = 0; i < potCommun.size(); i++) {
            System.out.print(ANSI_RED+potCommun.get(i)+" "+ANSI_RESET );
        }
        System.out.println("\n");
    }

    public Boolean comparerPC(ArrayList resteMot) {
        ArrayList<Character> templist = new ArrayList<Character>();
        templist = resteMot;


            for (int i = 0; i < resteMot.size(); i++) {
                for (int j = 0; j < potCommun.size(); j++) {

                    if (templist.get(i) == potCommun.get(j)) {
                        templist.remove(i);
                    }

                    if (templist.isEmpty()) {
                        potCommun.removeAll(resteMot);
                        System.out.println("mot validé. Enlevé du pot commun.");
                        return true;
                    }
                }
            }
        System.out.println("Mot pas dans le PC, le mot n'est pas validé.");

        return false;
    }

}
