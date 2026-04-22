package Payment;

public class Cash implements MyPayment {

    public void pay(double amount) {
        System.out.println("Paid cash: " + amount + " $ ");
        System.out.println("Item(s) purchased for the total amount of :" + amount + " $ using Cash");
        System.out.println("Happy Shopping :)");
    }
}

// default allows a method body in an interface.


//  🧠 When to use what
//
//  Use Interface when:
//
//      things are different but share a method
//
//      ✔ Cash / Card / Paypal
//
//  Use Abstract Class when:
//
//      things share some code
//
//      ✔ all payments print receipt