package project1;

import java.util.*;
import java.io.*;

public class Bookstore implements BookstoreSpecification {
    
    private static ArrayList<FreeMembership> memberships = new ArrayList();
    private static ArrayList<Product> inventory = new ArrayList();
    private static ArrayList<Product> totalSales = new ArrayList();
    private static ArrayList<FreeMembership> newMembers = new ArrayList();
    private static ArrayList<Product> newProducts = new ArrayList();

    public Bookstore(String file) throws FileNotFoundException, IOException {
        
        // Declaring preset books, CDs, and DVDs, while also adding
        // them to the inventory list.
        
        /*
        Book book1 = new Book(12.00, "Lord of The Rings", 92039928, 5, "J.R.R. Tolkien");
        CD cd1 = new CD(6.99, "Here And Now", 38291829, 20, "Nickelback");
        DVD dvd1 = new DVD(15.89, "Harry Potter and the Prisoner of Azkaban", 99458237, 6, "");

        inventory.add(book1);
        inventory.add(cd1);
        inventory.add(dvd1);
        */
        
        try {
            
            Scanner fileScanner = new Scanner(new File(file));
            
            while (fileScanner.hasNext()) {
                
                String line = fileScanner.nextLine();
                String[] fields = line.split(",");
                
                if (fields[1].equalsIgnoreCase("book")) {
                    
                    inventory.add(new Book(Double.parseDouble(fields[5]), fields[2], Integer.parseInt(fields[0]), Integer.parseInt(fields[4]), fields[3]));
                    
                }
                
                else if (fields[1].equalsIgnoreCase("cd")) {
                    
                    inventory.add(new CD(Double.parseDouble(fields[5]), fields[2], Integer.parseInt(fields[0]), Integer.parseInt(fields[4]), fields[3]));
                    
                }
                
                else if (fields[1].equalsIgnoreCase("dvd")) {
                    
                    inventory.add(new DVD(Double.parseDouble(fields[5]), fields[2], Integer.parseInt(fields[0]), Integer.parseInt(fields[4]), fields[3]));
                    
                }
                
            }
            
            fileScanner.close();
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("\nCaught FileNotFoundException.\n");
            
        }
        
        // Declaring preset memberships, both free and premium, while also
        // adding them to the memberships list.
        
        FreeMembership membership1 = new FreeMembership("John","Smith");
        FreeMembership membership2 = new PremiumMembership("Adam","Johnson");
        FreeMembership membership3 = new FreeMembership("Gary","Harris");
        
        memberships.add(membership1);
        memberships.add(membership2);
        memberships.add(membership3);
        
    }
    
    /**
     * 
     * @return Returns the total price of all sales made that day.
     */
    
    public ArrayList<Product> getTotalSales() {
        
        return totalSales;
        
    }
    
    /**
     * 
     * @param p Product to add to array list of sales.
     */
    
    public void addSale(Product p) {
        
        this.totalSales.add(p);
        
    }
    
    public void addNewProduct(Product p) {
        
        this.newProducts.add(p);
        
    }
    
    /**
     * 
     * @return Returns the current inventory of products.
     */
    
    public ArrayList<Product> getInventory() {
        
        return inventory;
        
    }
    
    /**
     * 
     * @return Returns the current memberships that are saved.
     */
    
    public ArrayList<FreeMembership> getMembers() {
        
        return memberships;
        
    }
    
    /**
     * 
     * @param member Adds a new membership to the saved list of memberships.
     */
    
    public void addMember(FreeMembership member) {
        
        this.memberships.add(member);
        
    }
    
    /**
     * 
     * @param member Member that will be added to the newMembers array list.
     */
    
    public void addNewMember(FreeMembership member) {
        
        this.newMembers.add(member);
        
    }
    
    /**
     * Function that adds a product to the inventory.
     */
    
    public void addProduct() {
        
        System.out.println("\nWhat would you like to add?\n"
                            + "     1. Book\n" 
                            + "     2. CD\n"
                            + "     3. DVD\n");
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("\nCaught InputMismatchException.\n");
        }
        
        if (choice == 1) {
            
            //scan.nextLine();
            System.out.println();
            System.out.println("What is the name of the book?\n");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.println();
            System.out.println("Who is the author?\n");
            //scan.nextLine();
            String author = scan.nextLine();
            System.out.println();
            System.out.println("What is the price?\n");
            double price = 0;
            try {
                price = scan.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("\nCaught InputMismatchException.\n");
            }
            System.out.println();
            System.out.println("What is the product ID?\n");
            int id = 0;
            try {
                id = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\nCaught InputMismatchException.\n");
            }
            System.out.println();
            System.out.println("What is the quantity of books you want to add?\n");
            int quantity = 0;
            try {
                quantity = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\nCaught InputMismatchException.\n");
            }
            System.out.println();
            Book newBook = new Book(price, name, id, quantity, author);
            inventory.add(newBook);
            newProducts.add(newBook);
            
        }
        
        else if (choice == 2) {
            
            //scan.nextLine();
            System.out.println();
            System.out.println("What is the name of the CD?\n");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.println();
            System.out.println("Who is the artist?\n");
            //scan.nextLine();
            String artist = scan.nextLine();
            System.out.println();
            System.out.println("What is the price?\n");
            double price = 0;
            try {
                price = scan.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("\nCaught InputMismatchException.\n");
            }
            System.out.println();
            System.out.println("What is the product ID?\n");
            int id = 0;
            try {
                id = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\nCaught InputMismatchException.\n");
            }
            System.out.println();
            System.out.println("What is the quantity of CDs you want to add?\n");
            int quantity = 0;
            try {
                quantity = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\nCaught InputMismatchException.\n");
            }
            System.out.println();
            CD newCD = new CD(price, name, id, quantity, artist);
            inventory.add(newCD);
            newProducts.add(newCD);
            
        }
        
        else if (choice == 3) {
            
            //scan.nextLine();
            System.out.println();
            System.out.println("What is the name of the DVD?\n");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.println();
            String creator = "n/a";
            System.out.println("What is the price?\n");
            double price = 0;
            try {
                price = scan.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("\nCaught InputMismatchException.\n");
            }
            System.out.println();
            System.out.println("What is the product ID (4-digit number please)?\n");
            int id = 0;
            try {
                id = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\nCaught InputMismatchException.\n");
            }
            System.out.println();
            System.out.println("What is the quantity of DVDs you want to add?\n");
            int quantity = 0;
            try {
                quantity = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\nCaught InputMismatchException.\n");
            }
            DVD newDVD = new DVD(price, name, id, quantity, creator);
            inventory.add(newDVD);
            newProducts.add(newDVD);
            
        }
        
    }
    
    /**
     * Function that decreases the quantity of item by one.
     * @param item The item to remove.
     */
    
    public void removeProduct(Product item) {
        
        item.setQuantity(item.getQuantity()-1);
        
        if (item.getQuantity() <= 0) {
            
            item.setQuantity(0);
            
        }
        
    }
    
    /**
     * 
     * @param id Product ID number.
     * @param amount Quantity of product.
     */
    
    @Override
    public void restockProduct(int id, int amount) {
        
        Product item = null;
        
        for (Product p : inventory) {
            
            if (p.getId() == id) {
                
                item = p;
                
            }
            
        }
        
        if (item == null) {
         
            System.out.println("Item was not found.");
            
        }
        
        else {
        
            item.setQuantity(item.getQuantity() + amount);
            
            System.out.println("Your restock was successful!\n");
        }
        
    }
    
    /**
     * 
     * @return Returns the EOD report for the bookstore.
     */
    
    public String getOutputString() {
        
        String s = "";
        double total = 0;
        
        for (Product p : totalSales) {
            
            s = s.concat("- " + p.getName() + String.format("     Price: $%.2f", p.getPrice()) + "\n");
            total += p.getPrice();
            
        }
        
        s = s.concat("\nTotal: " + String.format("$%.2f", total) + "\n\n");
        s = s.concat("--- New Members ---\n\n");
        
        for  (FreeMembership member : newMembers) {
            
            s = s.concat("- " + member.getName() + "     Is Premium Member?: " + member.getMembership() + "\n");
            
        }
        
        s = s.concat("\n--- Added Products ---\n");
        
        for (Product p : newProducts) {
            
            if (p instanceof Book) {
                
                s = s.concat("Type: Book     Name: " + p.getName() + "     ID: " + p.getId() + String.format("     Price: $%.2f", p.getPrice()) + "     Quantity: " + p.getQuantity() + "\n");
                
            }
            
            else if (p instanceof CD) {
                
                s = s.concat("Type: CD     Name: " + p.getName() + "     ID: " + p.getId() + String.format("     Price: $%.2f", p.getPrice()) + "     Quantity: " + p.getQuantity() + "\n");
                
            }
            
            else if (p instanceof DVD) {
                
                s = s.concat("Type: DVD     Name: " + p.getName() + "     ID: " + p.getId() + String.format("     Price: $%.2f", p.getPrice()) + "     Quantity: " + p.getQuantity() + "\n");
                
            }
            
        }

        return s;
        
    }
    
    @Override
    public double inventoryValue() {
        
        double sum = 0;
        
        for (Product p : inventory) {
            
            sum += p.getPrice();
            
        }
        
        return sum;
        
    }
    
}
