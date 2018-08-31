package kfc.oc;

import java.util.List;
import kfc.shared.Food;

/**
 *
 * @author hien
 */
public class Menu {
    private static volatile Menu self;
    private List<Food> foods;
    
    private Menu() {
        if (self != null) { 
            throw new UnsupportedOperationException("Use getInstance()"); 
        }
    } 
    
    public static synchronized Menu getInstance() {
        if (self == null) {
            synchronized (Menu.class) {
                if (self == null) {
                    self = new Menu();
                }
            }
        }
        return self;
    }
    
    public List<Food> getFoods() {
        return foods;
    }
    
    public boolean addFood(Food food) {
        return foods.add(food);
    }
}
