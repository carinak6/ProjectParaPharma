package com.parapharma.analytics;

import java.io.FileWriter;
import java.util.TreeMap;
import java.util.Map.Entry;

public class WriteSymptomFromFile {	
	private String fileOut = "";	
	
	public WriteSymptomFromFile(String filepath) {
		fileOut = filepath;
	}
	
	public void writeSymptoms(TreeMap<String, Integer> listeSyntomes) throws Exception{	
		// generate output
		FileWriter writer = new FileWriter (fileOut);
				
		/*dans le code original*/
	//	writer.write("headache: " + headacheCount + "\n");/* headCount etait la variable utilisé pour ce compteur */
	//	writer.write("rash: " + rashCount + "\n");
	//	writer.write("dialated pupils: " + pupilCount + "\n");
	//  writer.close();
		
		writer.write("Compteurs des Symptomes : \n");
	
		for(Entry<String,Integer> element : listeSyntomes.entrySet()) {
			writer.write(element.getKey()+" : " + element.getValue() + "\n");			
		}
		
		writer.close();
		System.out.println("Enregistrement reussi");
	}

}
