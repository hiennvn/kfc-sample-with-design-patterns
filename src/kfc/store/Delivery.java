package kfc.store;

/**
 *
 * @author hien
 */
class Delivery implements InternalDepartment {
    
    private InternalDepartment nextDepartment;

    @Override
    public DepartmentType getDepartmentType() {
        return DepartmentType.DELIVERY;
    }

    @Override
    public void setNextDepartment(InternalDepartment department) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void execute(InternalOrder order) {
        order.setDepartment(this);
        order.setState(State.OPEN);
        // TODO: further process
        order.setState(State.CLOSED);
        
        nextDepartment.execute(order);
    }
    
}
