package Inheritance;

class Car extends Vehicle{              //Car-specific attributes
    int doors = 4 ;
    boolean isElectric;

    public Car(boolean isElectric) {
        super("Red",4); // call Vehicle constructor with required arguments
        this.isElectric = isElectric;
    }

    @Override
    public void go(){
        System.out.println("The car is going");
    }
}

