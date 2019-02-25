package todolist.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndex() throws Exception {
        String url = "/";
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testCreate() throws Exception {
        String url = "/create";
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAllTasks() throws Exception {
        String url = "/alltasks";
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk());
    }

}
