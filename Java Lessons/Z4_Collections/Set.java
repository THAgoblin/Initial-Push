package Z4_Collections;
import java.util.HashSet;

public class Set {
    HashSet<String> set = new HashSet<>();
set.add("A");
set.add("B");
set.add("A"); // duplicate ignored
System.out.println(set); // [A, B]

}
