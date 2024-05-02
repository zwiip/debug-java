package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;

/**
 * Implementation of ISymptomWriter to write symptoms' datas to a file.
 * @see ISymptomWriter
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    
    private String file;
   
    /**
     * Constructor that sets the path for the output file.
     * @param file - The path to the output file where symptom data will be written.
     */
    public WriteSymptomDataToFile(String file) {
        this.file = file;
    }

    /**
     * Writes the symptoms and their occurrences to the output file.
     * @param occurrence - A map of symptoms and their corresponding occurrence counts.
     * @exception - Handle exceptions that occur during file writing.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> occurrence) {
        try {
            FileWriter writer = new FileWriter (file);
            
            for (Map.Entry<String, Integer> entry : occurrence.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
                
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing the file: " + e.getMessage());
        }
    }
}