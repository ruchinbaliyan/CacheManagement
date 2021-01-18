package remaining.subtopics.exception;
import java.util.Scanner;

class NotValidAgeException extends Exception {
    NotValidAgeException(String msg) {
        super(msg);
    }
}

public class CustomCheckedExceptions {
    private String name;
    private int age;

    public void checkAge(String name, int age) throws NotValidAgeException {
        if (age <= 0 || age > 100) {
            String msg = "Invalid  age  (Should be between 1 and 120)";
            NotValidAgeException notValidAgeException = new NotValidAgeException(msg);
            throw notValidAgeException;
        }
        this.age = age;
        this.name = name;


    }

    public void display() {
        System.out.println(this.name + " " + this.age);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the person: ");
        String name = sc.next();
        System.out.println("Enter the age of the person: ");
        CustomCheckedExceptions obj = new CustomCheckedExceptions();
        int age = sc.nextInt();
        try {

            obj.checkAge(name, age);
        } catch (NotValidAgeException ex) {
            System.out.println(ex.toString());

        } finally {
            obj.display();
        }
    }
}

