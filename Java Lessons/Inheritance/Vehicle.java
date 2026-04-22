package Inheritance;

//fields and attributes
public class Vehicle {
    String color;
    int Wheels;

    //Constructor
    public Vehicle (String color,int Wheels){        //So when I use a parameter , I can change it whenever I want ,
                                                    // by using the same parameter here to change the color whenever
        this.color = color;
        this.Wheels = Wheels;
    }
    //Methods
    public void go(){
        System.out.println("This Vehicle is Going ->");
    }

    public void stop(){
        System.out.println("This Vehicle has Stopped !!");
    }

    public void went(){
        System.out.println("the Vehicle WAS pedaling ....");
    }

}
