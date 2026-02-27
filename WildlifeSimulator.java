/**
 * WildlifeSimulator - Manages population dynamics for multiple species
 * Uses an array of Species objects to store and simulate species data
 */
public class WildlifeSimulator {
    public Species[] species;
    public int speciesCount = 0;
    
    public WildlifeSimulator(int maxSpecies) {
        species = new Species[maxSpecies];
        simulateYear();
    }
    
    /**
     * Add a species to the simulator
     */
    public void addSpecies(Species s) {
        if(speciesCount == 0){
            species[0] = s;
            speciesCount++;
        } else {
        species[speciesCount-1] = s;
        speciesCount++;
        }
    }
    
    /**
     * Simulate one year of population changes for all species
     */
    public void simulateYear() {
        for(Species s: species){
            if(s!= null){
                s.simulateYear();
            }
        }
    }
    
    /**
     * Simulate multiple years
     */
    public void simulate(int years) {
        for(int i = 0; i< years;i++){
            simulateYear();
        }
    }
    
    /**
     * Get species at given index
     */
    public Species getSpecies(int index) {
        return species[index];
    }
    
    /**
     * Get species info as formatted string
     */
    public String getSpeciesInfo(int index) {
        return species[index].toString();
    }
    
    /**
     * Get total wildlife count across all species
     */
    public String toString(){
        String m = "";
        for(int i = 0; i< speciesCount-1;i++){
            if(species[i] != null){
            m +=species[i].toString() + "\n";
            } else{
                break;
            }
        }
        return m;

    }
    public double getTotalPopulation() {
        double x = 0;
        for(Species s: species){
            if(s!= null){
                x = x + s.getPopulation();
            }
           
        }
        return x;
    }
    
    /**
     * Find the species with largest population
     */
    public int getMostPopulousIndex() {
        int x = 0;
        for(int i = 0; i< speciesCount;i++){
            if(species[i]!= null){
                if((int)species[i].getPopulation()>x){
                    x = i;
                }
            }
        }
        return x;  
    }
    /**
     * Find the species with smallest population (most endangered)
     */
    public int getMostEndangeredIndex() {
        int x = 1000000;
        for(int i = 0; i< speciesCount;i++){
            if(species[i]!=null){
                if((int)species[i].getPopulation() < x){
                    x = i;
                }
            }
        }
        return x;
    }
    
    public int getSpeciesCount() {
        return speciesCount;
    }
    
    /**
     * Get array of all species
     */
    public Species[] getSpeciesArray() {
        return species;
    }
}
