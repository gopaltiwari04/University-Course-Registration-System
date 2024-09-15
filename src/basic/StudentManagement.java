package basic;

import java.util.Scanner;

public class StudentManagement {
    public static Student signUp() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        System.out.println("Enter your semester: ");
        int semester = sc.nextInt();

        // Return the new student object
        return new Student(name, email, password, semester);
    }
}
