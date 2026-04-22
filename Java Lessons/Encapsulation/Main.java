package Encapsulation;

class CandyJar {                 //Encapsulation
    private int candies = 5;

    public void takeCandy(int amount){    // amount is the input inside the function in the main function
        if(candies >= amount){
            candies -= amount;
            System.out.println("Yum, " + amount + " candy/candies taken");
        } else {
            System.out.println("Not enough candies! Only " + candies + " left");
        }
    }

    public void addCandy(int amount){
        candies+=amount;
        System.out.println("I added" +amount+ "from the Jar " );
    }
}

public class Main {
    public static void main (String[] args){
        CandyJar jar =new CandyJar(); //we included the Candy jar class in the Encapsulation.Main class , then renamed it to: "jar"
        jar.takeCandy(5);
        jar.addCandy(22);
    }
    }

//Encapsulation: Bundling data and methods together and restricting direct access to protect an object’s state.