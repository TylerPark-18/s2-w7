import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 * WildlifeSimulatorApp - Main program for the Wildlife Population Simulator
 * 
 * This program:
 * 1. Reads real species data from a CSV file using split()
 * 2. Creates Species objects from the data
 * 3. Simulates population changes over time
 * 4. Writes results to an output CSV file
 */
public class WildlifeSimulatorRunner {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Create simulator with capacity for 20 species
        
        WildlifeSimulator simulator = new WildlifeSimulator(20);
        //Load species data from CSV
        
        loadSpeciesFromCSV(simulator, "species-data.csv");
        
        System.out.println("\n========================================");
        System.out.println("WILDLIFE POPULATION SIMULATOR");
        System.out.println("========================================\n");
        
        
        // Display initial populations
        System.out.println("INITIAL POPULATIONS:");
        System.out.println("------------------");
        for(Species s: simulator.species){
            if(s!= null){
            System.out.println(s.getPopulation());
            }
        }
        // Run simulation for 10 years and record data year-by-year
        int simulationYears = 10;
        
        
        // Display final populations
        
        
        // Display statistics
        System.out.println("\n\nSIMULATION STATISTICS:");
        System.out.println("------------------");
        //int mostPopulous = simulator.getMostPopulousIndex();
        //int mostEndangered = simulator.getMostEndangeredIndex();
        
        
                
        System.out.println("\nSimulation complete!");
    }
    
    /**
     * Load species data from CSV file into the simulator
     * CSV format: name,population,birthRate,deathRate,capacity,location
     */
    private static void loadSpeciesFromCSV(WildlifeSimulator simulator, String filename) throws IOException, FileNotFoundException {
        File f = new File(filename); 
        Scanner s = new Scanner(f);
        s.nextLine();
        while (s.hasNextLine()){
            String line = s.nextLine();
            System.out.println(line);
            String [] items = line.split(",");
            try {
                Species temp = new Species((items[0]), Long.parseLong(items[1]), Double.parseDouble(items[2]),
                Double.parseDouble(items[3]), Long.parseLong(items[4]), items[5]);

                simulator.addSpecies(temp);
            } catch (NumberFormatException e) {
                continue;
            }
        }
    }
    
    /**
     * Simulate year-by-year and record data to CSV file
     * Writes: simulation_year,species,population,population_change
     */
    private static void simulateAndRecordData(WildlifeSimulator simulator, int years, String filename) {
        //TODO
    
    }    
    
}