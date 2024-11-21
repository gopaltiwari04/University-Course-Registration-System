package basic;
import java.util.Scanner;
public class ProfessorManagement {
    public static Professor signUp() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        return new Professor(name, email, password);
    }
}
