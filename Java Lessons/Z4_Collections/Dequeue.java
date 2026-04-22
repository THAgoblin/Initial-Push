package Z4_Collections;
import java.util.ArrayDeque;

public class Dequeue {


    ArrayDeque<String> deque = new ArrayDeque<>();
deque.addFirst("Front");
deque.addLast("Back");
System.out.println(deque); // [Front, Back]
deque.removeLast();
System.out.println(deque); // [Front]

}
