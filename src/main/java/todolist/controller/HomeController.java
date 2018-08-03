package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import todolist.models.Task;
import todolist.service.TaskServiceImp;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TaskServiceImp taskServiceImp;

    @GetMapping("/")
    public ModelAndView index() {
        List<Task> tasks = taskServiceImp.findAll();
        return new ModelAndView("/index.jsp").addObject("tasks", tasks);
    }
}
