package basic;

public class Administrator extends User {

    public Administrator(String name, String email, String password) {
        super(name, email, password);
    }

    // Manage course catalog, assign professors, handle complaints
    public void handleComplaints() {
        // Logic to resolve complaints
    }

    @Override
    public void viewOptions() {
        System.out.println("1. Manage Course Catalog");
        System.out.println("2. Manage Student Records");
        System.out.println("3. Assign Professors to Courses");
        System.out.println("4. Handle Complaints");
    }
}
