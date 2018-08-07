package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseBody
    public List<Task> showAllTasks() {
        return taskServiceImp.findAll();
    }

    @PostMapping(value = "/create")
    public String createTask(@RequestParam("name") String name, @RequestParam("task") String task, @RequestParam("status") String status){
        taskServiceImp.create(new Task(name,task, status));
        return "redirect:http://localhost:8080/";
    }

//    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
//    public ResponseEntity deleteTask(@PathVariable long id){
//        taskServiceImp.deleteById(id);
//        return new ResponseEntity<Long>(id, HttpStatus.OK);
//    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody String deleteTask(@PathVariable long id){
        taskServiceImp.deleteById(id);
        return "redirect:http://localhost:8080/";
    }


}
