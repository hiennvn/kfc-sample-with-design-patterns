package kfc.shared.order;

import java.util.ArrayList;
import java.util.List;
import kfc.shared.Food;

/**
 *
 * @author hien
 */
public class FixedOrder implements Order {
    
    private final List<Food> foods;
    
    public FixedOrder() {
        foods = new ArrayList<>();
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public String getDetail() {
        StringBuilder detail = new StringBuilder();
        foods.forEach((food) -> {
            detail.append(String.format("%s\t%d\n", food.getName(), food.getPrice()));
        });
        
        detail.append("Total: ").append(getTotal());
        
        return detail.toString();
    }
    
    @Override
    public int getTotal() {
        int total = 0;
        total = foods.stream().map((food) -> food.getPrice()).reduce(total, Integer::sum);
        return total;
    }

    @Override
    public boolean addFood(Food food) {
        return foods.add(food);
    }

    @Override
    public boolean addRequest(AdditionalRequest request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
