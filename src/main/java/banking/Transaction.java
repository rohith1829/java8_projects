package banking;

public class Transaction {
    private int id;
    private String accountNumber;
    private double amount;
    private String type;

    public Transaction(int id, String accountNumber, double amount, String type) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
