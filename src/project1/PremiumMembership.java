package project1;

public class PremiumMembership extends FreeMembership {
    
    private int paymentMethod;
    private boolean feePaid = false;
    public static double monthlyFee = 20.00;
    
    /**
     * 
     * @param first First name of person creating membership.
     * @param last Last name of person creating membership.
     */
    
    public PremiumMembership(String first, String last) {
        
        super(first,last);
        isPrem = true;
        
    }
    
    /**
     * 
     * @return Returns the payment method selected.
     */
    
    public int getPaymentMethod() {
        
        return paymentMethod;
        
    }
    
    /**
     * 
     * @param paymentMethod Sets the payment method.
     */
    
    public void setPaymentMethod(int paymentMethod) {
        
        this.paymentMethod = paymentMethod;
        
    }
    
    /**
     * 
     * @return Returns whether the fee is paid or not.
     */
    
    public boolean isFeePaid() {
        
        return feePaid;
        
    }
    
    /**
     * 
     * @param feePaid Sets whether the fee is paid or not.
     */
    
    public void setFeePaid(boolean feePaid) {
        
        this.feePaid = feePaid;
        
    }
    
}
