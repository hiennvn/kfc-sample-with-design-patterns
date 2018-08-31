package kfc.shared.order;

import java.util.List;
import kfc.shared.Food;

/**
 *
 * @author hien
 */
public interface Order {
    public List<Food> getFoods();
    public String getDetail();
    public int getTotal();
    
    public boolean addFood(Food food);
    public boolean addRequest(AdditionalRequest request);
}
