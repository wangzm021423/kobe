import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("======================================");
        System.out.println("      ERyder User Management System    ");
        System.out.println("======================================");
        System.out.println("Starting the system... Please wait.");
        System.out.println();

        AdminPanel adminPanel = new AdminPanel();

        System.out.println("System started successfully!");
        System.out.println("Opening Admin Panel...\n");

        adminPanel.userManagementOptions();

        System.out.println("\nThank you for using ERyder System!");
        System.out.println("System closed.");
    }
}



