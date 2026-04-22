package Managing;

import java.util.Scanner;
import java.sql.*;

    public class ShoppingCart {
        String productInput;
        double priceInput;
        int quantityInput;

        String url = "jdbc:mysql://localhost:3306/shopdb";
        String user = "root";
        String password = "Bagh_31122000";

        Scanner sc = new Scanner(System.in);


        // take em all and redisplay em : | SELECT COUNT(*) FROM products WHERE LOWER(name) = LOWER(?) |
        public void addProduct() throws SQLException {

            while (true) {
                System.out.println("Enter the product name: ");
                productInput = sc.nextLine().trim();
                System.out.println("Product's name : " + productInput);

                boolean exists = false;

                Connection con = DriverManager.getConnection(url, user, password); //db conn
                String checkQuery = "SELECT COUNT(*) FROM products WHERE LOWER(name) = LOWER(?)"; //Query
                PreparedStatement stmt = con.prepareStatement(checkQuery); //pre-stmt
                stmt.setString(1, productInput);//assigning input in the db

                ResultSet rs = stmt.executeQuery(); // execute query

                if (rs.next() && rs.getInt(1) > 0) {
                    //rs.next() → moves to the result row
                    //rs.getInt(1) → gets COUNT(first column) > 0 → means at least 1 row found

                    //COUNT(*): you still need to READ the value, not just see the row

                    System.out.println("Product already exists in database!");
                    exists = true;
                }

                if (exists) {
                    continue;
                }

                if (!productInput.matches("^[a-zA-ZÀ-ÿ' .-]{1,50}$")) {
                    System.out.println("Only letters allowed. No numbers.");
                    continue;
                }
                break;
            }

            while (true) {
                System.out.println("Enter the price of the product  : ");
                try {
                    priceInput = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Product's Price : " + priceInput + " $");
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input , Try Again");
                    sc.nextLine();
                }
            }

            while (true) {
                System.out.println("Enter the product quantity: ");
                try {
                    quantityInput = sc.nextInt();
                    sc.nextLine();//Scanner reads raw keyboard input which is slow and can cause input bugs.
                    System.out.println("Product's Quantity : " + quantityInput + " Unit(s)");
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input , Try Again");
                    sc.nextLine();
                }
            }

            try (
                    Connection con = DriverManager.getConnection(url, user, password);//Db conn
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)")) { //Query
                
                stmt.setString(1, productInput); //assigning input in the db
                stmt.setDouble(2, priceInput); //assigning input in the db
                stmt.setInt(3, quantityInput); //assigning input in the db

                stmt.executeUpdate(); // execute assignment

                System.out.println("\nThe product below has been added to the database :");
                System.out.println("Name : " + productInput + " | Price : " + priceInput + " $" + " | Quantity : " + quantityInput + " Unit(s)");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // remove row from DB by name using : | DELETE FROM products WHERE name = ? |
        public void removeProduct() {
            String name;

            System.out.println("Enter the Product's Name to remove: ");

            try {
                name = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.nextLine();
                return;
            }

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                try (
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmt = con.prepareStatement("DELETE FROM products WHERE name = ?") ) { //pre-stmt

                    stmt.setString(1, name); //assigning input in the db

                    int rowsAffected = stmt.executeUpdate(); // execute assignment
                        // stmt.executeUpdate(); finds how many matching rows affected by to the SQL Query above

                    if (rowsAffected > 0) {
                        System.out.println("The Product with the name  " + " ' " +  name + " ' " + " has been removed Successfully");
                    } else {
                        System.out.println("No products exists in the cart");
                    }
                }

            } catch (ClassNotFoundException e) {
                System.out.println("MySQL driver not found.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //take all : | SELECT * FROM products | from the db and then display em in a WHILE LOOP
        public void displayProduct() {
            try (
                    Connection con = DriverManager.getConnection(url, user, password); //Db conn
                    PreparedStatement stmt = con.prepareStatement("SELECT * FROM products"); //Query
                    ResultSet rs = stmt.executeQuery() // execute assignment
            ) {
                boolean found = false;

                while (rs.next()) {
                    found = true;
                    System.out.println("| ID: " + rs.getInt("id") );
                    System.out.println("| Name: " + rs.getString("name") );
                    System.out.println("| Price: " + rs.getDouble("price") + " $" );
                    System.out.println("| Quantity: " + rs.getInt("quantity")+" Unit(s)\n");
                }

                if (!found) {
                    System.out.println("Cart is empty.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //count from the db using | SELECT COUNT(*) AS total FROM products |
        public void totalProducts() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                try (
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) AS total FROM products");
                        // just the number of rows in the table.(SQL code )

                        ResultSet rs = stmt.executeQuery()
                ) {

                        int total = rs.getInt("total"); // just the number of rows in the table named "total".(Java code)

                        if (total > 1) {
                            System.out.println("There are " + total + " Products in the Cart");
                        } else if (total == 1) {
                            System.out.println("There is only " + total + " Product in the Cart");
                        } else {
                            System.out.println("There are no Products in the Cart");
                        }
                }

            } catch (ClassNotFoundException e) {
                System.out.println("MySQL driver not found.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // delete from the db using | TRUNCATE TABLE products |
        public void paidCart() { //real wipe but to mimic that the payment went smooth (clear it)
            try (
                    Connection con = DriverManager.getConnection(url, user, password); //Db conn
                    PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE products") ) { // Query

                stmt.executeUpdate(); // execute assignment
                System.out.println("<--Payment have been successfully -->");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // delete from the db using | TRUNCATE TABLE products |
        public void wipeCart() { //real wipe
            try (
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement ps = con.prepareStatement("TRUNCATE TABLE products")
            ) {
                ps.executeUpdate();
                System.out.println("<--The Cart now is wiped clean-->");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //if | SELECT COUNT(*) FROM products | == 0 (meaning the cart is empty)
        public boolean isCartEmpty() {
            try (
                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM products");
                    ResultSet rs = ps.executeQuery()
            ) {
                if (rs.next()) {
                    return rs.getInt(1) == 0;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;
        }
    }



// to use the page's methods in other pages you put the page inside a new Object
// constructors

// the sole use of a constructor is to prepare the new object with the correct initial values
// fields : variables that belong to the class
//     Product{
//        int id;
//        String name;
//        double price;
//        int quantity;
//}

// Constructor: we use field assignment
//public Product (int id ,String name, double price , int Quantity){
//    this.id = id;
//    this.name= name;
//    this.price = price;
//    this.quantity = Quantity;
//}

// creating a new object
//        Product p = new Product(id, name, price, quantity); //FIRST STEP
//

//create ArrayList

//  just the methods :

//  add product
//  remove product
//  list products (enhanced loop how?)
//  calculate total price

//    public int getIdInput() {}
//}



    // to use the page's methods in other pages you put the page inside a new Object
    // constructors

// the sole use of a constructor is to prepare the new object with the correct initial values
// fields : variables that belong to the class
//     Product{
//        int id;
//        String name;
//        double price;
//        int quantity;
//}

// Constructor: we use field assignment
//public Product (int id ,String name, double price , int Quantity){
//    this.id = id;
//    this.name= name;
//    this.price = price;
//    this.quantity = Quantity;
//}

// creating a new object
//        Product p = new Product(id, name, price, quantity); //FIRST STEP
//

//create ArrayList

//  just the methods :

//  add product
//  remove product
//  list products (enhanced loop how?)
//  calculate total price

//Newer features :
//add an update button
//follow a mvc model to organize the folders
// use Spring as it is the sandard industrial framework for java