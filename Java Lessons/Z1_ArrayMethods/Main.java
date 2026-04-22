package Z1_ArrayMethods;
import java.util.ArrayList;
import java.util.Collections;


    public class Main {
        public static void main(String[] args) {

            // ArrayList = a resizable array that stores objects (uses autoboxing for primitives).
// Arrays are fixed in size, but ArrayLists can grow or shrink dynamically.
            // meaning you can use : add, remove , set ... to modify the array
            ArrayList<String> fruits = new ArrayList<>();

            fruits.add("Apple");
            fruits.add("Orange");
            fruits.add("Banana");
            fruits.add("Coconut");

            // fruits.remove(1);
            // fruits.set(1, "Pineapple");

            // System.out.println(fruits.get(3));
            // System.out.println(fruits.size());

            Collections.sort(fruits);

            for (String fruit : fruits) {
                //for every fruit in the array list of fruits , print fruit
                System.out.println(fruit);
            }
        }
    }

