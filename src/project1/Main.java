package project1;

import java.util.*;
import java.util.Scanner;
import java.io.*;

/**
 * 
 * @author Nathan Johnson
 */

public class Main {
    
    // Variables to be used in generating an updated bookstore after a 'day' has finished.
    
    private static final String delimiter = ",";
    private static final String separator = "\n";
    private static final String header = "productID,type,title,author/artist,numInStock,price";
    private static final String book = "book";
    private static final String cd = "cd";
    private static final String dvd = "dvd";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        /**
         * Creating a new instance of Bookstore, a scanner variable, and a
         * choice variable to be used for most of the generic scanner uses.
         */
        
        Scanner scan = new Scanner(System.in);
        // A:\Users\5000d\Documents\NetBeansProjects\Project3\src\project1\ProductInventory.csv
        System.out.print("Please enter a file to use as a bookstore (FULL PATH NAME):   ");
        String fileName = scan.nextLine();
        Bookstore bs = new Bookstore(fileName);
        int choice = 0;
        double startValue = bs.inventoryValue();
        FileWriter file = null;
        
        /**
         * While loop that allows the program to run until the user specifically
         * exits the program.
         */
        
        while (true) {
            
            /**
             * UI print statements that create a title and also asks the user
             * what they would like to do.
             */
            
            System.out.println();
            System.out.println("==============================");
            System.out.println("Bookstore System");
            System.out.println("==============================");

            System.out.println();

            System.out.println("What would you like to do?");
            System.out.println("    1. Make a purchase\n"
                             + "    2. Register a New Membership\n"
                             + "    3. Add a Product\n"
                             + "    4. Value of Inventory\n"
                             + "    5. Restock Product\n"
                             + "    6. Exit\n");
            
            try {
                
                choice = scan.nextInt();
                
            } catch(InputMismatchException ex) {
                
                System.out.println("\nCaught InputMismatchException.\n");
                return;
                
            }

            /**
             * If-statement that runs based off the user choice.
             */
            
            if (choice == 1) {

                /**
                 * int count: Keeps track of how many items you have in your cart
                 * double totalCost: Keeps track of the total cost of your cart
                 * boolean continuing: Determines when you are done shopping.
                 */
                
                int count = 0;
                double totalCost = 0;
                boolean continuing = true;

                /**
                 * While loop that allows you to keep shopping while continuing
                 * is true.
                 */
                
                while (continuing) {
                    System.out.println();
                    System.out.println("What would you like to purchase?");
                    System.out.println();
                    
                    /**
                     * For-loop that prints out each product in the inventory,
                     * which index they are at ("i + 1" to start list at 1), and 
                     * formats the double to print two decimal places.
                     */
                    
                    for (int i = 0; i < bs.getInventory().size(); i++) {
                        
                        Product current = bs.getInventory().get(i);
                        
                        if (current instanceof Book) {
                        
                            System.out.println(String.valueOf(i + 1) + ". " + current.getName() + "\t" + "Author: " + current.getCreator() + "\t" + String.format("Price: $%.2f", current.getPrice()) + "\t" + "ID: " + current.getId() + "\t" + "Quantity: " + current.getQuantity());
                        
                        }
                        
                        else if (current instanceof CD) {
                        
                            System.out.println(String.valueOf(i + 1) + ". " + current.getName() + "\t" + "Artist: " + current.getCreator() + "\t" + String.format("Price: $%.2f", current.getPrice()) + "\t" + "ID: " + current.getId() + "\t" + "Quantity: " + current.getQuantity());
                        
                        }
                        
                        if (current instanceof DVD) {
                        
                            System.out.println(String.valueOf(i + 1) + ". " + current.getName() + "\t" + String.format("Price: $%.2f", current.getPrice()) + "\t" + "ID: " + current.getId() + "\t" + "Quantity: " + current.getQuantity());
                        
                        }

                    }

                    System.out.println();
                    scan.nextLine();
                    
                    /**
                     * Sets 'choice' variable to scan the next line of input.
                     * Increments count for total items in cart.
                     * Sets 'totalCost' to whatever the index (-1) of the product
                     * is and the assigned cost.
                     */
                    
                    try {
                
                        choice = scan.nextInt();
                
                    } catch(InputMismatchException ex) {
                
                        System.out.println("\nCaught InputMismatchException.\n");
                        return;
                
                    }
                    
                    if (bs.getInventory().get(choice-1).getQuantity() == 0) {
                        
                        System.out.println("You cannot buy this product.");
                        
                    }
                    
                    else {
                    
                        count++;
                        totalCost += bs.getInventory().get(choice-1).getPrice();

                        // Calls to function that adds purchased book to array list of sales.
                        bs.addSale(bs.getInventory().get(choice-1));
                        
                        // Calls to function that removes the item from the inventory.
                        bs.removeProduct(bs.getInventory().get(choice-1));
                    
                    }

                    System.out.println();
                    System.out.println("You have " + count + " item(s) in your cart. Are you done shopping?");
                    System.out.println("    1. Yes\n"
                                     + "    2. No");
                    System.out.println();
                    scan.nextLine();
                    
                    try {
                
                        choice = scan.nextInt();
                
                    } catch(InputMismatchException ex) {
                
                        System.out.println("\nCaught InputMismatchException.\n");
                        return;
                
                    }
                    
                    /**
                     * If & else-if statements that allow the user to keep shopping
                     * or end and print the total cost of their cart if they are
                     * done.
                     */
                    
                    if (choice == 2) {

                        continuing = true;

                    } 
                    
                    else if (choice == 1) {

                        System.out.println();
                        System.out.println("Your total is " + String.format("$%.2f", totalCost));
                        continuing = false;
                        System.out.println();

                    }

                }

                System.out.println("Who is making this purchase?");
                System.out.println();
                
                /**
                 * For-loop that prints out all of the existing members, while
                 * also allowing the user to create a new membership.
                 */

                for (int i = 0; i < bs.getMembers().size(); i++) {

                    System.out.println(String.valueOf(i + 1) + ". " + bs.getMembers().get(i).getName());

                }
                
                System.out.println(String.valueOf(bs.getMembers().size() + 1) + ". Register a new membership\n");
                
                try {
                
                    choice = scan.nextInt();
                
                } catch(InputMismatchException ex) {
                
                    System.out.println("\nCaught InputMismatchException.\n");
                    return;
                
                }
                
                /**
                 * If-else-statements that allow the user to select an already
                 * existing user, and a nested if-else statement that checks whether
                 * the selected member has paid their monthly fee or not.
                 * 
                 * The final else statement is for when the selected member is
                 * a free member rather than a premium member.
                 */

                if (choice < bs.getMembers().size() + 1) {

                    FreeMembership selected = bs.getMembers().get(choice - 1);
                    System.out.println();
                    System.out.println(selected.getName());

                    /**
                     * If-statement that checks if the variable 'selected' is an
                     * instance of PremiumMembership.
                     */
                    
                    if (selected instanceof PremiumMembership) {
                        
                        if (((PremiumMembership) selected).isFeePaid()) {

                            System.out.println();
                            System.out.println("Your monthly fee is paid.");
                            System.out.println();
                            System.out.println("Thank you for your purchase!");

                        } 

                        else {

                            System.out.println("Your monthly fee is not paid.");
                            System.out.println();
                            System.out.println(String.format("Your total is $%.2f", PremiumMembership.monthlyFee + totalCost));
                            System.out.println();
                            System.out.println("Thank you for your purchase!");
                            ((PremiumMembership) selected).setFeePaid(true);

                        }

                    }
                    
                    else {
                        
                        System.out.println();
                        System.out.println("Thank you for your purchase!\n");
                        
                    }

                }
                
                /**
                 * Else-statement that allows the user to create a new membership,
                 * either free or premium.
                 * Declares a 'membershipChoice' variable to store the user
                 * selection.
                 */

                else {
                    System.out.println();
                    scan.nextLine();
                    System.out.println("Which membership would you like?");
                    System.out.println();
                    System.out.println("1. Free Membership");
                    System.out.println("2. Premium Membership");
                    System.out.println();
                    int membershipChoice;
                    try {
                        membershipChoice = scan.nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("\nCaught InputMismatchException.\n");
                        return;
                    }
                    System.out.println();
                    System.out.print("First Name: ");
                    scan.nextLine();
                    String firstName = scan.nextLine();
                    System.out.println();
                    System.out.print("Last Name: ");
                    String lastName = scan.nextLine();
                    System.out.println();
                    FreeMembership member;
                    PremiumMembership pmember;

                    /**
                     * If and else-if-statement that creates the membership
                     * based on the user choice.
                     */
                    
                    if (membershipChoice == 1) {

                        member = new FreeMembership(firstName, lastName);
                        bs.addMember(member);
                        bs.addNewMember(member);
                        System.out.println("Thank you for your purchase!");

                    }

                    else if (membershipChoice == 2) {
                        
                        /**
                         * Creates 'pmember' variable if the user choice
                         * was premium, and allows a payment method to be set.
                         */

                        pmember = new PremiumMembership(firstName, lastName);
                        bs.addMember(pmember);
                        bs.addNewMember(pmember);

                        System.out.println("What payment method do you prefer?");
                        System.out.println();
                        System.out.println("1. Card");
                        System.out.println("2. Cash");
                        System.out.println();
                        try {
                        
                            choice = scan.nextInt();
                            
                        } catch (InputMismatchException ex) {
                            
                            System.out.println("\nCaught InputMismatchException.\n");
                            
                        }

                        /**
                         * If and else-if-statement that sets the payment method
                         * based on user choice.
                         */
                        
                        if (choice == 1) {

                            pmember.setPaymentMethod(1);
                            System.out.println();
                            System.out.println("Your payment method has been set.");
                            System.out.println();
                            System.out.println(String.format("Your monthly fee is $%.2f", PremiumMembership.monthlyFee));
                            System.out.println();
                            System.out.println(String.format("Your total is $%.2f", PremiumMembership.monthlyFee + totalCost));
                            System.out.println();
                            System.out.println("Thank you for your purchase!");
                            pmember.setFeePaid(true);

                        }

                        else if (choice == 2) {

                            pmember.setPaymentMethod(2);
                            System.out.println();
                            System.out.println("Your payment method has been set.");
                            System.out.println();
                            System.out.println(String.format("Your monthly fee is $%.2f", PremiumMembership.monthlyFee));
                            System.out.println();
                            System.out.println(String.format("Your total is $%.2f", PremiumMembership.monthlyFee + totalCost));
                            System.out.println();
                            System.out.println("Thank you for your purchase!");
                            pmember.setFeePaid(true);

                        }

                    }

                }

            }
            
            /**
             * This allows the user to directly make a new membership without having to go through an entire purchase.
             */
            
            else if (choice == 2) {

                System.out.println();
                scan.nextLine();
                System.out.println("Which membership would you like?");
                System.out.println();
                System.out.println("1. Free Membership");
                System.out.println("2. Premium Membership");
                System.out.println();
                int membershipChoice;
                try {
                    membershipChoice = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("\nCaught InputMismatchException.\n");
                    return;
                }
                System.out.println();
                System.out.print("First Name: ");
                scan.nextLine();
                String firstName = scan.nextLine();
                System.out.println();
                System.out.print("Last Name: ");
                String lastName = scan.nextLine();
                System.out.println();
                FreeMembership member;
                PremiumMembership pmember;
                
                if (membershipChoice == 1) {

                    member = new FreeMembership(firstName, lastName);
                    bs.addMember(member);
                    bs.addNewMember(member);
                    System.out.println("Your membership has been saved.\n");

                }

                else if (membershipChoice == 2) {
                        
                    /**
                     * Creates 'pmember' variable if the user choice
                     * was premium, and allows a payment method to be set.
                     */

                    pmember = new PremiumMembership(firstName, lastName);
                    bs.addMember(pmember);
                    bs.addNewMember(pmember);

                    System.out.println("What payment method do you prefer?");
                    System.out.println();
                    System.out.println("1. Card");
                    System.out.println("2. Cash");
                    System.out.println();
                    try {
                        choice = scan.nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("\nCaught InputMismatchException.\n");
                    }

                    /**
                     * If and else-if-statement that sets the payment method
                     * based on user choice.
                     */
                        
                    if (choice == 1) {

                        pmember.setPaymentMethod(1);
                        System.out.println();
                        System.out.println("Your membership has been saved and your payment method has been set.\n");
                        System.out.println(String.format("Your monthly fee is $%.2f\n", PremiumMembership.monthlyFee));
                        pmember.setFeePaid(true);

                    }

                    else if (choice == 2) {

                        pmember.setPaymentMethod(2);
                        System.out.println();
                        System.out.println("Your membership has been saved and your payment method has been set.\n");
                        System.out.println(String.format("Your monthly fee is $%.2f\n", PremiumMembership.monthlyFee));
                        pmember.setFeePaid(true);
                        
                    }
                
                }
                
            }
            
            /**
             * Calls to the addProduct function.
             */
            
            else if (choice == 3) {
                
                bs.addProduct();
                
            }
            
            /**
             * Calls to the inventoryValue function
             */
            
            else if (choice == 4) {
                
                System.out.println();
                System.out.println(String.format("The total value of our inventory: $%.2f", bs.inventoryValue()));
                
            }
            
            else if (choice == 5) {
                
                System.out.println();
                System.out.println("Products to restock:\n");
                
                for (int i = 0; i < bs.getInventory().size(); i++) {
                    
                    Product current = bs.getInventory().get(i);
                    System.out.println(String.valueOf(i + 1) + ". " + current.getName() + " ID: " + current.getId() + " Quantity: " + current.getQuantity());
                    
                }
                
                System.out.println("What is the product ID?\n");
                int idNum = 0;
                try {
                    idNum = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("\nCaught InputMismatchException.\n");
                }
                System.out.println();
                System.out.println("What is the quantity you want to restock?\n");
                int qNum = 0;
                try {
                    qNum = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("\nCaught InputMismatch Exception.\n");
                }
                bs.restockProduct(idNum, qNum);
                
            }
            
            /**
             * Exits the program if the user enters '6'.
             */

            else if (choice == 6) {
                
                // Below generates an EOD report, along with a copy of the EOD bookstore that can be used to pick up from where the code ended when ran again.
                
                try {
            
                    FileOutputStream fs = new FileOutputStream("EOD_Report.txt");
                    PrintWriter outFS = new PrintWriter(fs);

                    outFS.println("--- Total Items Purchased ---\n");

                    outFS.println(bs.getOutputString());

                    outFS.close();
                    fs.close();

                /*} catch (FileNotFoundException ex) {
                    
                    System.out.println("Caught FileNotFoundException.");
                    
                } catch (IOException ex) {

                    System.out.println("Caught IOException when closing output stream.");
                
                try {*/
                    
                    file = new FileWriter("UpdatedInventory.csv");
                    file.append(header);
                    file.append(separator);
                    Iterator p = bs.getInventory().iterator();
                    
                    while (p.hasNext()) {
                        
                        Product x = (Product)p.next();
                        file.append(String.valueOf(x.getId()));
                        file.append(delimiter);
                        if (x instanceof Book) {
                            file.append(book);
                            file.append(delimiter);
                        }
                        else if (x instanceof CD) {
                            file.append(cd);
                            file.append(delimiter);
                        }
                        else if (x instanceof DVD) {
                            file.append(dvd);
                            file.append(delimiter);
                        }
                        file.append(x.getName());
                        file.append(delimiter);
                        file.append(x.getCreator());
                        file.append(delimiter);
                        file.append(String.valueOf(x.getQuantity()));
                        file.append(delimiter);
                        file.append(String.valueOf(x.getPrice()));
                        file.append(separator);
                        
                    }
                    
                    file.close();
                    
                } catch (FileNotFoundException ex) {
                    
                    System.out.println("Caught FileNotFoundException.");
                    
                } catch (IOException ex) {

                    System.out.println("Caught IOException when closing output stream.");
                    
                }
        
                return;

            }
            
            /**
             * Restarts the loop if an incorrect number is entered.
             */
            
            else {
                
                System.out.println("Please enter a correct response.\n");
                
            }
            
        }
                
    }
    
}
