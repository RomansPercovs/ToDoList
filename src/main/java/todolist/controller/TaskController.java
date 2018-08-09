package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todolist.forms.TaskForm;
import todolist.models.Task;
import todolist.service.TaskServiceImp;

import java.util.List;

@RestController
public class TaskController {
    // TODO three methods: GET, POST, DELETE
    // POST

    private final TaskServiceImp taskServiceImp;

    @Autowired
    public TaskController(TaskServiceImp taskServiceImp) {
        this.taskServiceImp = taskServiceImp;
    }

    @GetMapping("/tasks")
    public List<Task> showAllTasks() {
        return taskServiceImp.findAll();
    }

    @PostMapping(value = "/create")
    public void createTask(final TaskForm form){
        taskServiceImp.create(new Task(form.getName(),form.getTask(), form.getStatus()));
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public void deleteTask(@PathVariable long id){
        taskServiceImp.deleteById(id);
    }
}
