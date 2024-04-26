package com.hemebiotech.analytics;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;

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
	}

	public void writeSymptoms(Map<Strin, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
