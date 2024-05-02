package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface representing a writer that can write symptom data.
 */
public interface ISymptomWriter {
    /**
     *  Writes the given map of symptoms and their corresponding occurrence counts to an output.
     * @param symptoms Map<String, Integer> - a map whith each symptoms as a key and theirs occurrences its value.
     */
    public void writeSymptoms(Map<String, Integer> symptoms);
}
