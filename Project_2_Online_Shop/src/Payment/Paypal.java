package Payment;

public class Paypal implements MyPayment {

    public void pay(double amount) {
        System.out.println("Paid PayPal: " + amount + " $ ");
        System.out.println("Item(s) purchased for the total amount of :" + amount + " $ using PayPal ");
        System.out.println("Happy Shopping :)");

     }
}
