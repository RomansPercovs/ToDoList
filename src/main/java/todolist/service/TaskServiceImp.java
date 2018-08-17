package todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolist.models.Task;
import todolist.repositories.TaskRepository;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = requireNonNull(taskRepository);
    }

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Override
    public Task create(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public void deleteById(long id) {
        this.taskRepository.deleteById(id);
    }
}
