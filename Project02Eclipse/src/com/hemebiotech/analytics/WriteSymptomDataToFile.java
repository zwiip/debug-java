package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    public void writeSymptoms() {
        try {
            FileWriter writer = new FileWriter ("result.out");
            Map<String, Integer> occurrence = new TreeMap<>();
            for (Map.Entry<String, Integer> entry : occurrence.entrySet()) {
                writer.write(entry.getValue() + ": " + entry.getKey().toString());
            }
                
            writer.close();
        } catch {

        }
    }
}