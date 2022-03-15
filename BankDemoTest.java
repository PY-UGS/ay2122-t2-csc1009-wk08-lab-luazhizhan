import java.util.Scanner;

public class BankDemoTest {

    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(1, 0);
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Deposit amount: $");
            double depositAmt = input.nextDouble();
            System.out.println(account.deposit(depositAmt));
            System.out.print("Withdraw amount: $");
            double withdrawAmt = input.nextDouble();
            System.out.println(account.withdraw(withdrawAmt));
        } catch (InsufficientFundsException e) {
            System.out.println(String.format("Sorry, but your account is short by: $%,.2f",
                    e.getAmount()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
