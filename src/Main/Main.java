package Main;

import basic.Administrator;
import basic.Professor;
import basic.Student;
import basic.User;
import basic.StudentManagement;
import basic.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Student> studentList = new ArrayList<>();  // Store students for login

    public static void main(String[] args) {
        // Sample student data for login
        studentList.add(new Student("Alice", "alice@student.edu", "password1", 1));
        studentList.add(new Student("Bob", "bob@student.edu", "password2", 2));
        studentList.add(new Student("Stuart", "stuart@student.edu", "password3", 3));
        studentList.add(new Student("Thomas", "thomas@student.edu", "password4", 4));
        studentList.add(new Student("Jimmy", "jimmy@student.edu", "password5", 5));
        studentList.add(new Student("Tony", "tony@student.edu", "password6", 6));
        studentList.add(new Student("Mark", "mark@student.edu", "password7", 7));
        studentList.add(new Student("SiddhuMooseWala", "dil_da_ni_maada@student.edu", "password8", 8));

        List<Course> allCourses = new ArrayList<>();
        // Courses for Semester 1
        allCourses.add(new Course("CS101", "IP", "Dr. Smith", 4, new ArrayList<>(), 1));
        allCourses.add(new Course("CS102", "DC", "Dr. Brown", 3, new ArrayList<>(), 1));
        allCourses.add(new Course("CS103", "LA", "Dr. White", 3, new ArrayList<>(), 1));
        allCourses.add(new Course("CS104", "HCI", "Dr. Green", 3, new ArrayList<>(), 1));
        allCourses.add(new Course("CS105", "COM", "Dr. Blue", 2, new ArrayList<>(), 1));

        // Courses for Semester 2
        allCourses.add(new Course("CS201", "DSA", "Dr. Black", 4, new ArrayList<>(), 2));
        allCourses.add(new Course("CS202", "BE", "Dr. Gray", 3, new ArrayList<>(), 2));
        allCourses.add(new Course("CS203", "CO", "Dr. Violet", 3, new ArrayList<>(), 2));
        allCourses.add(new Course("CS204", "PNS", "Dr. Yellow", 3, new ArrayList<>(), 2));
        allCourses.add(new Course("CS205", "CTRSS", "Dr. Orange", 2, new ArrayList<>(), 2));

        // Courses for Semester 3
        allCourses.add(new Course("CS301", "RA", "Dr. Regulus", 4, new ArrayList<>(), 3));
        allCourses.add(new Course("CS302", "DS", "Dr. Maximus", 4, new ArrayList<>(), 3));
        allCourses.add(new Course("CS303", "AP", "Dr. Capsicum", 3, new ArrayList<>(), 3));
        allCourses.add(new Course("CS304", "OS", "Dr. Tyrone", 3, new ArrayList<>(), 3));
        allCourses.add(new Course("CS305", "FOE", "Dr. Jones", 2, new ArrayList<>(), 3));

        // Courses for Semester 4
        allCourses.add(new Course("CS401", "Database Management Systems", "Dr. Regulus", 4, new ArrayList<>(), 4));
        allCourses.add(new Course("CS402", "Computer Networks", "Dr. Maximus", 4, new ArrayList<>(), 4));
        allCourses.add(new Course("CS403", "Software Engineering", "Dr. Dre", 3, new ArrayList<>(), 4));
        allCourses.add(new Course("CS404", "Discrete Mathematics", "Dr. Lamar", 3, new ArrayList<>(), 4));
        allCourses.add(new Course("CS405", "Digital Media", "Dr. Brown", 2, new ArrayList<>(), 4));

        // Courses for Semester 5
        allCourses.add(new Course("CS501", "Theory of Computation", "Dr. Kendrick", 4, new ArrayList<>(), 5));
        allCourses.add(new Course("CS502", "Digital Logic Design", "Dr. Drake", 4, new ArrayList<>(), 5));
        allCourses.add(new Course("CS503", "Computer Architecture", "Dr. Cole", 3, new ArrayList<>(), 5));
        allCourses.add(new Course("CS504", "Object-Oriented Programming", "Dr. Kanye", 3, new ArrayList<>(), 5));
        allCourses.add(new Course("CS505", "Web Development", "Dr. Carti", 2, new ArrayList<>(), 5));

        // Courses for Semester 6
        allCourses.add(new Course("CS601", "Statistical Machine Learning", "Dr. Wayne", 4, new ArrayList<>(), 6));
        allCourses.add(new Course("CS602", "Ethical Hacking / Cybersecurity", "Dr. Lilbaby", 4, new ArrayList<>(), 6));
        allCourses.add(new Course("CS603", "Artificial Intelligence", "Dr. Tecca", 3, new ArrayList<>(), 6));
        allCourses.add(new Course("CS604", "Mobile Application Development", "Dr. Tay", 3, new ArrayList<>(), 6));
        allCourses.add(new Course("CS605", "Embedded Systems", "Dr. Keith", 2, new ArrayList<>(), 6));

        // Courses for Semester 7
        allCourses.add(new Course("CS701", "Compilers", "Dr. Pac", 4, new ArrayList<>(), 7));
        allCourses.add(new Course("CS702", "Game Development", "Dr. Biggie", 4, new ArrayList<>(), 7));
        allCourses.add(new Course("CS703", "Big Data", "Dr. Smoke", 3, new ArrayList<>(), 7));
        allCourses.add(new Course("CS704", "Natural Language Processing", "Dr. Cube", 3, new ArrayList<>(), 7));
        allCourses.add(new Course("CS705", "Cryptography", "Dr. Rakim", 2, new ArrayList<>(), 7));

        // Courses for Semester 8
        allCourses.add(new Course("CS801", "Parallel and Distributed Computing", "Dr. Regulus", 4, new ArrayList<>(), 8));
        allCourses.add(new Course("CS802", "Bioinformatics", "Dr. Maximus", 4, new ArrayList<>(), 8));
        allCourses.add(new Course("CS803", "Software Testing and Quality Assurance", "Dr. Slim", 3, new ArrayList<>(), 8));
        allCourses.add(new Course("CS804", "Computer Vision", "Dr. Shady", 3, new ArrayList<>(), 8));
        allCourses.add(new Course("CS805", "Robotics", "Dr. Dre", 2, new ArrayList<>(), 8));

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the University Course Registration System");
        System.out.println("1. Log in as Student");
        System.out.println("2. Sign up as Student");
        System.out.println("3. Log in as Professor");
        System.out.println("4. Log in as Administrator");

        int choice = sc.nextInt();
        sc.nextLine();  // consume newline

        User user = null;
        switch (choice) {
            case 1:
                user = studentLogin(sc);
                break;
            case 2:
                user = StudentManagement.signUp();  // Assuming signUp returns the new Student
                studentList.add((Student) user);    // Add new student to the list
                break;
            case 3:
                user = professorLogin(sc);
                break;
            case 4:
                user = administratorLogin(sc);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        if (user != null) {
            if (user instanceof Student) {
                Student student = (Student) user;
                boolean exit = false;
                while (!exit) {
                    student.viewOptions();
                    System.out.println("Choose an option: ");
                    int studentChoice = sc.nextInt();
                    sc.nextLine(); // consume newline

                    // Pass the scanner and available courses to chooseOption method
                    student.chooseOption(studentChoice, allCourses, sc);

                    System.out.println("Do you want to continue? (yes/no)");
                    String continueChoice = sc.nextLine();
                    if (continueChoice.equalsIgnoreCase("no")) {
                        exit = true;
                    }
                }
            } else {
                user.viewOptions();  // For professor and administrator
            }
        }
    }

    private static Student studentLogin(Scanner sc) {
        System.out.println("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        // Search for the student in the studentList
        for (Student student : studentList) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + student.getEmail() + "!");
                return student;
            }
        }

        System.out.println("Login failed. Invalid email or password.");
        return null;
    }

    private static Professor professorLogin(Scanner sc) {
        // Simple static login for the professor
        System.out.println("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        if (email.equals("smith@prof.edu") && password.equals("password123")) {
            System.out.println("Login successful. Welcome, Professor Smith!");
            return new Professor("Dr. Smith", "smith@prof.edu", "password123");
        } else {
            System.out.println("Login failed. Invalid email or password.");
            return null;
        }
    }

    private static Administrator administratorLogin(Scanner sc) {
        // Simple static login for the administrator
        System.out.println("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        if (email.equals("admin@university.edu") && password.equals("adminpass")) {
            System.out.println("Login successful. Welcome, Administrator!");
            return new Administrator("Admin", "admin@university.edu", "adminpass");
        } else {
            System.out.println("Login failed. Invalid email or password.");
            return null;
        }
    }
}

