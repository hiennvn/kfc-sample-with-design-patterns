package kfc.shared.communication;

import kfc.oc.OrderCenter;
import kfc.shared.order.Order;

/**
 *
 * @author hien
 */
public interface Store {
    public boolean acceptOrder(Order order);
    public void setOrderCenter(OrderCenter orderCenter);
}
