package kfc.store;

/**
 *
 * @author hien
 */
class Note {
    
    private InternalDepartment from;
    private InternalDepartment to;
    private String note;
    
    Note(InternalDepartment from, InternalDepartment to, String note) {
        this.from = from;
        this.to = to;
        this.note = note;
    }

    InternalDepartment getFrom() {
        return from;
    }

    void setFrom(InternalDepartment from) {
        this.from = from;
    }

    InternalDepartment getTo() {
        return to;
    }

    void setTo(InternalDepartment to) {
        this.to = to;
    }

    String getNote() {
        return note;
    }

    void setNote(String note) {
        this.note = note;
    }
}
