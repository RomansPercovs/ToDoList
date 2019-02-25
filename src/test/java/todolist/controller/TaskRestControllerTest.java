package todolist.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import todolist.models.Task;
import todolist.service.TaskServiceImp;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TaskServiceImp mockTaskRepository;

    @InjectMocks
    TaskRestController taskRestController;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskRestController).build();
    }

    @Test
    public void testShowAllTasks() throws Exception {
        Task task = Task.getInstance("Romans", "showAllTest", "Completed");
        List<Task> tasks = Collections.singletonList(task);
        Mockito.when(mockTaskRepository.findAll()).thenReturn(tasks);

        mockMvc.perform(get("/tasks")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].assignee", is("Romans")))
                .andExpect(jsonPath("$[0].assignment", is("showAllTest")))
                .andExpect(jsonPath("$[0].status", is("Completed")));
        Mockito.verify(mockTaskRepository).findAll();
    }

    @Test
    public void testCreateTask() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/create").accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Test\",\"assignment\":test,\"status\":In progress}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void testDeleteTask() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/tasks/{id}", "3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }
}
