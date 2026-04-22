// got no relation with Payment folder
package Managing;

import Database.DbConnection;
import java.sql.*;

public class Order {

    public double total = 0;

    public Order() {
        total = getTotal();
    }

    //Count the total using (SUM P*Q) | SELECT SUM(price * quantity) AS total_amount FROM products |
    public double getTotal() {
        double totalAmount = 0;

        try (   Connection con = DbConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement("SELECT SUM(price * quantity) AS total_amount FROM products");
                ResultSet rs = stmt.executeQuery()
            ) {

            if (rs.next()) {
                totalAmount = rs.getDouble("total_amount");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalAmount;
    }

    public void displayOrder() {

        System.out.println("Cart Summary (RECEIPT):");

        try (
                Connection con = DbConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(
                        "SELECT * FROM products"
                );
                ResultSet rs = stmt.executeQuery()
        ) {
            boolean hasProducts = false;

            while (rs.next()) {
                hasProducts = true; // if products exist in the db show em , if not , cart is empty

                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");

                System.out.println(name + " : " + price + "$" + " x " + quantity + " = " + (price * quantity) + "$");
            }

            if (!hasProducts) {
                System.out.println("Cart is empty.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Total of all Products in the Cart is : " + getTotal() + "$.");
    }

    public void displayIntro() {
        System.out.println("\nThe Cart holds the amount of : " + getTotal() + "$ .");
    }

}

//1️⃣ The problem we are solving

//Managing.ShoppingCart: The user is adding/removing products. This is editable.
//Managing.Order: Once the user wants to “checkout,” we freeze the cart into an order.
//We copy all products from the cart.
//We calculate the total price.
//We display the summary.


//cart is a variable in Main that holds a Managing.ShoppingCart object.
//
//The Managing.ShoppingCart object itself contains the products array plus all the methods to manage it.

//          3. Managing.Order
//
//        * Created from a Managing.ShoppingCart.
//        * Stores ordered products + final total.
//        * Represents a confirmed purchase.