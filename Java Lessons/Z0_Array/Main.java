package Z0_Array;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter you name");
        String name = scanner.nextLine();


        System.out.println("Enter you age");
        int age = scanner.nextInt();

        System.out.println("Enter your gpa : ");
        int gpa = scanner.nextInt();
        scanner.nextLine();  //when the bug happens and Java skips a line .

        System.out.println("In or Out (Y/Yes/true or N/No/false): ");
        String sub = scanner.nextLine().toLowerCase();

        System.out.println("This your name is : " + name);
        System.out.println("This your age : " + age + " years old");
        System.out.println("This your gpa : " + gpa);
        System.out.println(sub);


        if (sub.equals("y") || sub.equals("yes") || sub.equals("true")) {
            System.out.println("You are in :)");
        } else if (sub.equals("n") || sub.equals("no") || sub.equals("false")) {
            System.out.println("You are out :(");
        } else {
            System.out.println("Invalid input!");
        }

    }
}

