package com.hemebiotech.analytics;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
 * Class that counts symptoms and writes the results to a file output in an alphabetical order.
 */
public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
     * Constructor for AnalyticsCounter.
     *
     * @param reader - An object implementing ISymptomReader to read symptom data.
     * @param writer - An object implementing ISymptomWriter to write symptom data.
     */
	AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}	

	/**
     * Get the list of symptoms thanks to the configured symptom reader.
     * @return A list of symptom strings from the data source.
     */
	public List<String> getSymptoms() {
		List<String> symptoms = reader.getSymptoms();
		return symptoms;
	}

	 /**
     * Counts the occurrences of each symptom in the given list.
	 * The map returned is in alphabetical order.
     * @param symptoms - A list of symptom strings to be counted.
     * @return symptomsCountMap - TreeMap<String, Integer> - A map where keys are symptom names, and values are their occurrence counts.
     */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsCountMap = new TreeMap<>();

		for (String symptom : symptoms) {
			symptomsCountMap.putIfAbsent(symptom, 0);
			symptomsCountMap.put(symptom, symptomsCountMap.get(symptom) +1);
		}
		return symptomsCountMap;
	}

	/**
     * Writes the counted symptoms to the configured output using the symptom writer.
     * @param symptoms - A map with symptom names as keys and their counts as values.
     */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
