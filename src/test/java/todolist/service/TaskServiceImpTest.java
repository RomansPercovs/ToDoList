package todolist.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import todolist.models.Task;
import todolist.repositories.TaskRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceImpTest {

    @Mock
    private TaskRepository mockTaskRepository;
    @InjectMocks
    private TaskServiceImp taskServiceImp;

    @Test
    public void testFindAll() {
        List<Task> expectedTasks = new ArrayList<>();
        expectedTasks.add(Task.getInstance("assignee1", "assignment1", "status1"));
        expectedTasks.add(Task.getInstance("assignee2", "assignment2", "status2"));
        when(mockTaskRepository.findAll()).thenReturn(expectedTasks);
        List<Task> actualTasks = taskServiceImp.findAll();
        verify(mockTaskRepository).findAll();
        assertEquals(expectedTasks, actualTasks);
    }

    @Test
    public void testCreate() {
        Task newTask = Task.getInstance("assignee", "assignment", "status");
        when(mockTaskRepository.save(any(Task.class))).thenReturn(newTask);
        Task returnedTask = taskServiceImp.create(newTask);
        verify(mockTaskRepository, times(1)).save(any(Task.class));
        assertEquals(returnedTask.getId(), newTask.getId());
    }

    @Test
    public void testDeleteById() {
        taskServiceImp.deleteById(1L);
        verify(mockTaskRepository, times(1)).deleteById(anyLong());
    }
}
