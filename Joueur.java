package com.esiea;

import com.sun.xml.internal.bind.v2.TODO;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;
import static java.sql.Types.NULL;

/**
 * Created by Gen on 08/02/2017.
 */
public class Joueur {

    //la banque à mot des utilisateur
    private ArrayList<String> banqueMot = new ArrayList<>();


    //ajouter a la banque a mot d'un utilisateur
    public void ajouterABanque(String nouveauMot) { //correspond a motTemp
        banqueMot.add(nouveauMot);
		/*Ajouter element avec l'index en question (ici on s'en fou en vrai)

	 	arrayListColl.add(0, "Rahul"); */
    }

    // supprimer un mot de la banque
    public void DeleteDeBanque(String nouveauMot) {
        banqueMot.remove(nouveauMot);
    }

    public void compterMotJoueur() {}


    public void Verifier() { //plusieurs des fonctions utilisées }
    }
}
