package kfc.store;

import java.util.ArrayList;
import java.util.List;
import kfc.shared.Food;
import kfc.shared.order.AdditionalRequest;
import kfc.shared.order.Order;

/**
 *
 * @author hien
 */
class LocalOrder implements InternalOrder {
    
    private final Order order;
    private final List<Note> notes;
    private InternalDepartment department;
    private State state;
    
    LocalOrder(Order order) {
        this.order = order;
        this.notes = new ArrayList<>();
    }
    
    @Override
    public void updateNote(Note note) {
        notes.add(note);
    }

    @Override
    public Note getNote(InternalDepartment department) {
        for (Note note : notes) {
            if (note.getTo() == department) {
                return note;
            }
        }
        return null;
     }

    @Override
    public List<Food> getFoods() {
        return order.getFoods();
    }

    @Override
    public String getDetail() {
        return order.getDetail();
    }

    @Override
    public int getTotal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addFood(Food food) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addRequest(AdditionalRequest request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order getOriginalOrder() {
        return order;
    }

    @Override
    public DepartmentType getCurrentDepartment() {
        return department.getDepartmentType();
    }

    @Override
    public void setDepartment(InternalDepartment department) {
        this.department = department;
    }
    
    @Override
    public State getCurrentState() {
        return state;
    }
    
    @Override
    public void setState(State state) {
        this.state = state;
    }
    
}
