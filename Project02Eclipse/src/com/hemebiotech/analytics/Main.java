package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * This app reads symptoms'datas from a file, counts the occurrences of each symptom and write the results in alphabetical order to an output file.
 */
public class Main {
    /**
     * The app entry point.
     * @param args - Takes as a command-line argument a file path. If none is provided, a default path is used.
     * @exception FileNotFoundException - throw a fileNotFoundException if the file does not exist.
     * @exception Exception - handle unexpected error reading or writing the file.
     */
    public static void main(String[] args) {
        String filePath = (args.length == 0) ? "../symptoms.txt" : args[0];
        
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