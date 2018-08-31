package kfc.oc;

/**
 *
 * @author hien
 */
public class Hotline {
    private static volatile Hotline self;
    private final String phonePrefix = "+84";
    private final String phoneNumber = "19001900";
    
    private Hotline() {
        if (self != null) { 
            throw new UnsupportedOperationException("Use getInstance()"); 
        }
    } 
    
    public static synchronized Hotline getInstance() {
        if (self == null) {
            synchronized (Hotline.class) {
                if (self == null) {
                    self = new Hotline();
                }
            }
        }
        return self;
    }
    
    public String getNumber() {
        return phonePrefix + phoneNumber;
    }
    
    @Override
    public String toString() {
        return "Hotline: " + getNumber();
    }
}