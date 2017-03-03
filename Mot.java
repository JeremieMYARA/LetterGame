package com.esiea;
import com.esiea.Joueur;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mot {

    String TempTestLetter = null ; //



    //scanner le mot, verifie qu'il est pas vide et action.
    public String scanMot()
    {
        System.out.println("Veuillez entrer un mot...");
        Scanner scanner = new Scanner( System.in ); //Creer le scanner
        String motEcrit = scanner.nextLine();   // Mot Ecrit = le mot ecrit par l'utilisateur, TempTestLetter
        try {
            if (motEcrit == "" || motEcrit == null) {
                System.out.println("Aucun mot écrit. L'utilisateur passe son tour (c une tafiole)");
                //TODO: SCANMOT CHANGER LE TOUR
            }
            else  {
                setTempTestLetter(motEcrit);
                System.out.println("Le mot scanné est " + TempTestLetter);
            }
        }
        catch(Exception e) {
            //log4j ERREUR
        }
        return TempTestLetter;
    }


    public void choisirMot () {
    //TODO: ChoisirMot
    }

    public static ArrayList diviserMot(String motEcrit, ArrayList listeTemp) {
        for (int i = 0; i < motEcrit.length(); i++) {
            listeTemp.add(motEcrit.charAt(i));
        }
        return listeTemp;
    }

    public static ArrayList diviserMot(String motEcrit) {
        ArrayList listeTemp = null;
        for (int i = 0; i < motEcrit.length(); i++) {
            listeTemp.add(motEcrit.charAt(i));
        }
        return listeTemp;
    }


    public boolean verifierMot(String motEcrit) throws IOException {
		String chaine= "";
		String fichier = "./src/com/ressources/dico.txt";
		Boolean MotVerifier = false;

        InputStream ips = new FileInputStream(fichier);
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        String ligne;
		//Lecture du fichier texte	
		try {

			//Lire ligne par ligne et comparer.
			do {
				while ( (ligne=br.readLine())!= null) {
					chaine = ligne;
					if (chaine.equals(motEcrit)) {
						MotVerifier = true; //quand cest bon, boolean dit que oui
						System.out.println("Le mot "+ motEcrit + " est trouvé dans le dictionnaire.");
					}
				}

			} while (MotVerifier = false); //pas dans le dico
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		br.close(); //fermer le fichier
		return MotVerifier; //fin de fonction
	}

    public String getTempTestLetter() {
        return TempTestLetter;
    }

    public void setTempTestLetter(String tempTestLetter) {
        TempTestLetter = tempTestLetter;
    }
}