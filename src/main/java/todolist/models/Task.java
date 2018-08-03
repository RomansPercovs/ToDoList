package todolist.models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "task")
    private String task;
    @Column(name = "status")
    private String status;

    public Task(String name, String task, String status) {
        this.name = name;
        this.task = task;
        this.status = status;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTask() {
        return task;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
