package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import com.hemebiotech.analytics.ISymptomReader;
import com.hemebiotech.analytics.ISymptomWriter;


public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}	

	public List<String> getSymptoms() {
		List<String> symptoms = reader.getSymptoms();
		return symptoms;
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsCountMap = new TreeMap<>();

		for (String symptom : symptoms) {
			symptomsCountMap.putIfAbsent(symptom, 0);
			symptomsCountMap.put(symptom, symptomsCountMap.get(symptom) +1);
		}
		return symptomsCountMap

	
		/*
		try {
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				symptoms.putIfAbsent(line, 0);
				symptoms.put(line, symptoms.get(line) +1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(symptomsCountMap);
		return symptomsCountMap;
		 */
	}

	/* private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
		
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
	*/
}
