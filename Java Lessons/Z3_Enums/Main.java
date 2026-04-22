package Z3_Enums;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Read user input
        System.out.print("Enter a day: ");
        String scnr = scanner.nextLine();

        try {
            Day today = Day.valueOf(scnr.toUpperCase()); // Convert input to enum

            switch (today) {
                case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
                    System.out.println(today + " is from the Weekdays");
                    break;
                case SATURDAY, SUNDAY:
                    System.out.println(today + " is from the Weekends");
                    break;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid day! Please type a valid day (e.g., Monday).");
        }

        scanner.close(); // Close Scanner
    }
}
