package todolist.forms;

import java.util.Objects;

public class TaskForm {

    private String assignee;
    private String assignment;
    private String status;

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(final String name) {
        this.assignee = name;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskForm{" +
                "assignee='" + assignee + '\'' +
                ", assignment='" + assignment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskForm taskForm = (TaskForm) o;
        return Objects.equals(getAssignee(), taskForm.getAssignee()) &&
                Objects.equals(getAssignment(), taskForm.getAssignment()) &&
                Objects.equals(getStatus(), taskForm.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssignee(), getAssignment(), getStatus());
    }
}
