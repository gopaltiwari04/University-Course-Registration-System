package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Professor extends User {
    private List<Course> courses;

    public Professor(String name, String email, String password) {
        super(name, email, password);
        this.courses=new ArrayList<>();
    }

    public void manageCourses(List<Course> allCourses, Scanner sc) {
        System.out.println("Courses you are assigned to:");
        for (Course course : allCourses) {
            if (course.getProfessor().equals(this.getName())) {
                System.out.println(course);
            }
        }

        System.out.println("Do you want to update a course's details? (yes/no)");
        String response = sc.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter course code to update: ");
            String courseCode = sc.nextLine();

            Course selectedCourse = findCourseByCode(allCourses, courseCode);
            if (selectedCourse != null && selectedCourse.getProfessor().equals(this.getName())) {
                System.out.println("Updating details for course: " + selectedCourse.getName());

                boolean updating = true;
                while (updating) {
                    System.out.println("Choose an option to update:");
                    System.out.println("1) Change class timings");
                    System.out.println("2) Change credits");
                    System.out.println("3) Exit");

                    int option = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    switch (option) {
                        case 1:
                            System.out.println("Enter new class timings: ");
                            selectedCourse.setClassTimings(sc.nextLine());
                            System.out.println("Class timings updated successfully!");
                            break;
                        case 2:
                            System.out.println("Enter new credits: ");
                            selectedCourse.setCredits(sc.nextInt());
                            sc.nextLine(); // Consume newline
                            System.out.println("Credits updated successfully!");
                            break;
                        case 3:
                            updating = false;
                            System.out.println("Exiting update menu.");
                            return;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid course code or you are not assigned to this course.");
            }
        }
    }


    // View enrolled students
    public void viewEnrolledStudents(List<Course> allCourses) {
        boolean coursesFound = false; // To track if the professor has any assigned courses

        for (Course course : allCourses) {
            if (course.getProfessor().equals(this.getName())) {
                coursesFound = true;
                System.out.println("\nEnrolled students for course: " + course.getName() + " (" + course.getCode() + ")");

                List<Student> students = course.getEnrolledStudents();

                if (students == null || students.isEmpty()) {
                    System.out.println("No students enrolled in this course.");
                } else {
                    for (Student student : students) {
                        System.out.println("Name: " + student.getName() + " | Email: " + student.getEmail());
                    }
                }
                System.out.println("-------------------------"); // Separator for clarity
            }
        }

        if (!coursesFound) {
            System.out.println("You are not assigned to any courses or no students are enrolled.");
        }
    }


    public void chooseOption(int option, List<Course> allCourses, Scanner sc) {
        boolean exit = false;

        while (!exit) {
            viewOptions();
            //System.out.println("Enter your choice (1 or 2), or 0 to exit:");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageCourses(allCourses, sc);
                    break;
                case 2:
                    viewEnrolledStudents(allCourses);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    return;
                case 3:
                    viewCourseFeedback(sc);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void viewOptions() {
        System.out.println("1. Manage Courses");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. View Course Feedback");
        System.out.println("4. Exit");
    }

    // Helper method to find a course by its code
    private Course findCourseByCode(List<Course> allCourses, String code) {
        return allCourses.stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
    public void viewCourseFeedback(Scanner sc) {
        System.out.println("Enter the course code to view feedback: ");
        String courseCode = sc.nextLine();

        Course course = findCourseByCode(courses, courseCode);
        if (course != null) {
            course.viewFeedback();
        } else {
            System.out.println("Course not found.");
        }
    }
}