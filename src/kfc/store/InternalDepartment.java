package kfc.store;

/**
 *
 * @author hien
 */
interface InternalDepartment {
    DepartmentType getDepartmentType();
    void setNextDepartment(InternalDepartment department);
    void execute(InternalOrder order);
}
