package com.esiea;

import java.util.ArrayList;

import com.esiea.Mot.*;

import static com.esiea.Jeux.ANSI_RED;
import static com.esiea.Jeux.ANSI_RESET;


/**
 * Created by Gen on 08/02/2017.
 */
public class Joueur {

    //la banque à mot des utilisateur
    private ArrayList<String> banqueMot = new ArrayList<>();



    public void ajouterABanque(String nouveauMot) { //correspond a motTemp
        banqueMot.add(nouveauMot);                  //ajouter a la banque a mot d'un utilisateur
    }


    public void DeleteDeBanque(String nouveauMot) { // supprimer un mot de la banque
        banqueMot.remove(nouveauMot);
    }

    public int compterMotJoueur() {
        return banqueMot.size();
    }

    public void showBanque() {

        System.out.println("Banque du joueur: ");
        for(int i = 0; i < banqueMot.size(); i++) {
            System.out.print(" "+ANSI_RED+banqueMot.get(i)+ANSI_RESET);
        }
        System.out.println("\n");
    }

    public ArrayList comparerBanque(ArrayList motDiviser ) {
        int compte = 0;
        Boolean done = false;
        while (!done) {
            for (int i = 0; i < banqueMot.size(); i++) {   //FOR EACH WORD IN ARRAYLIST

                ArrayList clean = motDiviser;
                String motActuelle = banqueMot.get(i);
                String cleanBanque = motActuelle;
                ArrayList<Character> motActuelleDiviser = new ArrayList<Character>();  // DIVIDE STRING INTO ARRAY LIST
                Mot.diviserMot(motActuelle, motActuelleDiviser);

                for (int j = 0; j < motActuelleDiviser.size(); j++) {         // FOR EVERY letter of divided string

                    for (int k = 0; k < clean.size(); k++) {                 // for every letter in mot Saisis

                        if (motActuelleDiviser.get(j) == clean.get(k)) {    // if same, then remove the letter
                            clean.remove(j);
                            motActuelleDiviser.remove(k);
                            compte++;

                            if (compte == clean.size()) {                  // if you have removed all the letters then
                                done = true;                               // all good
                            } else {
                                motDiviser = clean;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("return value: "+motDiviser);
        return motDiviser;                                //le reste de la comparaison entre motdiviser et mot de banque
    }
}
