package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath;
        if (args.length == 0) {
            filePath = "../symptoms.txt";
        } else {
            filePath = args[0];
        }
        
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found. Please restart the application with a correct file path.");
            }

            ISymptomReader reader = new ReadSymptomDataFromFile(filePath);
            ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
            AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

            List<String> symptomsInput = counter.getSymptoms();
            Map<String, Integer> symptomsResult = counter.countSymptoms(symptomsInput);
            counter.writeSymptoms(symptomsResult);
            System.out.println("result.out has been correctly written.");

        } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}