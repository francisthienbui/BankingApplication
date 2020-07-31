/**
 * Created by Francis Bui on 7/30/2020
  */
import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args){
        BankAccount c1 = new BankAccount("Francis", "104582861");
        c1.showMenu();
    }
}

class BankAccount {
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerId;

    BankAccount(String name, String id){
        customerName = name;
        customerId = id;
    }

    void deposit(int amount){
        if(amount!= 0){
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction < 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Balance");
        System.out.println("E. Exit");

        do{
            System.out.println("=============================================");
            System.out.println("Enter an option");
            System.out.println("=============================================");
            option = scanner.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");

            switch(option){
                case 'A':
                    System.out.println("----------------------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("----------------------------------------------");
                    System.out.println('\n');
                    break;

                case 'B':
                    System.out.println("----------------------------------------------");
                    System.out.println("Enter amount to deposit");
                    System.out.println("----------------------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("----------------------------------------------");
                    System.out.println("Enter amount to withdraw");
                    System.out.println("----------------------------------------------");
                    int amountOut = scanner.nextInt();
                    withdraw(amountOut);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("----------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------------------");

                case 'E':
                    System.out.println("**********************************************");
                    break;

                default:
                    System.out.println("Invalid Input! Please try again");
                    break;
            }

        }while(option != 'E');
        System.out.println("Thank you for using our services");
    }
}
