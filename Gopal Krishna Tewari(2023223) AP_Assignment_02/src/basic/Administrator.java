package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Main.Main.taList;

public class Administrator extends User {

    private List<Course> courses;
    private List<Student> students;
    private List<Complaint> complaints;

    public Administrator(String name, String email, String password, List<Course> allCourses, List<Student> studentList, List<Complaint> allComplaints) {
        super(name, email, password);
        this.courses=allCourses;
        this.students=studentList;
        this.complaints=allComplaints;
    }


    // 1. Manage Course Catalog
    private void manageCourseCatalog(Scanner scanner) {
        System.out.println("\n--- Manage Course Catalog ---");
        System.out.println("1. View Courses");
        System.out.println("2. Add Course");
        System.out.println("3. Delete Course");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (choice) {
            case 1:
                viewCourses();
                break;
            case 2:
                System.out.print("Enter course code: ");
                String courseCode = scanner.nextLine();
                System.out.print("Enter course title: ");
                String courseTitle = scanner.nextLine();
                System.out.print("Enter professor name: ");
                String professor = scanner.nextLine();
                System.out.print("Enter course credits: ");
                int credits = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                System.out.print("Enter course semester: ");
                int semester = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                Course newCourse = new Course(courseCode, courseTitle, professor, credits, null, semester, null, null, null);
                addCourse(newCourse);
                break;
            case 3:
                System.out.print("Enter course code to delete: ");
                String deleteCourseCode = scanner.nextLine();
                deleteCourse(deleteCourseCode);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    // 2. Manage Student Records
    private void manageStudentRecords(Scanner scanner) {
        System.out.println("\n--- Manage Student Records ---");
        System.out.println("1. View Student Records");
        System.out.println("2. Update Student Record");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (choice) {
            case 1:
                viewStudentRecords();
                break;
            case 2:
                System.out.print("Enter student email to update: ");
                String studentEmail = scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                System.out.print("Enter new semester: ");
                int newSemester = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                System.out.println("Enter new sgpa: ");
                double newSgpa = scanner.nextDouble();
                scanner.nextLine(); // Clear newline

                // Create a new student object with updated details
                Student updatedStudent = new Student(newName, studentEmail, newPassword, newSemester, newSgpa);
                updateStudentRecord(studentEmail, updatedStudent);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }


    // 3. Assign Professors to Courses
    private void assignProfessorsToCourses(Scanner scanner) {
        System.out.println("\n--- Assign Professors to Courses ---");
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter professor name: ");
        String professorName = scanner.nextLine();
        assignProfessorToCourse(courseCode, professorName);
    }

    // 4. Handle Complaints
    private void handleComplaints(Scanner scanner) {
        System.out.println("\n--- Handle Complaints ---");
        System.out.println("1. View Complaints");
        System.out.println("2. Update Complaint Status");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (choice) {
            case 1:
                viewComplaints();
                break;
            case 2:
                System.out.print("Enter complaint description: ");
                String complaintText = scanner.nextLine();
                System.out.print("Enter new status (Pending/Resolved): ");
                String status = scanner.nextLine();
                updateComplaintStatus(complaintText, status);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    // Sample methods for course, student, complaint management
    private void viewCourses() {
        // Implementation for viewing all courses
        //System.out.println(courses);
        if (courses==null || courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\n--- Course List ---");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getCourseTitle());
            System.out.println("Professor: " + course.getProfessor());
            System.out.println("Credits: " + course.getCredits());
            System.out.println("Semester: " + course.getSemester());
            System.out.println("---------------------------");
        }

    }

    private void addCourse(Course course) {
        // Implementation for adding a course
            if (courses == null) {
                courses = new ArrayList<>(); // Initialize if the course list is null
            }

            // Check if the course already exists
            for (Course c : courses) {
                if (c.getCourseCode().equals(course.getCourseCode())) {
                    System.out.println("Course with this code already exists.");
                    return;
                }
            }

            // Add course if it doesn't exist
            courses.add(course);
            System.out.println("Course added successfully.");


    }

    private void deleteCourse(String courseCode) {
        // Implementation for deleting a course by code
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses available to delete.");
            return;
        }

        Course courseToRemove = null;

        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                courseToRemove = course;
                break;
            }
        }

        if (courseToRemove != null) {
            courses.remove(courseToRemove);
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course with the given code not found.");
        }
    }
    public Course findCourseByCode(List<Course> allCourses, String code) {
        return allCourses.stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public void assignTAToCourse(List<Course> allCourses, List<TA> taList, Scanner sc) {
        System.out.println("Enter the course code to assign a TA:");
        String courseCode = sc.nextLine();

        Course selectedCourse = findCourseByCode(allCourses, courseCode);
            System.out.println("Select a TA to assign to the course:");
            for (int i = 0; i < taList.size(); i++) {
                System.out.println((i + 1) + ". " + taList.get(i).getName() + " | Email: " + taList.get(i).getEmail());
            }

            int taChoice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (taChoice > 0 && taChoice <= taList.size()) {
                TA selectedTA = taList.get(taChoice - 1);
                selectedCourse.setAssignedTA(selectedTA);
                System.out.println("TA " + selectedTA.getName() + " has been successfully assigned to the course.");
            } else {
                System.out.println("Invalid choice.");
            }
    }

    private void updateCourseCapacity(Scanner scanner) {
        System.out.print("Enter course code to update capacity: ");
        String courseCode = scanner.nextLine();

        Course course = findCourseByCode(courses, courseCode);
        if (course != null) {
            System.out.print("Enter new capacity: ");
            int newCapacity = scanner.nextInt();
            scanner.nextLine(); // Clear newline
            course.setCapacity(newCapacity);
            System.out.println("Course capacity updated to " + newCapacity);
        } else {
            System.out.println("Course not found.");
        }
    }



    private void viewStudentRecords() {
        // Implementation for viewing student records
        if (students == null || students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n--- Student Records ---");
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Semester: " + student.getSemester());
            System.out.println("---------------------------");
        }
    }

    private void updateStudentRecord(String email, Student updatedStudent) {
        // Implementation for updating student record by email
        if (students == null || students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                student.setName(updatedStudent.getName());
                student.setPassword(updatedStudent.getPassword());
                student.setSemester(updatedStudent.getSemester());
                System.out.println("Student record updated successfully.");
                return;
            }
        }

        System.out.println("Student with the given email not found.");
    }

    private void assignProfessorToCourse(String courseCode, String professorName) {
        // Implementation for assigning a professor to a course
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                course.setProfessor(professorName);
                System.out.println("Professor assigned to the course successfully.");
                return;
            }
        }

        System.out.println("Course with the given code not found.");
    }

    private void viewComplaints() {
        // Implementation for viewing all complaints
        if (complaints == null || complaints.isEmpty()) {
            System.out.println("No complaints available.");
            return;
        }

        System.out.println("\n--- Complaints ---");
        for (Complaint complaint : complaints) {
            System.out.println("Complaint: " + complaint.getDescription());
            System.out.println("Status: " + complaint.getStatus());
            System.out.println("---------------------------");
        }
    }

    private void updateComplaintStatus(String complaintText, String status) {
        // Implementation for updating complaint status
        if (complaints == null || complaints.isEmpty()) {
            System.out.println("No complaints available.");
            return;
        }
        for (Complaint complaint : complaints) {
            if (complaint.getDescription().equals(complaintText)) {
                complaint.setStatus(status);
                System.out.println("Complaint status updated successfully.");
                return;
            }
        }

        System.out.println("Complaint with the given description not found.");
    }

    public void chooseOption() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdministrator Options:");
            System.out.println("1. Manage Course Catalog");
            System.out.println("2. Manage Student Records");
            System.out.println("3. Assign Professors to Courses");
            System.out.println("4. Handle Complaints");
            System.out.println("5. Assign TA to Course");
            System.out.println("6. Update Course Capacity");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    manageCourseCatalog(scanner);
                    break;
                case 2:
                    manageStudentRecords(scanner);
                    break;
                case 3:
                    assignProfessorsToCourses(scanner);
                    break;
                case 4:
                    handleComplaints(scanner);
                    break;
                case 5:
                    assignTAToCourse(courses, taList, scanner);
                    case 6:
                        updateCourseCapacity(scanner);
                        break;
                case 7:
                    System.out.println("Exiting...");
                    return; // Exit the method
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
