package kfc.shared.communication;

import kfc.shared.order.Order;

/**
 *
 * @author hien
 */
public interface OrderCenter {
    public void register(Store store);
    public void unRegister(Store store);
    
    public void notify(Order order);
    public Order getOrder(Store store);
}
