package Abstraction;

public class Main {
    public static void main(String[] args) {

        Circle circle =new Circle(2);
        Triangle triangle=new Triangle(1 , 1);


        circle.display();
        triangle.display();

        System.out.println(circle.area());
        System.out.println(triangle.area());
    }
}

//Abstraction: Exposing only what an object does while hiding how it does it.