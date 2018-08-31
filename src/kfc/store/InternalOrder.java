package kfc.store;

import kfc.shared.order.Order;

/**
 *
 * @author hien
 */
interface InternalOrder extends Order {
    void updateNote(Note note);
    Note getNote(InternalDepartment department);
    Order getOriginalOrder();
    
    DepartmentType getCurrentDepartment();
    State getCurrentState();
    
    void setDepartment(InternalDepartment department);
    void setState(State state);
}
