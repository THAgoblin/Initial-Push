package Payment;

import java.util.Scanner;
import Managing.Order;
import Managing.ShoppingCart;

public class PayMenu {

    Scanner sc = new Scanner(System.in);
    Order order; //we take getTotal() from the the Order class / and also so that <paymentmethods> use it to pay the Order
    ShoppingCart cart; // we use cart so that we can use the method <clearcart(')> : cart.clearCart()
    MyPayment paymentMethod ;


    public PayMenu(Order order, ShoppingCart cart) {
        this.order = order; //we used the this.constructor type so cuz we want  the <sameOrdercontentdata> not create a new different one
        this.cart = cart; //we used the this.constructor type so cuz we want  the <sameShoppingcart(cart)> content ,not create a new different one
        }
    //?? why using it in the constructors , why not using  new object

    public void showMenu() {

        while (true) {

            if (cart.isCartEmpty()) {
                System.out.println("Cart is empty. Nothing to pay.(inside showMenu inside PayMenu)");
                return;
            }

            System.out.println("--- Payment Options ---");
            System.out.println("1. Pay using Cash");
            System.out.println("2. Pay using CreditCard");
            System.out.println("3. Pay using PayPal");

            System.out.println("\nChoose an option: \n");
            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("| -- You chose to pay Cash -- |");
                    System.out.println("The total amount to pay is : " + order.getTotal() + " $.");
                    if (getConfirm()) {
                        paymentMethod = new Cash(); //create a real object and store it in a variable paymentMethod

                    }
                    return;

                case 2:
                    System.out.println("You chose paying with CreditCard");
                    System.out.println("The total amount to pay is : " + order.getTotal() + " $.");
                    if (getConfirm()) {
                        paymentMethod = new CreditCard();

                    }
                    return;

                case 3:
                    System.out.println("You chose paying with PayPal");
                    System.out.println("The total amount to pay is : " + order.getTotal() + " $.");
                    if (getConfirm()) {
                        paymentMethod = new Paypal();

                    }
                    return;

                default:
                    System.out.println("Something went wrong , Try Again ...");
            }
            if (getConfirm()) {
                paymentMethod.pay(order.getTotal());// after confirming the payMenu choice  then choosing a payment method
                // and we pass the total in the Order class , we display it using the 3 Implementations of the interface
                cart.paidCart();//clear Cart
            }
        }
    }

private boolean getConfirm() {

    while (true) {

        System.out.println("Confirm? (y/n)");
        String confirm = sc.nextLine().toLowerCase();

        if (confirm.equals("y")) return true;
        if (confirm.equals("n")) return false;

        System.out.println("Only y or n pls");
    }
        }
    }

//⚡ Quick tip (very important)
//
//Whenever you think:
//
//        “Should I use new here?”
//
//Ask:
//
//        👉 “Do I need a NEW object, or the SAME one?”
//
//SAME → pass it (constructor)
//NEW → create it



// when to use abstract , static , void  virtual ....tec...


//✅ Summary of steps

//Organize folders and packages
//
//Folder → package declaration
//src/shop/Order.java → package shop;
//src/payment/PayMenu.java → package payment;


//Import the class you need
//
//import shop.Order; in PayMenu
//Create or pass an object
//Either create Order order = new Order(...);
//Or pass it as a parameter to the class/method

//Call the method
//
//order.getTotal(); or any other method

//Never try to use relative file paths like ../
//
//Java uses packages and imports, not folder paths.