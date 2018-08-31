package kfc.store;

/**
 *
 * @author hien
 */
public class Department implements InternalDepartment {
    
    private InternalDepartment nextDepartment;
    private DepartmentType type;
    
    @Override 
    public DepartmentType getDepartmentType() {
        return type;
    }

    @Override
    public void setNextDepartment(InternalDepartment department) {
        nextDepartment = department;
    }

    @Override
    public void execute(InternalOrder order) {
        order.setDepartment(this);
        order.setState(State.OPEN);
        // TODO: further process
        order.setState(State.CLOSED);
    }
    
}
