package model;

public class BankAccount {

    private int id; //AI
    private String ownerName;
    private double amount; // balance later
    private String type; //checking / Savings
    private String status; // active / blocked
    private String currency; // $ , &

    //  Door1
    public BankAccount(int id, String ownerName, double amount, String type, String status, String currency) {
    }

    //Door2
    public BankAccount(String ownerName, double amount, String type, String status, String currency) {
        this.ownerName = ownerName;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.currency = currency;
    } //Door 2

    public BankAccount(String status, String type) {
        this.status=status;
        this.type=type;
    }
    public BankAccount(String status) {
        this.status=status;
    }


//    public model.bankAccount(int id, String ownerName, double amount, String type, String status, String currency) {
//        this.id = id;
//        this.ownerName = ownerName;
//        this.amount = amount;
//        this.type = type;
//        this.status = status;
//        this.currency = currency;
//    } //Door 3
//



    //Getters
    public int getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getAmount() {
        return amount;
    }


    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrency() {
        return currency;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}