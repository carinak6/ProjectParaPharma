package com.parapharma.analytics;

import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//ajouter Scanner si on veut que l'utilisateur tape le nom du fichier d'entrée et sortié
		String filepath = "symptoms.txt";
		String fileOut = "resultN.out";		
		
		/*declaration de l'objet qui va gerer les compteurs*/
		AnalyticsCounter compteur = new AnalyticsCounter(filepath);
		
		/*declaration de la variable qui va recevoir la liste des syntomes ordenée et ses compteurs*/
		TreeMap<String, Integer> listeSymptomsSort = new TreeMap<>();
		
		/*on appel la methode counter pour faire le calcule des compteurs des symptoms*/
		listeSymptomsSort= compteur.counter();
		
		/*System.out.println(listeSymptomsSort);*/
		
		//declaration de l'objet qui gere la creation du fichier de sortie
		WriteSymptomFromFile enregistreSymptomes = new WriteSymptomFromFile(fileOut);
		enregistreSymptomes.writeSymptoms(listeSymptomsSort);
		
		
	}

}
