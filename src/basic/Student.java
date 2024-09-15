
package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Student extends User {
    private String email;
    private String password;
    private int semester;
    private final List<Course> enrolledCourses;
    private final List<Course> completedCourses; // Courses completed in previous semesters
    private double sgpa;
    private static final int MAX_CREDITS_PER_SEMESTER = 20;

    // Constructor with name, email, password, and semester
    public Student(String name, String email, String password, int semester) {
        super(name, email, password);  // Call to the parent class User constructor
        this.email = email;
        this.password = password;
        this.semester = semester;
        this.enrolledCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
    }

    // Getters and setters for email, password, semester
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    // Method to calculate SGPA
    public double calculateSGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Course course : enrolledCourses) {
            totalGradePoints += course.getGrade() * course.getCredits();
            totalCredits += course.getCredits();
        }

        // Avoid division by zero if no courses are enrolled
        if (totalCredits == 0) {
            return 0.0;
        }

        return totalGradePoints / totalCredits;
    }

    // Method to check if a student has completed the prerequisites for a course
    private boolean prerequisitesMet(Course course) {
        // Check if the course has any prerequisites
        for (String prereqCode : course.getPrerequisites()) {  // Correct call to the getter
            boolean completed = false;
            for (Course completedCourse : completedCourses) {
                if (completedCourse.getCode().equals(prereqCode)) {
                    completed = true;
                    break;
                }
            }
            if (!completed) {
                System.out.println("Prerequisite " + prereqCode + " not met for course " + course.getName());
                return false;
            }
        }
        return true;
    }


    // Method to view available courses according to semester
    public void viewAvailableCourses(List<Course> allCourses) {
        System.out.println("Courses available for semester " + semester + ":");
        boolean foundCourse = false;
        for (Course course : allCourses) {
            if (course.getSemester() == this.semester) {
                System.out.println("- " + course.getName() + " (" + course.getCode() + ") - Credits: " + course.getCredits());
                foundCourse = true;
            }
        }
        if (!foundCourse) {
            System.out.println("No courses available for your semester.");
        }
    }

    // Method to register for a course
    public void registerCourse(Course course) {
        // Check if the course is for the student's current semester
        if (course.getSemester() != this.semester) {
            System.out.println("You can only register for courses in your current semester.");
            return;
        }

        // Check if prerequisites are met
        if (!prerequisitesMet(course)) {
            System.out.println("You cannot register for " + course.getName() + " because prerequisites are not met.");
            return;
        }

        // Calculate total enrolled credits
        int totalCredits = enrolledCourses.stream().mapToInt(Course::getCredits).sum();

        // Check if adding this course would exceed the credit limit
        if (totalCredits + course.getCredits() > MAX_CREDITS_PER_SEMESTER) {
            System.out.println("You cannot register for " + course.getName() + " as it exceeds the credit limit of " + MAX_CREDITS_PER_SEMESTER);
            return;
        }

        // Register the course if all conditions are met
        enrolledCourses.add(course);
        System.out.println("Successfully registered for " + course.getName() + " (" + course.getCode() + ")");
    }

    // Method to view options (overrides viewOptions from the User class)
    @Override
    public void viewOptions() {
        System.out.println("1. View Available Courses");
        System.out.println("2. Register for Courses");
        System.out.println("3. View Schedule");
        System.out.println("4. Track Progress");
        System.out.println("5. Drop Courses");
    }

    // This method can handle the user's choice when they pick an option from viewOptions
    public void chooseOption(int option, List<Course> allCourses, Scanner sc) {
        switch (option) {
            case 1:
                viewAvailableCourses(allCourses);
                break;
            case 2:
                System.out.println("Enter the course code you want to register for: ");
                String courseCode = sc.nextLine();
                Course courseToRegister = findCourseByCode(allCourses, courseCode);
                if (courseToRegister != null) {
                    registerCourse(courseToRegister);
                } else {
                    System.out.println("Course with code " + courseCode + " not found.");
                }
                break;
            case 3:
                viewSchedule();
                break;
            case 4:
                System.out.println("Your current SGPA is: " + calculateSGPA());
                break;
            case 5:
                System.out.println("You chose to drop a course.");
                dropCourse(sc);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Method to find a course by its code
    private Course findCourseByCode(List<Course> allCourses, String code) {
        for (Course course : allCourses) {
            if (course.getCode().equalsIgnoreCase(code)) {
                return course;
            }
        }
        return null;
    }

    // Method to view the current schedule
    public void viewSchedule() {
        System.out.println("Your current schedule:");
        for (Course course : enrolledCourses) {
            System.out.println(course.getName() + " (" + course.getCode() + ") - Credits: " + course.getCredits());
        }
    }

    // Method to drop a course
    public void dropCourse(Scanner sc) {
        System.out.println("Enter the course code of the course you want to drop: ");
        String courseCode = sc.nextLine();
        Course courseToDrop = findCourseByCode(enrolledCourses, courseCode);
        if (courseToDrop != null) {
            enrolledCourses.remove(courseToDrop);
            System.out.println("Successfully dropped " + courseToDrop.getName());
        } else {
            System.out.println("Course with code " + courseCode + " not found in your enrolled courses.");
        }
    }

    // Helper method to find a course in enrolled courses
    private Course locateCourseByCode(List<Course> courses, String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null; // Return null if the course is not found
    }

}


