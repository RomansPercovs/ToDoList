package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import todolist.models.Task;
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
    public String index(Model model) {
        List<Task> tasks = taskServiceImp.findAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @GetMapping("/alltasks")
    public String alltasks(){
        return "alltasks";
    }
}
