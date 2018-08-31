package kfc.store;

/**
 *
 * @author hien
 */
class Kitchen implements InternalDepartment {
    
    private InternalDepartment nextDepartment;

    @Override
    public DepartmentType getDepartmentType() {
        return DepartmentType.KITCHEN;
    }

    @Override
    public void setNextDepartment(InternalDepartment department) {
        if ((department instanceof Delivery)) {
            throw new IllegalArgumentException();
        }
        nextDepartment = department;
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
