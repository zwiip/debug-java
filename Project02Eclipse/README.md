# Heme Biotech
Sample project for OpenClassroom's fundamentals of Java

This project reads symptom data from a source, counts the occurrences of each symptom, and outputs the results to a file.

## Components
- ISymptomReader: An interface for reading symptom data. Implementations return a list of symptom strings.
- ISymptomWriter: An interface for writing symptom data to a specified output.
- ReadSymptomDataFromFile: Reads symptoms from a file, one symptom per line.
- WriteSymptomDataToFile: Writes symptoms and their counts to a specified output.
- AnalyticsCounter: Uses a reader to get symptoms, counts them, and uses a writer to output the results.

## Running the Project
To run the project, ensure you have a Java environment set up. The main class (Main) takes a command-line argument to specify the file path for the symptom data. If no argument is provided, a default file path is used. The output is written to a specified file.

## Output Format
The output contains symptoms and their occurrence counts, with each line in the format "SymptomName: OccurrenceCount". The default output file is result.out.