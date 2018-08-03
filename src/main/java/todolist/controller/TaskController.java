package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import todolist.forms.TaskForm;
import todolist.models.Task;
import todolist.service.TaskServiceImp;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskServiceImp taskServiceImp;

    @GetMapping("/tasks")
    public List<Task> showAllTasks() {
        return taskServiceImp.findAll();
    }

    @PostMapping(value = "/create")
    public String createTask(TaskForm taskForm){
        taskServiceImp.create(new Task(taskForm.getName(),taskForm.getTask(), taskForm.getStatus()));
        return "create";
    }

}
