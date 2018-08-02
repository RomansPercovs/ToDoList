package todolist.service;

import todolist.models.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();
}
