package kfc.oc;

import java.util.Dictionary;
import kfc.shared.order.FixedOrder;
import kfc.shared.order.FlexibleOrder;
import kfc.shared.order.Order;

/**
 *
 * @author hien
 */

enum OrderType {
    BASIC,
    EXTRA
}

class OrderFactory {
    
    static Order createOrder(OrderType type, Dictionary data) {
        Order order = null;
        
        switch (type) {
            case BASIC:
                order = new FixedOrder();
                // TODO: initialize data
                break;
            case EXTRA:
                order = new FlexibleOrder(new FixedOrder());
                // TODO: initialize data
                break;
        }
        
        return order;
    }
}
