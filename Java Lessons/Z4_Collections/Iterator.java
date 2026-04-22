package Z4_Collections;
import java.util.ArrayList;
import java.util.Iterator;

public class Iterator {


    ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");

    Iterator<String> it = list.iterator();
while(it.hasNext()) {
        System.out.println(it.next());
    }
// Output: A B
}
