import java.time.*;
import java.time.format.DateTimeFormatter;

public class Account {
    private double accountBalance;
    private String dateCreated;
    private String customerName;
    private double withdrawalFee = 1.25;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

    public Account(String customerName) {
        this.dateCreated = LocalDate.now().format(formatter);
        this.accountBalance = 0;
        this.customerName = customerName;
    }
    public Account(double balance, String customerName) {
        this.dateCreated = LocalDate.now().format(formatter);
        this.accountBalance = balance;
        this.customerName = customerName;
    }

    public void withdraw(double withdrawalAmount) {
        if (this.accountBalance - (withdrawalFee + withdrawalAmount) >= 0) {
            this.accountBalance -= withdrawalAmount;
            System.out.printf("\nWithdrawal complete. $%,.2f left over.", this.accountBalance);
            return;
        } else {
            System.out.printf("\nWithdrawal failed. Deficit of $,.2f", -(accountBalance - (withdrawalAmount + withdrawalFee)));
        }
    }

    public void deposit(double depositAmount) {
        try {
            this.accountBalance += depositAmount;
            System.out.printf("\nDeposit successful!\nYou currently have $%,.2f", this.accountBalance);
        } catch(Exception error) {
            System.out.printf("\nError: %s", error.getMessage());
        }
    }

    public String getName() {
        return this.customerName;
    }

    public void displayAccount() {
        System.out.printf("\nAccount Owner: %s\nAccount Balance: $%,.2f\nDate Created: %s\nWithdrawal fee (Standard): %,.2f", this.customerName, this.accountBalance, this.dateCreated, this.withdrawalFee);
    }

    public void displayMenu() {
        System.out.print("\n\n::Options List::\n\n1. Deposit Funds\n2. Withdraw Funds\n3. Display Account Info\n4. Exit\n\n::Choose an option: ");
    }
}
