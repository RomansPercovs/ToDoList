package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todolist.forms.TaskForm;
import todolist.models.Task;
import todolist.service.TaskServiceImp;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class TaskController {

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
    public void createTask(final TaskForm form, HttpServletResponse response) throws IOException {
        taskServiceImp.create(new Task(form.getName(),form.getTask(), form.getStatus()));
        response.sendRedirect("/");
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public void deleteTask(@PathVariable long id){
        taskServiceImp.deleteById(id);
    }
}
