package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptomsInput = counter.getSymptoms();
        Map<String, Integer> symptomsResult = counter.countSymptoms(symptomsInput);
        counter.writeSymptoms(symptomsResult);
    }
}
