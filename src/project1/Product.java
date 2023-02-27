package project1;

public abstract class Product implements Comparable<Product> {
    
    private double price;
    private String name;
    private int productId;
    private int quantity;
    private String creator;
    
    /**
     * 
     * @param p Price of object.
     * @param n Name of object.
     * @param id ID of object.
     * @param q Quantity of object.
     * @param c Author/artist of object.
     */
    
    public Product(double p, String n, int id, int q, String c) {
        
        this.price = p;
        this.name = n;
        this.productId = id;
        this.quantity = q;
        this.creator = c;
        
    }
    
    /**
     * 
     * @return Returns the price of an object.
     */
    
    public double getPrice() {
        
        return price;
        
    }
    
    /**
     * 
     * @return Returns the name of an object.
     */
    
    public String getName() {
        
        return name;
        
    }
    
    public int getId() {
        
        return productId;
        
    }
    
    public int getQuantity() {
        
        return quantity;
        
    }
    
    public void setQuantity(int q) {
        
        quantity = q;
        
    }
    
    public String getCreator() {
        
        return creator;
        
    }
    
    /**
     * 
     * @param p Reference of Product object to compare to.
     * @return Returns 0 if both products are equal in price.
     */
    
    @Override
    public int compareTo(Product p) {
        
        if (this.getPrice() < p.getPrice()) {
            
            return -1;
            
        }
        
        else if (this.getPrice() > p.getPrice()) {
            
            return 1;
            
        }
        
        return 0;
        
    }
    
}
