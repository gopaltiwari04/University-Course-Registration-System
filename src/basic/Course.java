
package basic;

import java.util.List;

public class Course {
    private String code;
    private String title;
    private double grade;
    private String professor;
    private int credits;
    private List<String> prerequisites;  // List of course codes as prerequisites
    private boolean available;
    private int semester;

    // Constructor to initialize the course
    public Course(String code, String title, String professor, int credits, List<String> prerequisites, int semester) {
        this.code = code;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.available = true;  // Default value: the course is available
        this.semester = semester;
        this.grade = -1; // Default grade (not assigned yet)
    }

    // Getter for grade
    public double getGrade() {
        return grade;
    }

    // Method to set the grade for the course
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Getter for availability
    public boolean isAvailable() {
        return available;
    }

    // Setter for availability
    public void setAvailable(boolean available) {
        this.available = available;
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

    // Getter for credits
    public int getCredits() {
        return credits;
    }

    // Getter for the semester
    public int getSemester() {
        return semester;
    }

    // Getter for the course name/title
    public String getName() {
        return title;
    }

    // Getter for course code
    public String getCode() {
        return code;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }


    // Optionally, you could add more setters or other methods if needed.
}



