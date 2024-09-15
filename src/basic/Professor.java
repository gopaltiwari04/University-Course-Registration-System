package basic;

import java.util.ArrayList;
import java.util.List;

public class Professor extends User {
    private List<Course> courses;

    public Professor(String name, String email, String password) {
        super(name, email, password);
        this.courses = new ArrayList<>();
    }

    // Manage courses, view enrolled students, etc.
    public void manageCourses() {
        // Logic for updating course details
    }

    @Override
    public void viewOptions() {
        System.out.println("1. Manage Courses");
        System.out.println("2. View Enrolled Students");
    }
}
