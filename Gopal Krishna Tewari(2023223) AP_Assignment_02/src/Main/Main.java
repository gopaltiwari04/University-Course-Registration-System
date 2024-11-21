package Main;

import basic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Student> studentList = new ArrayList<>();  // Store students for login
    private static List<Professor> professorList= new ArrayList<>();
    private static List<Administrator> administratorList = new ArrayList<>();
    public static List<TA> taList = new ArrayList<>();
    public static List<Course> allCourses = new ArrayList<>();
    public static List<Complaint> allComplaints = new ArrayList<>();
    public static void main(String[] args) {
        // Sample student data for login
        studentList.add(new Student("Alice", "alice@student.edu", "password1", 1,0));
        studentList.add(new Student("Bob", "bob@student.edu", "password2", 2,3.9));
        studentList.add(new Student("Stuart", "stuart@student.edu", "password3", 3,6.0));
        studentList.add(new Student("Thomas", "thomas@student.edu", "password4", 4,7.5));
        studentList.add(new Student("Jimmy", "jimmy@student.edu", "password5", 5,8.0));
        studentList.add(new Student("Tony", "tony@student.edu", "password6", 6,8.5));
        studentList.add(new Student("Mark", "mark@student.edu", "password7", 7,9.0));
        studentList.add(new Student("SiddhuMooseWala", "dil_da_ni_maada@student.edu", "password8", 8,9.9));


        allComplaints.add(new Complaint("class timing clashing in pns and hci"));
        allComplaints.add(new Complaint("Students are not assigned to any TA yet"));


        professorList.add(new Professor("Dr. Smith","smith@professor.edu","pass1"));
        professorList.add(new Professor("Dr. Brown","brown@professor.edu","pass2"));
        professorList.add(new Professor("Dr. White","white@professor.edu","pass3"));
        professorList.add(new Professor("Dr. Kendrick","kendrick@professor.edu","i love drake"));
        professorList.add(new Professor("Dr. Drake","drizzy@professor.edu","i love kendrick"));
        professorList.add(new Professor("Dr. Blue","blue@professor.edu","pass4"));


        administratorList.add(new Administrator("Pravesh Biyani","pravesh@university.edu","adminpass",allCourses,studentList,allComplaints));
        administratorList.add(new Administrator("Ashish","ashish@university.edu","adminpass",allCourses,studentList,allComplaints));


        TA ta1 = new TA("John Doe", "john.doe@example.com", "password123", 3, 8.0);
        TA ta2 = new TA("Jane Smith", "jane.smith@example.com", "password456", 3, 7.5);

        // Add TA objects to the list
        taList.add(ta1);
        taList.add(ta2);

        //public static List<Course> allCourses = new ArrayList<>();
        // Courses for Semester 1
        allCourses.add(new Course("CS101", "IP", "Dr. Smith", 4, new ArrayList<>(), 1,"9:00AM-10:00AM", "LHC 101", studentList));
        allCourses.add(new Course("CS102", "DC", "Dr. Brown", 4, new ArrayList<>(), 1,"10:00AM-11:30AM", "LHC 101",studentList));
        allCourses.add(new Course("CS103", "LA", "Dr. White", 4, new ArrayList<>(), 1,"12:00PM-1:00PM", "LHC 201",studentList));
        allCourses.add(new Course("CS104", "HCI", "Dr. Green", 4, new ArrayList<>(), 1,"2:00PM-3:00PM","RND B003",studentList));
        allCourses.add(new Course("CS105", "COM", "Dr. Blue", 2, new ArrayList<>(), 1,"4:00PM-5:00PM","Old Acad C01",studentList));

        // Courses for Semester 2
        allCourses.add(new Course("CS201", "DSA", "Dr. Black", 4, new ArrayList<>(Arrays.asList("IP")), 2,"9:00AM-10:00AM", "LHC 101",studentList));
        allCourses.add(new Course("CS202", "BE", "Dr. Gray", 4, new ArrayList<>(Arrays.asList("DC")), 2,"10:00AM-11:30AM", "LHC 101",studentList));
        allCourses.add(new Course("CS203", "CO", "Dr. Violet", 4, new ArrayList<>(), 2,"12:00PM-1:00PM", "LHC 201",studentList));
        allCourses.add(new Course("CS204", "PNS", "Dr. Yellow", 4, new ArrayList<>(), 2,"2:00PM-3:00PM","RND B003",studentList));
        allCourses.add(new Course("CS205", "CTRSS", "Dr. Orange", 4, new ArrayList<>(), 2,"4:00PM-5:00PM","Old Acad C01",studentList));

        // Courses for Semester 3
        allCourses.add(new Course("CS301", "RA", "Dr. Regulus", 4, new ArrayList<>(), 3,"9:00AM-10:00AM", "LHC 101", studentList));
        allCourses.add(new Course("CS302", "DS", "Dr. Maximus", 4, new ArrayList<>(Arrays.asList("LA")), 3,"10:00AM-11:30AM", "LHC 101", studentList));
        allCourses.add(new Course("CS303", "AP", "Dr. Capsicum", 4, new ArrayList<>(), 3,"12:00PM-1:00PM", "LHC 201", studentList));
        allCourses.add(new Course("CS304", "OS", "Dr. Tyrone", 4, new ArrayList<>(), 3,"2:00PM-3:00PM","RND B003", studentList));
        allCourses.add(new Course("CS305", "FOE", "Dr. Jones", 2, new ArrayList<>(), 3,"4:00PM-5:00PM","Old Acad C01", studentList));

        // Courses for Semester 4
        allCourses.add(new Course("CS401", "Database Management Systems", "Dr. Regulus", 4, new ArrayList<>(), 4,"9:00AM-10:00AM", "LHC 101", studentList));
        allCourses.add(new Course("CS402", "Computer Networks", "Dr. Maximus", 4, new ArrayList<>(Arrays.asList("CO")), 4,"10:00AM-11:30AM", "LHC 101", studentList));
        allCourses.add(new Course("CS403", "Software Engineering", "Dr. Dre", 4, new ArrayList<>(), 4,"12:00PM-1:00PM", "LHC 201", studentList));
        allCourses.add(new Course("CS404", "Discrete Mathematics", "Dr. Lamar", 4, new ArrayList<>(Arrays.asList("PNS")), 4,"2:00PM-3:00PM","RND B003", studentList));
        allCourses.add(new Course("CS405", "Digital Media", "Dr. Brown", 2, new ArrayList<>(), 4,"4:00PM-5:00PM","Old Acad C01", studentList));

        // Courses for Semester 5
        allCourses.add(new Course("CS501", "Theory of Computation", "Dr. Kendrick", 4, new ArrayList<>(), 5,"9:00AM-10:00AM", "LHC 101", studentList));
        allCourses.add(new Course("CS502", "Digital Logic Design", "Dr. Drake", 4, new ArrayList<>(), 5,"10:00AM-11:30AM", "LHC 101", studentList));
        allCourses.add(new Course("CS503", "Computer Architecture", "Dr. Cole", 4, new ArrayList<>(), 5,"12:00PM-1:00PM", "LHC 201", studentList));
        allCourses.add(new Course("CS504", "Object-Oriented Programming", "Dr. Kanye", 4, new ArrayList<>(), 5,"2:00PM-3:00PM","RND B003", studentList));
        allCourses.add(new Course("CS505", "Web Development", "Dr. Carti", 4, new ArrayList<>(), 5,"4:00PM-5:00PM","Old Acad C01", studentList));

        // Courses for Semester 6
        allCourses.add(new Course("CS601", "Statistical Machine Learning", "Dr. Wayne", 4, new ArrayList<>(Arrays.asList("DS")), 6,"9:00AM-10:00AM", "LHC 101", studentList));
        allCourses.add(new Course("CS602", "Ethical Hacking / Cybersecurity", "Dr. Lilbaby", 4, new ArrayList<>(), 6,"10:00AM-11:30AM", "LHC 101", studentList));
        allCourses.add(new Course("CS603", "Artificial Intelligence", "Dr. Tecca", 4, new ArrayList<>(), 6,"12:00PM-1:00PM", "LHC 201", studentList));
        allCourses.add(new Course("CS604", "Mobile Application Development", "Dr. Tay", 4, new ArrayList<>(), 6,"2:00PM-3:00PM","RND B003", studentList));
        allCourses.add(new Course("CS605", "Embedded Systems", "Dr. Keith", 4, new ArrayList<>(), 6,"4:00PM-5:00PM","Old Acad C01", studentList));

        // Courses for Semester 7
        allCourses.add(new Course("CS701", "Compilers", "Dr. Pac", 4, new ArrayList<>(), 7,"9:00AM-10:00AM", "LHC 101", studentList));
        allCourses.add(new Course("CS702", "Game Development", "Dr. Biggie", 4, new ArrayList<>(), 7,"10:00AM-11:30AM", "LHC 101", studentList));
        allCourses.add(new Course("CS703", "Big Data", "Dr. Smoke", 4, new ArrayList<>(), 7,"12:00PM-1:00PM", "LHC 201", studentList));
        allCourses.add(new Course("CS704", "Natural Language Processing", "Dr. Cube", 2, new ArrayList<>(), 7,"2:00PM-3:00PM","RND B003", studentList));
        allCourses.add(new Course("CS705", "Cryptography", "Dr. Rakim", 2, new ArrayList<>(), 7,"4:00PM-5:00PM","Old Acad C01", studentList));

        // Courses for Semester 8
        allCourses.add(new Course("CS801", "Parallel and Distributed Computing", "Dr. Regulus", 4, new ArrayList<>(), 8,"9:00AM-10:00AM", "LHC 101", studentList));
        allCourses.add(new Course("CS802", "Bioinformatics", "Dr. Maximus", 4, new ArrayList<>(), 8,"10:00AM-11:30AM", "LHC 101", studentList));
        allCourses.add(new Course("CS803", "Software Testing and Quality Assurance", "Dr. Slim", 4, new ArrayList<>(), 8,"12:00PM-1:00PM", "LHC 201", studentList));
        allCourses.add(new Course("CS804", "Computer Vision", "Dr. Shady", 4, new ArrayList<>(), 8,"2:00PM-3:00PM","RND B003", studentList));
        allCourses.add(new Course("CS805", "Robotics", "Dr. Dre", 2, new ArrayList<>(Arrays.asList("Compilers","IP")), 8,"4:00PM-5:00PM","Old Acad C01", studentList));

        Scanner sc = new Scanner(System.in);
        while (true) {
        System.out.println("Welcome to the University Course Registration System");
        System.out.println("1. Log in as Student");
        System.out.println("2. Sign up as Student");
        System.out.println("3. Log in as Professor");
        System.out.println("4. Sign up as Professor");
        System.out.println("5. Log in as Administrator");
        System.out.println("6. Log in as TA");
        System.out.println("7. Exit");

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
                user= ProfessorManagement.signUp();
                professorList.add((Professor) user);
                break;
            case 5:
                user = administratorLogin(sc);
                if (user instanceof Administrator) {  // Check if login was successful and user is an admin
                    ((Administrator) user).chooseOption();  // Allow admin to manage the system
                } else {
                    System.out.println("Login failed.");
                }
                break;
            case 7:
                System.out.println("Thank You for using the IIITD Course Registration System.");
                System.exit(0);

            case 6:
                // Login as TA
                user = TAManagement.login(taList);
                if (user instanceof TA) {
                    System.out.println("Welcome, TA " + user.getEmail() + "!");
                    boolean exit = false;
                    TA ta = (TA) user;
                    while (!exit) {
                        ta.viewOptions();  // Display TA's available options (view/add grades)
                        System.out.println("Choose an option: ");
                        int taChoice = sc.nextInt();
                        sc.nextLine(); // consume newline

                        // Handle TA's choice (view/add grades)
                        ta.chooseOption(taChoice, allCourses, sc);

                        System.out.println("Do you want to continue? (yes/no)");
                        String continueChoice = sc.nextLine();
                        if (continueChoice.equalsIgnoreCase("no")) {
                            exit = true;
                        }
                    }
                } else {
                    System.out.println("Login failed. Invalid email or password.");
                }
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
                        //return;
                    }
                }

            }
            else if (user instanceof Professor) {
                Professor professor = (Professor) user;
                boolean exit = false;
                while (!exit) {
                    professor.viewOptions();
                    System.out.println("Choose an option: ");
                    int professorChoice = sc.nextInt();
                    sc.nextLine(); // consume newline

                    // Pass the scanner and available courses to chooseOption method
                    professor.chooseOption(professorChoice, allCourses, sc);

                    System.out.println("Do you want to continue? (yes/no)");
                    String continueChoice = sc.nextLine();
                    if (continueChoice.equalsIgnoreCase("no")) {
                        exit = true;

                    }
                }
            }
            else {
                user.viewOptions();  // For professor and administrator
            }
        }
    }
    }


    private static Student studentLogin(Scanner sc){//throws InvalidLoginException {
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
        //throw new InvalidLoginException("Login failed. Invalid email or password.");
    }

    private static Professor professorLogin(Scanner sc) {
        // Simple static login for the professor
        System.out.println("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        for (Professor professor : professorList) {
            if (professor.getEmail().equals(email) && professor.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + professor.getEmail() + "!");
                return professor;
            }
        }
        System.out.println("Login failed. Invalid email or password.");
        return null;
    }

    private static Administrator administratorLogin(Scanner sc) {
        // Simple static login for the administrator
        System.out.println("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        for (Administrator administrator : administratorList) {
            if (administrator.getEmail().equals(email) && administrator.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + administrator.getEmail() + "!");
                return administrator;
            }
        }
        System.out.println("Login failed. Invalid email or password.");
        return null;
    }

}


