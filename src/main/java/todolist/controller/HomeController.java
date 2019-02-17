package todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @GetMapping("/alltasks")
    public String alltasks() {
        return "alltasks";
    }
}
