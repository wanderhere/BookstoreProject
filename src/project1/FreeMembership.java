package project1;

public class FreeMembership {
    
    public boolean isPrem;
    private String firstName, lastName;
    private double totalSpent;
    
    /**
     * 
     * @param first First name of person creating membership.
     * @param last Last name of person creating membership.
     */
    
    public FreeMembership(String first, String last) {
        
        this.firstName = first;
        this.lastName = last;
        isPrem = false;
        
    }
    
    /**
     * 
     * @return Returns the first and last name.
     */
    
    public String getName() {
        
        return firstName + " " + lastName;
        
    }
    
    /**
     * 
     * @param firstName Sets the first name.
     */
    
    public void setFirstName(String firstName) {
        
        this.firstName = firstName;
        
    }
    
    /**
     * 
     * @param lastName Sets the last name.
     */
    
    public void setLastName(String lastName) {
        
        this.lastName = lastName;
        
    }
    
    /**
     * 
     * @return Returns the total amount spent.
     */
    
    public double getTotalSpent() {
        
        return totalSpent;
        
    }
    
    /**
     * 
     * @param totalSpent Sets the total amount spent.
     */
    
    public void setTotalSpent(double totalSpent) {
        
        this.totalSpent = totalSpent;
        
    }
    
    /**
     * 
     * @return Returns whether the member is premium or not.
     */
    
    public boolean getMembership() {
        
        return isPrem;
        
    }
    
}
