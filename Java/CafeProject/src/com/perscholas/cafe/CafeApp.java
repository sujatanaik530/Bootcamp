package com.perscholas.cafe;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CafeApp {
    public static void main(String[] args) {
        ArrayList<Coffee> numCoffees = new ArrayList<>(10);
        ArrayList<Espresso> numEspressos = new ArrayList<>(10);
        ArrayList<Cappuccino> numCappuccinos = new ArrayList<>(10);

        String yesMilk = "\tMilk";
        String yesSugar = "\tSugar";
        String yesPeppermint = "\tPeppermint ($2.00)";
        String yesWhippedCream = "\tWhipped Cream ($1.00)";
        String yesExtraShot = "\tExtra Shot ($2.00)";
        String yesMacchiato = "\tMacchiato ($1.00)";

        Scanner uIn = new Scanner(System.in);
        int uChoice;
        int uQtty;

        boolean goodbye = false;

        while (!goodbye) {
            System.out.println();
            System.out.println("Please select from the following:");
            System.out.println("1: Coffee");
            System.out.println("2: Espresso");
            System.out.println("3: Cappuccino");
            System.out.println("4: Checkout");

            uChoice = uIn.nextInt();
            uIn.nextLine();
            switch (uChoice) {
                case 1: {
                    System.out.println();
                    System.out.println("How many?");
                    uQtty = uIn.nextInt();
                    uIn.nextLine();
                    numCoffees = new ArrayList<>(uQtty);
                    for (int i = 0; i < uQtty; i++) {
                        boolean wantMilk = false;
                        boolean wantSugar = false;
                        System.out.println();
                        System.out.println("Coffee #" + (i + 1));
                        System.out.println("Milk? (y/n) ");
                        if (uIn.nextLine().toLowerCase(Locale.ROOT).equals("y")) {
                            wantMilk = true;
                        }
                        System.out.println("Sugar? (y/n) ");
                        if (uIn.nextLine().toLowerCase(Locale.ROOT).equals("y")) {
                            wantSugar = true;
                        }
                        Coffee cObj = new Coffee("Coffee", 3.00, "A basic coffee", wantSugar, wantMilk);
                        cObj.setQuantity(1);
                        numCoffees.add(cObj);
                    }
                    System.out.println();
                    for (int i = 0; i < uQtty; i++) {
                        System.out.format("%s (%s)  $%.2f%n",
                                numCoffees.get(i).getName(), numCoffees.get(i).getDescription(), numCoffees.get(i).calculateProductTotal());
                        if (numCoffees.get(i).isMilk()) {
                            System.out.format("\t%s%n", yesMilk);
                        }
                        if (numCoffees.get(i).isSugar()) {
                            System.out.format("\t%s%n", yesSugar);
                        }
                        System.out.println();
                    }
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.println("How many?");
                    uQtty = uIn.nextInt();
                    uIn.nextLine();
                    numEspressos = new ArrayList<>(uQtty);
                    for (int i = 0; i < uQtty; i++) {
                        boolean wantExtraShot = false;
                        boolean wantMacchiato = false;
                        System.out.println();
                        System.out.println("Espresso #" + (i + 1));
                        System.out.println("Extra shot? (y/n) ");
                        if (uIn.nextLine().toLowerCase(Locale.ROOT).equals("y")) {
                            wantExtraShot = true;
                        }
                        System.out.println("Macchiato? (y/n) ");
                        if (uIn.nextLine().toLowerCase(Locale.ROOT).equals("y")) {
                            wantMacchiato = true;
                        }
                        Espresso cObj = new Espresso("Espresso", 4.00, "A basic espresso", wantExtraShot, wantMacchiato);
                        cObj.setQuantity(1);
                        numEspressos.add(cObj);
                    }
                    System.out.println();
                    for (int i = 0; i < uQtty; i++) {
                        System.out.format("%s (%s)  $%.2f%n",
                                numEspressos.get(i).getName(), numEspressos.get(i).getDescription(), numEspressos.get(i).calculateProductTotal());
                        if (numEspressos.get(i).isExtraShot()) {
                            System.out.println(yesExtraShot);
                        }
                        if (numEspressos.get(i).isMacchiato()) {
                            System.out.println(yesMacchiato);
                        }
                        System.out.println();
                    }
                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.println("How many?");
                    uQtty = uIn.nextInt();
                    uIn.nextLine();
                    numCappuccinos = new ArrayList<>(uQtty);
                    for (int i = 0; i < uQtty; i++) {
                        boolean wantPeppermint = false;
                        boolean wantWhippedCream = false;
                        System.out.println();
                        System.out.println("Espresso #" + (i + 1));
                        System.out.println("Peppermint? (y/n) ");
                        if (uIn.nextLine().toLowerCase(Locale.ROOT).equals("y")) {
                            wantPeppermint = true;
                        }
                        System.out.println("Whipped Cream? (y/n) ");
                        if (uIn.nextLine().toLowerCase(Locale.ROOT).equals("y")) {
                            wantWhippedCream = true;
                        }
                        Cappuccino cObj = new Cappuccino("Cappuccino", 5.00, "A basic cappucino", wantWhippedCream, wantPeppermint);
                        cObj.setQuantity(1);
                        numCappuccinos.add(cObj);
                    }
                    System.out.println();
                    for (int i = 0; i < uQtty; i++) {
                        System.out.format("%s (%s)  $%.2f%n",
                                numCappuccinos.get(i).getName(), numCappuccinos.get(i).getDescription(), numCappuccinos.get(i).calculateProductTotal());
                        if (numCappuccinos.get(i).isPeppermint()) {
                            System.out.println(yesPeppermint);
                        }
                        if (numCappuccinos.get(i).isWhippedCream()) {
                            System.out.println(yesWhippedCream);
                        }
                        System.out.println();
                    }
                    break;
                }
                case 4: {
                    double coffeeSub = 0;
                    double espressoSub = 0;
                    double cappuccinoSub = 0;
                    double totalSub;

                    System.out.println();
                    System.out.println("Checking out..");

                    for (Coffee numCoffee : numCoffees) {
                        System.out.format("Item: %-18sPrice: %-9.2fQty: %-10dSubtotal: $%6.2f%n",
                                numCoffee.getName(), numCoffee.getPrice(), numCoffee.getQuantity(), numCoffee.calculateProductTotal());
                        if (numCoffee.isSugar()) {
                            System.out.println(yesSugar);
                        }
                        if (numCoffee.isMilk()) {
                            System.out.println(yesMilk);
                        }
                        coffeeSub += numCoffee.calculateProductTotal();
                    }

                    System.out.println();
                    for (Espresso numEspresso : numEspressos) {
                        espressoSub += numEspresso.calculateProductTotal();

                        System.out.format("Item: %-18sPrice: %-9.2fQty: %-10dSubtotal: $%6.2f%n",
                                numEspresso.getName(), numEspresso.getPrice(), numEspresso.getQuantity(), numEspresso.calculateProductTotal());
                        if (numEspresso.isExtraShot()) {
                            System.out.println(yesExtraShot);
                        }
                        if (numEspresso.isMacchiato()) {
                            System.out.println(yesMacchiato);
                        }
                    }

                    System.out.println();
                    for (Cappuccino numCappuccino : numCappuccinos) {
                        cappuccinoSub += numCappuccino.calculateProductTotal();

                        System.out.format("Item: %-18sPrice: %-9.2fQty: %-10dSubtotal: $%6.2f%n",
                                numCappuccino.getName(), numCappuccino.getPrice(), numCappuccino.getQuantity(), numCappuccino.calculateProductTotal());
                        if (numCappuccino.isPeppermint()) {
                            System.out.println(yesPeppermint);
                        }
                        if (numCappuccino.isWhippedCream()) {
                            System.out.println(yesWhippedCream);
                        }
                    }

                    totalSub = coffeeSub + espressoSub + cappuccinoSub;

                    System.out.println();
                    System.out.format("Subtotal : $%6.2f", totalSub);
                    double salesTax = 0.07 * totalSub;
                    System.out.println();
                    System.out.format("Sales tax: $%6.2f", salesTax);
                    System.out.println();
                    double grandTotal = totalSub + salesTax;
                    System.out.format("Total    : $%6.2f", grandTotal);
                    System.out.println();
                    goodbye = true;
                    break;
                }
            }
        }
    }
}
