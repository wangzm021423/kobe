public class ERyder {
    // 
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    // 
    public ERyder() {
        this.bikeID = "DEFAULT001";
        this.batteryLevel = 50;
        this.isAvailable = true;
        this.kmDriven = 0.0;
    }

    // 
    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel); // 使用setter进行合法性检查
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }

    // ride() 
    public void ride() {
        if (isAvailable && batteryLevel > 0) {
            System.out.println("The bike is available for riding.");
        } else {
            System.out.println("The bike is not available.");
        }
    }

    // printBikeDetails() 
    public void printBikeDetails() {
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Total Distance Driven: " + kmDriven + " km");
        System.out.println("------------------------------");
    }

    // 
    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Error: Battery level must be between 0 and 100. Setting to default (50%).");
            this.batteryLevel = 50;
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }
}
