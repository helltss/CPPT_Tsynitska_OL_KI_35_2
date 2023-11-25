// Package declaration
package KI305.Tsynitska.Lab2;

// RowingBoatDriver class definition
public class RowingBoatDriver {

    // Main method
    public static void main(String[] args) {
        // Create three instances of RowingBoat with different parameters
        RowingBoat boat1 = new RowingBoat("Mona", 4, false);
        RowingBoat boat2 = new RowingBoat("Mona", 4, true);
        RowingBoat boat3 = new RowingBoat("Mona", 4, false);

        // Call main1 method
        main1();

        // Print the number of boats with sailAvailable = false
        System.out.println("Number of boats with sailAvailable = false: " + RowingBoat.getNumberOfBoatsWithFalseSailAvailable());

        // Test additional functionality
        testBoatActions(boat1);
        testBoatStatus(boat2);
    }

    // Additional method for testing
    public static void main1() {
        // Create four instances of RowingBoat with different parameters
        RowingBoat boat1 = new RowingBoat("Stella", 4, true);
        RowingBoat boat2 = new RowingBoat("Stella", 4, false);
        RowingBoat boat3 = new RowingBoat("Stella", 4, false);
        RowingBoat boat4 = new RowingBoat("Stella", 4, false);
    }

    // Additional method for testing boat actions
    public static void testBoatActions(RowingBoat boat) {
        System.out.println("Testing boat actions for " + boat.getBoatName());
        boat.startRowing();
        boat.raiseSail();
        boat.addRower();
        boat.lowerSail();
        boat.stopRowing();
        System.out.println("Number of rowers after testing actions: " + boat.getNumberOfRowers());
    }

    // Additional method for testing boat status
    public static void testBoatStatus(RowingBoat boat) {
        System.out.println("Testing boat status for " + boat.getBoatName());
        System.out.println("Current status: " + boat.getStatus());
    }
}