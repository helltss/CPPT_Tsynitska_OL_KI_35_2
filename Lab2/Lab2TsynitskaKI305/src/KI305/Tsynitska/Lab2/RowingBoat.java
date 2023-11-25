// Package declaration
package KI305.Tsynitska.Lab2;

// Import statements
import java.io.FileWriter;
import java.io.IOException;

// RowingBoat class definition
public class RowingBoat {
    // Instance variables
    private String boatName;
    private int numberOfRowers;
    private boolean isSailAvailable;
    private int numberOfOars;

    // Static variable to track the number of boats with false sail availability
    private static int numberOfBoatsWithFalseSailAvailable = 0;

    // Constructor
    public RowingBoat(String boatName, int numberOfRowers, boolean isSailAvailable) {
        this.boatName = boatName;
        this.numberOfRowers = numberOfRowers;
        this.isSailAvailable = isSailAvailable;
        this.numberOfOars = numberOfRowers * 2;

        // Increment the counter if sail is not available
        if (!isSailAvailable) {
            numberOfBoatsWithFalseSailAvailable++;
        }
    }

    // Getter for the counter
    public static int getNumberOfBoatsWithFalseSailAvailable() {
        return numberOfBoatsWithFalseSailAvailable;
    }

    // Getter methods
    public String getBoatName() {
        return boatName;
    }

    public int getNumberOfRowers() {
        return numberOfRowers;
    }

    public boolean isSailAvailable() {
        return isSailAvailable;
    }

    public int getNumberOfOars() {
        return numberOfOars;
    }

    // Setter methods
    public void setNumberOfRowers(int newNumberOfRowers) {
        this.numberOfRowers = newNumberOfRowers;
        this.numberOfOars = newNumberOfRowers * 2;
    }

    public void setSailAvailable(boolean isSailAvailable) {
        this.isSailAvailable = isSailAvailable;
        // Update the counter based on sail availability
        if (!isSailAvailable) {
            numberOfBoatsWithFalseSailAvailable++;
        } else {
            numberOfBoatsWithFalseSailAvailable--;
        }
    }

    public void setBoatName(String newBoatName) {
        this.boatName = newBoatName;
    }

    // Boat action methods
    public void startRowing() {
        log("Rowing the boat.");
    }

    public void stopRowing() {
        log("Stopped rowing.");
    }

    public void raiseSail() {
        if (isSailAvailable) {
            log("Raising the sail.");
        } else {
            log("No sail available.");
        }
    }

    public void lowerSail() {
        log("Lowering the sail.");
    }

    public void addRower() {
        numberOfRowers++;
        numberOfOars = numberOfRowers * 2;
        log("Added a rower. Total rowers: " + numberOfRowers);
    }

    public void removeRower() {
        if (numberOfRowers > 0) {
            numberOfRowers--;
            numberOfOars = numberOfRowers * 2;
            log("Removed a rower. Total rowers: " + numberOfRowers);
        } else {
            log("No rowers on the boat.");
        }
    }

    // Get the status of the boat as a formatted string
    public String getStatus() {
        String sailStatus = isSailAvailable ? "Sail is available" : "Sail is not available";
        return "Boat name: " + boatName + ", Number of rowers: " + numberOfRowers + ", " + sailStatus;
    }

    // Private method to log messages to a file
    private void log(String message) {
        try {
            FileWriter writer = new FileWriter("boat_log.txt", true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
