package Managing;

//variables + constructor + getters + setters

public class Product {

    private static int idCounter = 0;
    private final int id ;
    private final String name;
    private double price;
    private int quantity;

    public Product (String name, double price, int quantity){
        this.id =idCounter++;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    /// getters /////////////////////////////////

    int getId() { return id; }

    String getName(){
        return name;
    }

    double getPrice(){
        return price;
    }

    int getQuantity() { return quantity;}


    /// setters /////////////////////////////////

    void setQuantity(int quantity){
        this.quantity=quantity;
    }

    void setPrice(double price){
        this.price = price;
    }

}


//Each Managing.Product object is independent; it doesn’t need an array to exist.
//
//The array only organizes references to objects.
//
//Getters read inside the object, not the array.
