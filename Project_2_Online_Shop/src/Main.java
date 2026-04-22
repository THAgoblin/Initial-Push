// this.field = parameter; means
//“store the constructor input into the object’s own state.”
// If you want to use the methods or data of another class, you usually create an object of that class.(When you want it empty)

// Create an Order object using the current ShoppingCart.
// The Order constructor receives the cart and creates a finalized order from it.

// Call the getTotal() method from the Order object.
// This method returns the total price of all products in the order.
// The returned value is stored in the variable 'total'.

// Create a MyPayment object.
// This object will handle the payment logic (cash, credit card, PayPal, etc.).

//        MyPayment payment = new MyPayment(cart);

// Call the pay() method from the MyPayment object.
// The method receives the total amount and processes the payment.

// the cart is temporary storage for the user’s products during the shopping session.
//
// You add, remove, view, or calculate totals while the session is active.
//
// Later, you can pass the cart to the Managing.Order class to freeze it for checkout.
import Managing.Order;
import Managing.ShoppingCart;
import Payment.PayMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        boolean running = true;

        while (running) {
            if (cart.isCartEmpty()) {
                System.out.println("\nThe Cart now holds the amount of : 0$ .");
            } else {
                Order order = new Order();
                order.displayIntro();
            }

            System.out.println("\n--- Welcome to the Menu ---\n");
            System.out.println("1- Add"); //Insert
            System.out.println("2- Remove"); //Delete
            System.out.println("3- Show"); //Select *
            System.out.println("4- Total Products in the Cart"); // Count
            System.out.println("5- Checkout"); //Select *
            System.out.println("6- Payment");
            System.out.println("7- Clear the Cart"); //Delete
            System.out.println("8- Exit");

            System.out.print("\nEnter your choice: \n");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.println("|+Add a new product to the cart+|\n");
                        cart.addProduct();
                        break;

                    case "2":
                        System.out.println("|-Remove a product from the cart-|\n");
                        cart.removeProduct();
                        break;

                    case "3":
                        System.out.println("|~Show the cart~|\n");
                        cart.displayProduct();
                        break;

                    case "4":
                        System.out.println("|=Total Products of the cart=|\n");
                        cart.totalProducts();
                        break;

                    case "5":
                        System.out.println("|>Checkout the cart<|\n");

                        if (!cart.isCartEmpty()) {
                            Order order = new Order();
                            order.displayOrder();
                        } else {
                            System.out.println("Cart is empty.");
                        }
                        break;

                    case "6":
                        System.out.println("|$Payment$|\n");

                        if (!cart.isCartEmpty()) {
                            Order order = new Order();
                            PayMenu pm = new PayMenu(order, cart);
                            pm.showMenu();
                        } else {
                            System.out.println("Cart is empty. Nothing to pay.");
                        }
                        break;

                    case "7":
                        System.out.println("|#Clear the Cart#|\n");
                        cart.wipeCart();
                        break;

                    case "8":
                        System.out.println("-- Exiting --\n");
                        sc.close();
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter the value again.");
            }
        }
    }
}
// when coding start with a side page,
// after making the setters and the getters of one page,
// go then and write the code in the main page,
// and vice versa


//**Simple Java Design Plan**
//
//        **1. Managing.Product**
//
//        * Store product data (name, price, id).
//        * Encapsulate fields (private + getters/setters). ??
//        * Represents one item.
//
//**2. Managing.ShoppingCart**
//
//        * Contains a collection of Products.
//* Add/remove products.
//        * Calculate total price.
//* Manages cart logic only.
//
//        **3. Managing.Order**
//
//        * Created from a Managing.ShoppingCart.
//        * Stores ordered products + final total.
//* Represents a confirmed purchase.
//
//        **4. Payment.Payment**
//
//        * Defines how payment is done.
//* Use an interface (pay method).
//        * Different implementations: Interfaces.CreditCard, Interfaces.Cash, PayPal → polymorphism.
//
//**5. Main**
//
//        * Entry point.
//        * Create products.
//        * Add products to cart.
//        * Create order from cart.
//        * Choose payment type.
//* Execute payment.
//
//        **Concepts covered**
//
//        * OOP (classes, objects)
//* Encapsulation
//* Composition (Managing.Order has Cart)
//* Collections (list of products)
//* Interfaces & polymorphism
//* Program flow coordination (main)




//src/
//  ├─ main/
//  │    └─ PayMenu.java
//  ├─ cart/
//  │    ├─ Managing.ShoppingCart.java
//  │    └─ Managing.Product.java
//  └─ payment/
//       ├─ Payment.Payment.java       <-- interface
//       ├─ Cash.java          <-- implements Payment.Payment
//       ├─ CreditCard.java    <-- implements Payment.Payment
//       └─ PayPal.java        <-- implements Payment.Payment