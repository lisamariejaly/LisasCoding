package org.matsim.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CSVReader {
	public CSVReader() {}
	
	

	   public static final String delimiter = ";";
	   
	   public static List<String[]> relationList = new ArrayList<>(); // Anlegen einer Liste aus Arrays, Arrays des Datentyps String
	   
	   public static Map<String, Integer> read(String csvFile) {	   
		  
		  List<String[]> relationList = new ArrayList<>();
	      try {
	         File file = new File(csvFile);
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         String[] tempArr;
	         int column = 0;
	         while((line = br.readLine()) != null) {
//	        	 if(column>0) { // um die erste Zeile zu überspringen
	        		 tempArr = line.split(delimiter);	   // zeigt, ab welchem String ein Array erstellt wird bzw wann das nächste anfängt         
	 	            relationList.add(tempArr);
	        	 }
	        	 column++;            
	         
	         br.close();
	         } catch(IOException ioe) {
	            ioe.printStackTrace();
	         }
	      
	      Map<String, Integer> map = new HashMap<>(); // Anlegen der Map mit dem Namen 'map', Verknüpfung strings mit ints
//	       final Map<String, Integer> map2 = getMap() { // Methode getMap mit dem modifier final und dem datentyp map wird definiert als den return der variable map
//	           return (map);
//	      }
	       for(String[] entry: relationList) {    	   
	    	   String key = entry[0]+ "-" + entry[1]; // Definition der Keys
	    	   map.put(key, Integer.valueOf(entry[2])); // Hinzufügen der Values mithilfe der Methode put()
	       }
	       
	       for(Entry<String, Integer> set : map.entrySet()) {  // solange es mehr Strings als Entrys gibt, sollen neue Entrys hinzugefügt werden
	    	   System.out.println(set.getKey() + " , " +set.getValue());
	       }
	       return map;
	   }
	   
	}

