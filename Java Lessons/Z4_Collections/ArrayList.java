package Z4_Collections;

import java.util.ArrayList; // Import java.util.ArrayList

public class ArrayList { // Renamed your custom class to avoid conflict
    public static void main(String[] args) {

        // Array (fixed size)
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[0]); // 1

        ArrayList<String> list = new ArrayList<>(); // Now using java.util.ArrayList
        // ArrayList (dynamic)
        list.add("Apple");
        list.add("Banana");
        System.out.println(list.get(1)); // Banana
    }
}
