package com.esiea;

import com.sun.xml.internal.bind.v2.TODO;
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
            System.out.print(ANSI_RED+banqueMot.get(i)+ANSI_RESET);
        }
        System.out.println("\n");
    }

    public ArrayList comparerBanque(ArrayList motDiviser ) {
        int compte = 0;
        Boolean done = false;
        while (!done) {
            for (int i = 0; i < banqueMot.size(); i++) {

                ArrayList clean = motDiviser;
                String motActuelle = banqueMot.get(i);

                ArrayList<Character> motActuelleDiviser = new ArrayList<Character>();

                Mot.diviserMot(motActuelle, motActuelleDiviser);
                for (int j = 0; j < motActuelleDiviser.size(); j++) {
                    System.out.println("entering for 2");
                    for (int k = 0; k < clean.size(); k++) {
                        System.out.println("entering for 3");
                        if (motActuelleDiviser.get(j) == clean.get(k)) {
                            motDiviser.remove(j);
                            compte++;

                            if (compte == clean.size()) {
                                done = true;
                            } else {
                                motDiviser = clean;
                            }
                        }
                    }
                }

            }
        }
        System.out.println("return value: "+motDiviser);
        return motDiviser; //le reste de la comparaison entre motdiviser et mot de banque
    }
}
