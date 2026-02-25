/**
 * WildlifeSimulator - Manages population dynamics for multiple species
 * Uses an array of Species objects to store and simulate species data
 */
public class WildlifeSimulator {
    public Species[] species;
    public int speciesCount = 0;
    
    public WildlifeSimulator(int maxSpecies) {
        species = new Species[maxSpecies];
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
        //TODO
    }
    
    /**
     * Simulate multiple years
     */
    public void simulate(int years) {
        //TODO
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
        for(int i = 0; i < speciesCount; i++){
            x = x + species[i].getPopulation();
        }
        return x;
    }
    
    /**
     * Find the species with largest population
     */
    public int getMostPopulousIndex() {
        int x = 0;
        for(int i = 0; i< speciesCount;i++){
            if(species[i].getPopulation()>x){
                x = i;
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
            if(species[i].getPopulation() < x){
                x = i;
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
