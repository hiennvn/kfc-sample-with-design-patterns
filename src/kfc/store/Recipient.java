package kfc.store;

/**
 *
 * @author hien
 */
class Recipient implements InternalDepartment {
    
    private InternalDepartment nextDepartment;

    @Override
    public DepartmentType getDepartmentType() {
        return DepartmentType.RECIPIENT;
    }

    @Override
    public void setNextDepartment(InternalDepartment department) {
        if ((department instanceof Kitchen)) {
            throw new IllegalArgumentException();
        }
        nextDepartment = department;
    }

    @Override
    public void execute(InternalOrder order) {
        order.setDepartment(this);
        order.setState(State.OPEN);
        // TODO: further process
        order.updateNote(new Note(this, nextDepartment, "special note"));
        order.setState(State.CLOSED);
        
        nextDepartment.execute(order);
    }
    
}
