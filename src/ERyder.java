
    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;

    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven, String account, String phone) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = account;
        this.LINKED_PHONE_NUMBER = phone;
    }

    public ERyder(String account, String phone) {
        this("DEFAULT001", 50, true, 0.0, account, phone);
    }

    public void printRideDetails(int usageInMinutes) {
        System.out.println("Account: " + this.LINKED_ACCOUNT);
        System.out.println("Phone: " + this.LINKED_PHONE_NUMBER);
        System.out.println("Bike ID: " + this.bikeID);
        System.out.println("Minutes: " + usageInMinutes);
        System.out.println("Fare: $" + calculateFare(usageInMinutes));
    }

    
    private double calculateFare(int usageInMinutes) {
        return BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
    }

    
    public static void main(String[] args) {
      
        ERyder bike1 = new ERyder("BIKE001", 80, true, 10.0, "Alice", "123456");
        bike1.printRideDetails(25);

        System.out.println("--------");

     
        ERyder bike2 = new ERyder("Bob", "654321");
        bike2.printRideDetails(10);
    }
}
