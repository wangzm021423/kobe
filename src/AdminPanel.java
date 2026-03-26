import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {

    private List<RegisteredUsers> registeredUsersList;
    private Scanner sc; 


    public AdminPanel() {
        registeredUsersList = new ArrayList<>();
        sc = new Scanner(System.in);
    }


    public void userManagementOptions() {
        while (true) {

            System.out.println("\nWelcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice (1-5): ");
            
            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice. Please try again (enter number 1-5)");
                continue;
            }


            switch (choice) {
                case 1:
                    addNewUsers();
                    break;
                case 2:
                    viewRegisteredUsers();
                    break;
                case 3:
                    removeRegisteredUsers();
                    break;
                case 4:
                    updateRegisteredUsers();
                    break;
                case 5:
                    System.out.println("Exiting Admin Panel... Thank you!");
                    sc.close(); 
                    System.exit(0); 
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private void addNewUsers() {
        System.out.println("\n----- Add New Users -----");
        System.out.print("How many users do you want to add? ");
        int num;
        try {
            num = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid number!");
            return;
        }


        for (int i = 0; i < num; i++) {
            System.out.println("\nEnter details for User " + (i+1) + ":");
            System.out.print("Full Name: ");
            String fullName = sc.nextLine();
            System.out.print("Email Address: ");
            String email = sc.nextLine();
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dob = sc.nextLine();
            System.out.print("Card Number: ");
            String cardNum = sc.nextLine();
            System.out.print("Card Expiry Date (MM/YY): ");
            String cardExp = sc.nextLine();
            System.out.print("Card Provider (e.g., Visa): ");
            String cardPro = sc.nextLine();
            System.out.print("CVV: ");
            String cvv = sc.nextLine();
            System.out.print("User Type (e.g., Regular/VIP): ");
            String userType = sc.nextLine();

            
            String[] lastThreeTrips = new String[3];
            for (int j = 0; j < 3; j++) {
                System.out.println("\nEnter Trip " + (j+1) + " details:");
                System.out.print("Trip Date (YYYY-MM-DD): ");
                String tripDate = sc.nextLine();
                System.out.print("Source: ");
                String source = sc.nextLine();
                System.out.print("Destination: ");
                String dest = sc.nextLine();
                System.out.print("Fare (€): ");
                String fare = sc.nextLine();
                System.out.print("Feedback (press ENTER for NULL): ");
                String feedback = sc.nextLine();
                // 若反馈为空，设为NULL
                if (feedback.isEmpty()) feedback = "NULL";


                StringBuilder tripSb = new StringBuilder();
                tripSb.append("Date: ").append(tripDate)
                      .append(", Source: ").append(source)
                      .append(", Destination: ").append(dest)
                      .append(", Fare (€): ").append(fare)
                      .append(", Feedback: ").append(feedback);
                
                lastThreeTrips[j] = tripSb.toString();
            }

t
            RegisteredUsers user = new RegisteredUsers(fullName, email, dob, cardNum, cardExp, cardPro, cvv, userType, lastThreeTrips);
            registeredUsersList.add(user);
            System.out.println("User " + (i+1) + " added successfully!");
        }
    }

    private void viewRegisteredUsers() {
        System.out.println("\n----- View Registered Users -----");

        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }
        for (RegisteredUsers user : registeredUsersList) {
            System.out.println(user);
        }
    }

    private void removeRegisteredUsers() {
        System.out.println("\n----- Remove Registered Users -----");
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }

        System.out.print("Enter email of the user to remove: ");
        String delEmail = sc.nextLine();
        boolean found = false;


        Iterator<RegisteredUsers> it = registeredUsersList.iterator();
        while (it.hasNext()) {
            RegisteredUsers user = it.next();
            if (user.getEmailAddress().equals(delEmail)) {
                it.remove(); 
                found = true;
                System.out.println("User with email " + delEmail + " removed successfully!");
                break;
            }
        }


        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    private void updateRegisteredUsers() {
        System.out.println("\n----- Update Registered Users -----");
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to update"); // 修正题目笔误（remove→update）
            return;
        }

        System.out.print("Enter email of the user to update: ");
        String updEmail = sc.nextLine();
        RegisteredUsers targetUser = null;

        for (RegisteredUsers user : registeredUsersList) {
            if (user.getEmailAddress().equals(updEmail)) {
                targetUser = user;
                break;
            }
        }

        if (targetUser == null) {
            System.out.println("No user found with this email address");
            return;
        }

        System.out.println("\nEnter new details (press ENTER for no change | enter 0 for no change for numbers):");
        System.out.print("New Full Name: ");
        String newName = sc.nextLine();
        if (!newName.isEmpty()) targetUser.setFullName(newName);

        System.out.print("New Date of Birth (YYYY-MM-DD): ");
        String newDob = sc.nextLine();
        if (!newDob.isEmpty()) targetUser.setDateOfBirth(newDob);

        System.out.print("New Card Number (0 for no change): ");
        String newCardNum = sc.nextLine();
        if (!newCardNum.equals("0")) targetUser.setCardNumber(newCardNum);

        System.out.print("New Card Expiry Date (MM/YY, 0 for no change): ");
        String newCardExp = sc.nextLine();
        if (!newCardExp.equals("0")) targetUser.setCardExpiryDate(newCardExp);

        System.out.print("New Card Provider (0 for no change): ");
        String newCardPro = sc.nextLine();
        if (!newCardPro.equals("0")) targetUser.setCardProvider(newCardPro);

        System.out.print("New CVV (0 for no change): ");
        String newCvv = sc.nextLine();
        if (!newCvv.equals("0")) targetUser.setCvv(newCvv);

        System.out.print("New User Type (0 for no change): ");
        String newUserType = sc.nextLine();
        if (!newUserType.equals("0")) targetUser.setUserType(newUserType);

        System.out.println("User with email " + updEmail + " updated successfully!");
    }
}
