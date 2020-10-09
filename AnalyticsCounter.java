package com.parapharma.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class AnalyticsCounter {
	private TreeMap<String, Integer> symptoms = new TreeMap<>();
	private String filepath = "";
	
	/*
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		*/
	
	public AnalyticsCounter(String cheminFichier) {
		filepath = cheminFichier;
	}
		
	public TreeMap<String, Integer> counter(){	
		
		/*on cree l'objet ReadSymptomDataFromFile pour avoir la liste des symtoms  */
		ReadSymptomDataFromFile listeSympt = new ReadSymptomDataFromFile(filepath);
				
		
		List<String> liste = listeSympt.GetSymptoms();	/*je genere la liste des simptom*/
						
		/*on parcours la liste de symptoms*/
		for(String element: liste) {
			
			/*on enregistre les compteurs dans le TreeMap*/
			if(symptoms.containsKey(element)) {/*on trouve le symptom*/
				
				/*on increment le compteur du sympton*/					
				symptoms.put(element,symptoms.get(element)+1);
				//symptoms.merge(element,1, Integer::sum);
				
			}else {
				/*dans le cas que c est un nouveaux sympton*/
				symptoms.put(element, 1); 
				
			}
		}
		return symptoms;
	}
	
	
	
	/*
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	
		//int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				//headCount++;
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount); //headCount);
			}
			else if (line.equals("rash")) { /* avant "rush"  MCK6  ERREUR DE MOTS DE RECHERCHE C EST rash et pas rush*/
		/*		rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		//FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");/* MCK6 headCount est la variable utiliser pour ce compteur */
		/*writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
	//}
	
	
}
