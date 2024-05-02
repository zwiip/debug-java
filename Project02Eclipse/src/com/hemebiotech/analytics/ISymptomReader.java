package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface representinf anything that will read symptom data from a source.
 */
public interface ISymptomReader {
	/**
	 * Reads symptom data from a source and returns a list of symptom strings.
	 * @return List<String> - a raw listing of string with all Symptoms obtained from a data source. An empty list if no datas are available.
	 */
	List<String> getSymptoms ();
}
