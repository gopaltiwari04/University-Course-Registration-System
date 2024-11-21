package basic;

import java.util.List;
import java.util.Scanner;

public class TA extends Student {

    public TA(String name, String email, String password, int semester, double sgpa) {
        super(name, email, password, semester, sgpa);  // Reusing the constructor from the Student class
    }

    // Method for the TA to view grades of students in a specific course
    public void viewStudentGrades(Course course) {
        List<Student> enrolledStudents = course.getEnrolledStudents();
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students are enrolled in this course.");
        } else {
            System.out.println("Grades for " + course.getName() + ":");
            for (Student student : enrolledStudents) {
                System.out.println("- " + student.getName() + ": " + course.getGradeForStudent(student));
            }
        }
    }

    // Method for the TA to add grades for a specific student in a course
    public void addGrade(Course course, Student student, double grade) {
        if (course.getEnrolledStudents().contains(student)) {
            course.assignGrade(student, grade);
            System.out.println("Grade added successfully for " + student.getName() + " in " + course.getName());
        } else {
            System.out.println(student.getName() + " is not enrolled in this course.");
        }
    }

    @Override
    public void viewOptions() {
        System.out.println("1. View Student Grades");
        System.out.println("2. Add Grades");
        System.out.println("3. Logout");
    }

    public void chooseOption(int option, List<Course> allCourses, Scanner sc) {
        switch (option) {
            case 1:
                System.out.println("Enter the course code to view grades: ");
                String courseCodeToView = sc.nextLine();
                Course courseToView = findCourseByCode(allCourses, courseCodeToView);
                if (courseToView != null) {
                    viewStudentGrades(courseToView);
                } else {
                    System.out.println("Course with code " + courseCodeToView + " not found.");
                }
                break;
            case 2:
                System.out.println("Enter the course code to add a grade: ");
                String courseCodeToAdd = sc.nextLine();
                Course courseToAddGrade = findCourseByCode(allCourses, courseCodeToAdd);
                if (courseToAddGrade != null) {
                    System.out.println("Enter the student's email: ");
                    String studentEmail = sc.nextLine();
                    Student student = findStudentByEmail(studentEmail); // Assume a method exists for this
                    if (student != null) {
                        System.out.println("Enter the grade: ");
                        double grade = sc.nextDouble();
                        sc.nextLine();  // Consume newline
                        addGrade(courseToAddGrade, student, grade);
                    } else {
                        System.out.println("Student with email " + studentEmail + " not found.");
                    }
                } else {
                    System.out.println("Course with code " + courseCodeToAdd + " not found.");
                }
                break;
            case 3:
                System.out.println("Logging out...");
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }


    // Method to find a student by their email
    private Student findStudentByEmail(String email) {
        // Assume that there's a method to find students in the system using their email.
        // This could be implemented by searching through a student list.
        return null; // Placeholder
    }
}
