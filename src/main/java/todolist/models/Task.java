package todolist.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long id;
    @Column(name = "name")
    private String assignee;
    @Column(name = "task")
    private String assignment;
    private String status;

    public static Task getInstance(String assignee, String assignment, String status){
        return new Task(assignee, assignment, status);
    }

    private Task(String assignee, String assignment, String status){
        this.assignee = assignee;
        this.assignment = assignment;
        this.status = status;
    }

    public Task() {
    }

    public long getId() {
        return id;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getAssignment() {
        return assignment;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", assignee='" + assignee + '\'' +
                ", assignment='" + assignment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getId() == task.getId() &&
                Objects.equals(getAssignee(), task.getAssignee()) &&
                Objects.equals(getAssignment(), task.getAssignment()) &&
                Objects.equals(getStatus(), task.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAssignee(), getAssignment(), getStatus());
    }
}
