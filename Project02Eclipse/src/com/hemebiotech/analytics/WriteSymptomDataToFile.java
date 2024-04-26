package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;

public class WriteSymptomDataToFile implements ISymptomWriter {
    
    private String file;
   
    public WriteSymptomDataToFile(String file) {
        this.file = file;
    }

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