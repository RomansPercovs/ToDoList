package todolist.service;

import todolist.models.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();
    Task create(Task task);
    void deleteById(long id);
}
