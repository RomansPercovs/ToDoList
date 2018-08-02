package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import todolist.Task;
import todolist.service.TaskServiceImp;

import java.util.List;

@Controller
public class HomeController {

    private final TaskServiceImp taskServiceImp;

    @Autowired
    public HomeController(TaskServiceImp taskServiceImp) {
        this.taskServiceImp = taskServiceImp;
    }

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index.jsp");
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> showAllTasks() {
        return taskServiceImp.findAll();
    }

    @GetMapping(value = "/homepage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView homepage() {
        return new ModelAndView("homepage.html");
    }
}
