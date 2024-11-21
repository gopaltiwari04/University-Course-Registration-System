package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String code;
    private String title;
    private double grade;
    private String professor;
    private int credits;
    private List<String> prerequisites;  // List of course codes as prerequisites
    private boolean available;
    private int semester;
    private String classTimings;
    private String location;
    private static List<Student> enrolledStudents; // Changed type to List<Student>
    private List<Feedback<?>> feedbackList;
    private Map<Student, Double> studentGrades = new HashMap<>();
    private TA assignedTA;
    private int capacity;  // New field for course capacity
    private int currentEnrollment = 0;  // New field for current enrollment

    // Constructor to initialize the course with all fields
    public Course(String code, String title, String professor, int credits, List<String> prerequisites, int semester, String classTimings, String location, List<Student> studentList) {
        this.code = code;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.available = true;  // Default value: the course is available
        this.semester = semester;
        this.grade = -1; // Default grade (not assigned yet)
        this.classTimings = classTimings;
        this.location = location;
        this.enrolledStudents = new ArrayList<>();
        this.feedbackList = new ArrayList<>();
        this.capacity = capacity;  // Set the capacity in constructor
        this.currentEnrollment = 0;
    }

    public <T> void addFeedback(Feedback<T> feedback) {
        feedbackList.add(feedback);
        System.out.println("Feedback added: " + feedback);
    }

    public void viewFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available for this course.");
        } else {
            System.out.println("Feedback for " + title + ":");
            for (Feedback<?> fb : feedbackList) {
                System.out.println(fb);
            }
        }
    }

    // Getters and setters
    public String getClassTimings() {
        return classTimings;
    }

    public void setClassTimings(String classTimings) {
        this.classTimings = classTimings;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    public void incrementEnrollment() {
        this.currentEnrollment++;
    }

    public boolean isFull() {
        return this.currentEnrollment >= this.capacity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public TA getAssignedTA() {
        return assignedTA;
    }

    public void setAssignedTA(TA assignedTA) {
        this.assignedTA = assignedTA;
    }

    // View TA information for admin
    public void viewTAInfo() {
        if (assignedTA != null) {
            System.out.println("TA assigned: " + assignedTA.getName() + " | Email: " + assignedTA.getEmail());
        } else {
            System.out.println("No TA assigned to this course.");
        }
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSemester() {
        return semester;
    }

    public String getName() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getProfessor() {
        return professor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public static void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    // Method to check if prerequisites are met
    public boolean prerequisitesMet(List<Course> completedCourses) {
        for (String prerequisite : prerequisites) {
            boolean found = false;
            for (Course completedCourse : completedCourses) {
                if (completedCourse.getCode().equals(prerequisite) && completedCourse.getGrade() >= 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;  // Prerequisite not met
            }
        }
        return true;  // All prerequisites met
    }

    public void assignGrade(Student student, double grade) {
        studentGrades.put(student, grade);
    }

    @Override
    public String toString() {
        return "Course Name: " + title + ", Code: " + code + ", Professor: " + professor;
    }

    public String getCourseCode() {
        return code;
    }

    public String getCourseTitle() {
        return title;
    }

    public boolean hasStudent(Student student) {
        return false;
    }

    public String getGradeForStudent(Student student) {
        return studentGrades.get(student) != null ? studentGrades.get(student).toString() : "Grade not assigned";
    }
}