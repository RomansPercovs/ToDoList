package todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolist.Task;
import todolist.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }
}
