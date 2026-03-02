// filepath: /Users/tylerkp27/s2-w7-1/WildlifePopulationVisualizer.java
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * WildlifePopulationVisualizer - Visualizes wildlife population simulation in real time
 */
public class WildlifePopulationVisualizer extends JFrame {
    private WildlifeSimulator simulator;
    private int yearsToSimulate;
    private int currentYear = 0;
    private JTextArea textArea;

    public WildlifePopulationVisualizer(WildlifeSimulator simulator, int yearsToSimulate) {
        this.simulator = simulator;
        this.yearsToSimulate = yearsToSimulate;
        setTitle("Wildlife Population Visualizer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setEditable(false);
        add(new JScrollPane(textArea));
        setVisible(true);
        startSimulation();
    }

    private void startSimulation() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (currentYear <= yearsToSimulate) {
                    updateDisplay();
                    simulator.simulateYear();
                    currentYear++;
                } else {
                    timer.cancel();
                }
            }
        }, 0, 1000); // Update every second
    }

    private void updateDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("Year: ").append(currentYear).append("\n");
        sb.append("========================================\n");
        for (Species s : simulator.species) {
            if (s != null) {
                sb.append(String.format("%-20s %,10d (Location: %s)\n", s.getName(), s.getPopulation(), s.getLocation()));
            }
        }
        textArea.setText(sb.toString());
    }

    // Example usage
    public static void main(String[] args) throws Exception {
        WildlifeSimulator simulator = new WildlifeSimulator(20);
        WildlifeSimulatorRunner.loadSpeciesFromCSV(simulator, "species-data.csv");
        new WildlifePopulationVisualizer(simulator, 10);
    }
}