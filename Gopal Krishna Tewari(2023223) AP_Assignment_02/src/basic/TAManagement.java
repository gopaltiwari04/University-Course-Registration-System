package basic;

import java.util.List;
import java.util.Scanner;

public class TAManagement {

    // Method to handle TA login
    public static TA login(List<TA> taList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        // Loop through the list of TAs to check credentials
        for (TA ta : taList) {
            if (ta.getEmail().equals(email) && ta.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + ta.getName() + "!");
                return ta;  // Return the authenticated TA object
            }
        }

        System.out.println("Invalid email or password. Please try again.");
        return null;  // Return null if login fails
    }
}
