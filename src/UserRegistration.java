import java.util.Scanner;

public class UserRegistration {

    public static final double VIP_FEE = 100.0;
    private String name;
    private String email;
    private int age;
    private double total;

    public static void main(String[] args) {
        UserRegistration reg = new UserRegistration();
        reg.start();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Registration");
        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter email: ");
        email = sc.nextLine();

        System.out.print("Enter age: ");
        age = sc.nextInt();

        if (age < 13 || age > 120) {
            System.out.println("Cannot register.");
            return;
        }

        System.out.print("VIP? (1=yes, 2=no): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            if (age <= 18) {
                total = VIP_FEE * 0.8;
                System.out.println("20% discount applied!");
            } else {
                total = VIP_FEE;
            }
            System.out.println("VIP fee: " + total);
        } else {
            total = 0;
        }

        System.out.println("\nRegistration Successful!");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
        System.out.println("Total charged: " + total);

        sc.close();
    }
}
