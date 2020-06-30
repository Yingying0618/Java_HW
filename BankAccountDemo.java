package com.flexon.bankAccount;

import java.util.Scanner;

public class BankAccountDemo {
    private static Scanner scanner;
    private static String answer;
    private static BankAccount account1;


    public static void main(String[] args) {
        //Set a scanner
        scanner = new Scanner(System.in);
        //Initiate a new bank account with balance = 0
        account1 = new BankAccount();
        System.out.println("Welcome!");
        System.out.println("Are you a new user with us?");
        System.out.println("Please enter \"yes\", \"no\", or \"exit\" " );
        while(true) {
            answer = scanner.next();
            if (answer.equals("yes")) {
                new BankAccountDemo(0);
                System.out.println("\nwhat else can I help you today?");
                System.out.println("You can enter: \"deposit\", \"withdraw\", \"exit\" ");
                while (true) {
                    answer = scanner.nextLine();
                    if (answer.equals("deposit")) {
                        System.out.println("Enter the number you want to add: ");
                        new BankAccountDemo(scanner.nextInt(), 0);
                        break;
                    } else if (answer.equals("withdraw")) {
                        System.out.println("Enter the number you want to withdraw: ");
                        new BankAccountDemo(0, scanner.nextInt());
                        break;
                    } else if (answer.equals("exit")) {
                        new BankAccountDemo(answer);
                        break;
                    } else {
                        System.out.println("Please enter: \"deposit\", \"withdraw\", \"exit\"");
                    }
                }
                break;

            }else if (answer.equals("no")) {
                    //Get existed user info
                    ///Assuming all exsited user have $500 balance 
                    new BankAccountDemo(500);

                    //Make any deposit or withdraw today?
                    System.out.println("What can I help you for today? ");
                    System.out.println("Please enter: \"deposit\", \"withdraw\", \"exit\"");
                    answer = scanner.next();
                    while(true){
                        if(answer.equals("deposit")){
                            System.out.println("Enter the number you want to add: ");
                            new BankAccountDemo(scanner.nextInt(), 0);
                            break;

                        }else if(answer.equals("withdraw")){
                            System.out.println("Enter the number you want to withdraw: ");
                            new BankAccountDemo(0, scanner.nextInt());
                            break;

                        }else if(answer.equals("exit")){
                            new BankAccountDemo(answer);
                            break;

                        }else{
                            System.out.println("Please enter: \"deposit\", \"withdraw\", \"exit\"");
                        }
                    }
                    break;

            } else if (answer.equals("exit")) {
                    new BankAccountDemo(answer);
                    break;

            } else {
                    System.out.println("Please only enter \"yes\" or \"no\" ");
            }
        }

    }
    //Open a new account
    public BankAccountDemo(int balance) {
         //Create a scanner
         scanner = new Scanner(System.in);
         //set bank account info
        //this.account1 = new BankAccount();
         //Set up customer name
         System.out.println("Please enter your name: ");
         account1.setCustomerName(scanner.nextLine());
         //Set up customer accountNumber
         System.out.println("Please enter your 4-digits account number: ");
         account1.setAccountNumber(scanner.nextLine());

         //Set up customer email
         System.out.println("Please enter your email: ");
         account1.setEmail(scanner.nextLine());

         //Set up customer phone number
         System.out.println("Please enter your 9-digits phone number: ");
         account1.setPhone(scanner.nextLine());

         //Initiate account balance
         account1.setBalance(balance);

         //Print all account information
         account1.printinfo();
    }
    //make deposit or withdraw
    public BankAccountDemo(int deposit, int withdraw){
        //Make a deposit or deduction
        account1.setDeposit(deposit);
        //account1.setDeposit(deposit);
        account1.setWithdraw(withdraw);
        int balance = account1.getBalance()+ deposit - withdraw;
        account1.setBalance(balance);
        System.out.println("Your account total now is: " + balance);
        //Display all information
        account1.printinfo();
    }

    //Exit
    public BankAccountDemo(String exit){
        System.out.println("Thank you for using our saving account!");
        System.out.println("You have "+ exit + "ed our system, see you next time!");
    }

}


class BankAccount {
    private String customerName;
    private String accountNumber;
    private String email;
    private String phone;
    private int balance = 0;
    private Scanner scanner;


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
        System.out.println("Your account name has been set successfully!");

    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        while (this.accountNumber.length() != 4) {
            System.out.println("Please enter a valid account number: ");
            scanner = new Scanner(System.in);
            this.accountNumber = scanner.nextLine();
            continue;
        }

        System.out.println("Your account number has been set successfully!");

    }

    public void setEmail(String email) {
        this.email = email;
        System.out.println("Your email has been set successfully!");

    }

    public void setPhone(String phone) {
        this.phone = phone;
        while (this.phone.length() != 9) {
            System.out.println("Please enter a valid phone number: ");
            scanner = new Scanner(System.in);
            this.phone = scanner.nextLine();
            continue;
        }
        System.out.println("Your phone number has been set successfully!");
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setDeposit(int deposit) {
        System.out.println("You have made " + deposit + " to your account");
    }

    public void setWithdraw(int withdraw) {
        System.out.println("You have withdraw "+ withdraw + " from your account");
    }

    public void printinfo() {
        System.out.println("Thank you, " + this.customerName + ", for creating a bank account with us!");
        System.out.println("Your account number is: " + this.accountNumber);
        System.out.println("Your email is " + this.email);
        System.out.println("Your phone number is " + this.phone);
        System.out.printf("Your account current balance is: %d with us", this.balance);
    }

    public int getBalance() {
        return this.balance;
    }
}
