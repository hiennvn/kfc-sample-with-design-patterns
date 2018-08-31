package kfc.shared.order;

import java.util.ArrayList;
import java.util.List;
import kfc.shared.Food;

/**
 *
 * @author hien
 */
public class FlexibleOrder implements Order {
    
    protected Order order;
    private final List<AdditionalRequest> additionalRequests;
    
    private final int CUSTOM_ORDER_FEE = 10;
    
    public FlexibleOrder(Order order) {
        this.order = order;
        this.additionalRequests = new ArrayList<>();
    }

    @Override
    public List<Food> getFoods() {
        return order.getFoods();
    }

    @Override
    public String getDetail() {
        StringBuilder detail = new StringBuilder();
        
        detail.append("-- Foods: --\n");
        order.getFoods().forEach((food) -> {
            detail.append(String.format("%s\t%d\n", food.getName(), food.getPrice()));
        });
        
        detail.append("-- Changes: --\n");
        additionalRequests.forEach((request) -> {
            detail.append(String.format("%s\t%s\n", request.getRequestType(), request.getRequestDetail()));
        });
        
        detail.append("Total: ").append(getTotal());
        
        return detail.toString();
    }
    
    @Override
    public int getTotal() {
        int total = 0;
        total = order.getFoods().stream().map((food) -> food.getPrice()).reduce(total, Integer::sum);
        total += CUSTOM_ORDER_FEE;
        return total;
    }

    @Override
    public boolean addFood(Food food) {
        return order.addFood(food);
    }

    @Override
    public boolean addRequest(AdditionalRequest request) {
        return additionalRequests.add(request);
    }
}
