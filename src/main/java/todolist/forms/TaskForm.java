package todolist.forms;

import java.util.Objects;

public class TaskForm {

    private String assignee;
    private String task;
    private String status;

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(final String name) {
        this.assignee = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
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
                ", task='" + task + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskForm taskForm = (TaskForm) o;
        return Objects.equals(getAssignee(), taskForm.getAssignee()) &&
                Objects.equals(getTask(), taskForm.getTask()) &&
                Objects.equals(getStatus(), taskForm.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssignee(), getTask(), getStatus());
    }
}
