package Inheritance;


public class Main {
        public static void main(String[] args){

            Car car1 = new Car(true);
            Bicycle bike = new Bicycle(true,3);

            car1.go(); System.out.println("Overridden");

            bike.stop();System.out.println("Not Overridden - From Vehicle.java");

            bike.went();System.out.println("Overridden");

            System.out.println("Car is electric :"+ car1.isElectric);
            System.out.println("Bike has a Basket :"+ bike.hasBasket);
            System.out.println("Bike has a color :"+ bike.color );
            System.out.println( "Car has a color :"+ car1.color);
            System.out.println("Car has "+ bike.Wheels +" Wheels");
            System.out.println("Bike has "+car1.Wheels+" Wheels");
            System.out.println("Car has doors  :" +car1.doors);
            System.out.println("Bike has pedals  :"+ bike.pedals);

        }
}


//Inheritance: Creating a new class based on an existing one to reuse and extend behavior.