package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import todolist.models.Task;
import todolist.service.TaskServiceImp;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskServiceImp taskServiceImp;

    @GetMapping("/tasks")
    public List<Task> showAllTasks() {
        return taskServiceImp.findAll();
    }

    @PostMapping(value = "/create")
    public String createTask(@RequestParam("name") String name, @RequestParam("task") String task, @RequestParam("status") String status){
        taskServiceImp.create(new Task(name,task, status));
        return "redirect:http://localhost:8080/";
    }

}
