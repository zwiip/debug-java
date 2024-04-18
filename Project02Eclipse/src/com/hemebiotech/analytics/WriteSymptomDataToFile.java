package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import.java.util.TreeMap;
import java.io.IOException;

public class WriteSymptomDataToFile implements ISymptomWriter {
    public void writeSymptoms(Map<String, Integer> occurrence) {
        try {
            FileWriter writer = new FileWriter ("result.out");
            TreeMap<String, Integer> sortedMap = new TreeMap<>(occurrence);
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
            }
                
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing the file: " + e.getMessage());
        }
    }
}