package com.Banking;
import java.util.Date;
import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        Date today = new Date();
        CheckingAccount srnCheck = new CheckingAccount("Sujata Naik",
                1234567890,
                "Somewhere in the Twin Cities metro",
                today,
                123);
        SavingsAccount srnSave = new SavingsAccount("Sujata Naik",
                1234567890,
                "Somewhere in the Twin Cities metro",
                today,
                123);
        CreditCardAccount srnCredit = new CreditCardAccount("Sujata Naik",
                1234567890,
                "Somewhere in the Twin Cities metro",
                today,
                123);
        PrivilegesAccount srnPrivileges = new PrivilegesAccount("Sujata Naik",
                1234567890,
                "Somewhere in the Twin Cities metro",
                today,
                123);
        Scanner uIn = new Scanner(System.in);
        int uChoice, uCAChoice, uSAChoice, uCCChoice, uPChoice;

        boolean goodbye = false;
        boolean mainmenu;

        while (!goodbye) {
            System.out.println();
            System.out.println("Which account would you like to operate?");
            System.out.println();
            System.out.println("1. Checking");
            System.out.println("2. Savings");
            System.out.println("3. Credit Card");
            System.out.println("4. Privileges");
            System.out.println("5. Exit Menu");

            uChoice = uIn.nextInt();
            uIn.nextLine();

            switch(uChoice) {
                case 1:
                {
                    mainmenu = false;
                    while (!mainmenu) {
                        System.out.println();
                        System.out.println("Checking Account");
                        System.out.println();
                        System.out.println("1. Check Account Balance");
                        System.out.println("2. Deposit Money");
                        System.out.println("3. Withdraw Money");
                        System.out.println("4. Main Menu");
                        System.out.println();
                        uCAChoice = uIn.nextInt();
                        uIn.nextLine();
                        switch (uCAChoice) {
                            case 1: {
                                System.out.println("Checking account balance...");
                                double balanceAmount = srnCheck.getAccountBalance();
                                System.out.println("Your account balance is " + balanceAmount);
                                break;
                            }
                            case 2: {
                                System.out.println("Enter amount to deposit: ");
                                double depositAmount = uIn.nextDouble();
                                srnCheck.depositMoney(depositAmount);
                                break;
                            }
                            case 3: {
                                System.out.println("Enter amount to withdraw: ");
                                double withdrawAmount = uIn.nextDouble();
                                srnSave.withdrawMoney(withdrawAmount);
                                break;
                            }
                            case 4: {
                                System.out.println("Back to main menu...");
                                mainmenu = true;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2:
                {
                    mainmenu = false;
                    while (!mainmenu) {
                        System.out.println();
                        System.out.println("Savings Account");
                        System.out.println();
                        System.out.println("1. Check Account Balance");
                        System.out.println("2. Deposit Money");
                        System.out.println("3. Withdraw Money");
                        System.out.println("4. Main Menu");
                        System.out.println();
                        uSAChoice = uIn.nextInt();
                        uIn.nextLine();
                        switch (uSAChoice) {
                            case 1: {
                                System.out.println("Checking account balance...");
                                double balanceAmount = srnSave.getAccountBalance();
                                System.out.println("Your account balance is " + balanceAmount);
                                break;
                            }
                            case 2: {
                                System.out.println("Enter amount to deposit: ");
                                double depositAmount = uIn.nextDouble();
                                srnSave.depositMoney(depositAmount);
                                break;
                            }
                            case 3: {
                                System.out.println("Enter amount to withdraw: ");
                                double withdrawAmount = uIn.nextDouble();
                                srnSave.withdrawMoney(withdrawAmount);
                                break;
                            }
                            case 4: {
                                System.out.println("Back to main menu...");
                                mainmenu = true;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3:
                {
                    mainmenu = false;
                    while (!mainmenu) {
                        System.out.println();
                        System.out.println("Credit Card");
                        System.out.println();
                        System.out.println("1. View bill");
                        System.out.println("2. Pay bill");
                        System.out.println("3. Main Menu");
                        System.out.println();
                        uCCChoice = uIn.nextInt();
                        uIn.nextLine();
                        switch (uCCChoice) {
                            case 1: {
                                System.out.println("Viewing bill...");
                                break;
                            }
                            case 2: {
                                System.out.println("Paying bill...");
                                break;
                            }
                            case 3: {
                                System.out.println("Back to main menu...");
                                mainmenu = true;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 4:
                {
                    mainmenu = false;
                    while (!mainmenu) {
                        System.out.println();
                        System.out.println("Privileges");
                        System.out.println();
                        System.out.println("1. One");
                        System.out.println("2. Two");
                        System.out.println("3. Main Menu");
                        System.out.println();
                        uPChoice = uIn.nextInt();
                        uIn.nextLine();
                        switch (uPChoice) {
                            case 1: {
                                System.out.println("Action one...");
                                break;
                            }
                            case 2: {
                                System.out.println("Action two...");
                                break;
                            }
                            case 3: {
                                System.out.println("Back to main menu...");
                                mainmenu = true;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 5:
                    System.out.println("Goodbye!");
                    goodbye = true;
            }
        }
    }
}
