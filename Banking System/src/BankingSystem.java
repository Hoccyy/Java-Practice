import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name :");
        String nameInput = input.nextLine();
        Account userAccount = new Account(0, nameInput);

        while (true) {
            userAccount.displayMenu();
            int userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Enter Deposit amount");
                    userAccount.deposit(input.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter Withdrawal amount");
                    userAccount.withdraw(input.nextDouble());
                    break;
                case 3:
                    userAccount.displayAccount();
                    break;
                case 4:
                    System.out.printf("Have a good day %s come again!", userAccount.getName());
                    input.close();
                    return;
                default:
                    break;
            }
        }
    }
}
