package kfc.store;

import kfc.oc.OrderCenter;
import kfc.shared.order.Order;

/**
 *
 * @author hien
 */
public class Store implements kfc.shared.communication.Store {
    
    private OrderCenter orderCenter;
    private final InternalDepartment recipient;
    private final InternalDepartment kitchen;
    private final InternalDepartment delivery;
    
    public Store() {
        recipient = new Recipient();
        kitchen = new Kitchen();
        delivery = new Delivery();
        
        recipient.setNextDepartment(kitchen);
        kitchen.setNextDepartment(delivery);
    }

    @Override
    public boolean acceptOrder(Order order) {
        // TODO: some logic to accept order
        boolean accept = order != null;
        
        if (accept) {
            LocalOrder localOrder = new LocalOrder(orderCenter.getOrder(this));
            process(localOrder);
        }
        
        return accept;
    }

    @Override
    public void setOrderCenter(OrderCenter orderCenter) {
        this.orderCenter = orderCenter;
    }
    
    private void process(LocalOrder order) {
        recipient.execute(order);
    }
    
}
