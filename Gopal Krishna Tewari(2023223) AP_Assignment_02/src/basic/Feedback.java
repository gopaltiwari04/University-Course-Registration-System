package basic;

import java.time.LocalDate;

public class Feedback<T> {
    private String studentName;
    private T feedback;
    private LocalDate date;

    // Constructor
    public Feedback(String studentName, T feedback) {
        this.studentName = studentName;
        this.feedback = feedback;
        this.date = LocalDate.now();
    }

    public String getStudentName() {
        return studentName;
    }

    public T getFeedback() {
        return feedback;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Feedback from " + studentName + " on " + date + ": " + feedback.toString();
    }
}
