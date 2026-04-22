package Inheritance;

class Bicycle extends Vehicle {
    int pedals =4;
    boolean hasBasket;

public Bicycle(boolean hasBasket,int pedals){
    super("Orange",2);
    this.hasBasket = hasBasket;
    this.pedals = pedals;
}

@Override
    public void go(){
    System.out.println("the bicycle is pedaling ....");
}
    public void went(){
        System.out.println("the bicycle WAS pedaling ....");
    }






}