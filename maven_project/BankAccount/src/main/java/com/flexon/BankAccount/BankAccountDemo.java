package com.flexon.BankAccount;

import java.util.Scanner;

public class BankAccountDemo {

    public static void main(String[] args) {
        //Set a scanner
        Scanner scanner = new Scanner(System.in);
        //Initiate a new bank account with balance = 0
        BankAccount account1 = new BankAccount();
        System.out.println("Welcome!");
        System.out.println("Are you a new user with us?");
        System.out.println("Please enter \"yes\", \"no\", or \"exit\" " );
        while(true) {
            String answer = scanner.next();
            if (answer.equals("yes")) {
                BankAccountDemo demo=new BankAccountDemo();
                demo.createAccount(0, account1);
                System.out.println("\nwhat else can I help you today?");
                select(account1, scanner);

                break;

            }else if (answer.equals("no")) {
                    //Get existed user info
                    //Assuming all existed use have $500 in balance
                    BankAccountDemo demo=new BankAccountDemo();
                    demo.createAccount(500, account1);

                    //Make any deposit or withdraw today?
                    System.out.println("What can I help you for today? ");
                    select(account1, scanner);
                    break;

            } else if (answer.equals("exit")) {
                BankAccountDemo demo = new BankAccountDemo();
                demo.exit(answer);
                break;

            } else {
                    System.out.println("Please only enter \"yes\" or \"no\" or \"show\" or \"exit\", ");
            }
        }

    }
    protected void createAccount(int balance, BankAccount account) {
        //Create a scanner
        Scanner scanner = new Scanner(System.in);
        //set bank account info

        //Set up customer name
        System.out.println("Please enter your name: ");
        account.setCustomerName(scanner.nextLine());
        //Set up customer accountNumber
        System.out.println("Please enter your 4-digits account number: ");
        account.setAccountNumber(scanner.nextLine());

        //Set up customer email
        System.out.println("Please enter your email: ");
        account.setEmail(scanner.nextLine());

        //Set up customer phone number
        System.out.println("Please enter your 9-digits phone number: ");
        account.setPhone(scanner.nextLine());

        //Initiate account balance
        account.setBalance(balance);

        //Print all account information
        account.printinfo();
    }

    protected static void select(BankAccount account, Scanner scanner){
        String answer = "answer";

        while (!answer.equals("exit")) {
            answer = scanner.nextLine();
            if (answer.equals("deposit")) {
                System.out.println("Enter the number you want to add: ");
                account.add(scanner.nextInt());
                //break;
            } else if (answer.equals("withdraw")) {
                System.out.println("Enter the number you want to withdraw: ");
                account.deduct(scanner.nextInt());
                //break;
            } else if (answer.equals("exit")) {
                BankAccountDemo demo=new BankAccountDemo();
                demo.exit(answer);
                //break;

            }else if(answer.equals("show")){
                account.printinfo();
                //break;
            } else {
                System.out.println("Please enter: \"deposit\", \"withdraw\",\"show\", \"exit\"");
            }
        }
    }
    protected void exit(String exit){
        System.out.println("Thank you for using our saving account!");
        System.out.println("You have "+ exit + "ed our system, see you next time!");
    }
}


class BankAccount {
    private String customerName;
    private String accountNumber;
    private String email;
    private String phone;
    private double balance = 0;
    private Scanner scanner;

    public void add(double deposit){
        if (deposit >= 0){
            this.balance += deposit;
            System.out.println("Make a deposit successfully!");
            System.out.println("You have made " + deposit + " to your account");
        }else{
            System.out.println("Invalid transaction");
        }
        System.out.println("Balance: " + this.balance);

    }
    public void deduct(double withdraw){
        if (this.balance - withdraw < 0){
            System.out.println("Not enough balance");
        }else{
            this.balance -= withdraw;
            System.out.println("You have withdraw successfully");
            System.out.println("You have withdraw "+ withdraw + " from your account");
        }
        System.out.println("Balance: " + this.balance);
    }
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void printinfo() {
        System.out.println("Thank you, " + this.customerName + ", for having a bank account with us!");
        System.out.println("Your account number is: " + this.accountNumber);
        System.out.println("Your email is " + this.email);
        System.out.println("Your phone number is " + this.phone);
        System.out.printf("Your account current balance is: %f with us! ", this.balance);
        System.out.println();
    }

    public double getBalance() {
        return this.balance;
    }
}