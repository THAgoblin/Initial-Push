package Z4_Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Queue {


    Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");
System.out.println(queue.poll()); // A (removed)
System.out.println(queue); // [B]

}
