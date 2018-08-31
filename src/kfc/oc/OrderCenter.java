package kfc.oc;

import java.util.ArrayList;
import java.util.List;
import kfc.shared.Food;
import kfc.shared.order.Order;
import kfc.shared.communication.Store;

/**
 *
 * @author hien
 */
public class OrderCenter implements kfc.shared.communication.OrderCenter {
    private final Hotline hotline = Hotline.getInstance();
    private final Menu menu = Menu.getInstance();
    
    private final List<Store> stores;
    private final List<Order> orders;
    private final Object MUTEXT = new Object();
    
    public OrderCenter() {
        stores = new ArrayList<>();
        orders = new ArrayList<>();
    }

    @Override
    public void register(Store store) {
        if (store == null)
            throw new IllegalArgumentException("Null Store");
        
        synchronized(MUTEXT) {
            if (!stores.contains(store)) {
                stores.add(store);
            }
        }
    }

    @Override
    public void unRegister(Store store) {
        synchronized(MUTEXT) {
            stores.remove(store);
        }
    }

    @Override
    public void notify(Order order) {
        StoreFinderStrategy storeFinder = StoreFinderFactory.createStrategy(FindingCriteria.LOCATION, stores);
        Store store;
        
        while ((store = storeFinder.getNextStore()) != null) {
            if (store.acceptOrder(order)) {
                return;
            }
        }
        
        // TODO: invalidate order, callback something
        orders.remove(order);
        throw new NullPointerException("Cannot find approriate store");
    }

    @Override
    public Order getOrder(Store store) {
        Order order = orders.get(orders.size());
        orders.remove(order);
        return order;
    }
    
    
    // Just a test function
    private void test() {
        menu.addFood(new Food("Combo 1", "Chicken 3 pieces, potatoes, drink", 13));
        menu.addFood(new Food("Combo 2", "Chicken 2 wings, potatoes, drink", 7));
        Order fixedOrder = OrderFactory.createOrder(OrderType.BASIC, null);
        Order flexibleOrder = OrderFactory.createOrder(OrderType.EXTRA, null);
    }
}