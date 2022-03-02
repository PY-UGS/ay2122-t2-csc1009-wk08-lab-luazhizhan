class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

public class CheckingAccount {
    private int number;
    private double balance;

    public CheckingAccount(int number, double balance) {
        this.setNumber(number);
        this.setBalance(balance);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int accountNumber) {
        this.number = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
        return String.format("The balance after deposit is: $%,.2f", this.getBalance());
    }

    public String withdraw(double amount) throws InsufficientFundsException {
        double newBalance = this.getBalance() - amount;
        if (newBalance < 0) {
            throw new InsufficientFundsException(Math.abs(newBalance));
        }
        this.setBalance(newBalance);
        return String.format("The balance after withdraw is: $%,.2f", this.getBalance());
    }
}
