package Payment;

public class CreditCard implements MyPayment {

    public void pay(double amount) {
        System.out.println("Paid card: " + amount + " $ ");
        System.out.println("Item(s) purchased for the total amount of :" + amount + " $ using a CreditCard");
        System.out.println("Happy Shopping :)");

     }
}
