package Z5_Interface;

public class Rabbit implements Prey ,Predator{

    @Override
    public  void flee(){
        System.out.println("The Rabbit is fleeing");
    }

    @Override
    public void hunt(){
        System.out.println("The Hawk is hunting");

    }
}
