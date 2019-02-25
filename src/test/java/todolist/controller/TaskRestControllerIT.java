package todolist.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import todolist.TODOWebServiceMain;
import todolist.models.Task;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TODOWebServiceMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskRestControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testGetAllTasks() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/tasks"),
                HttpMethod.GET, entity, String.class);
        String expected = "[{id:27,assignee:test,assignment:test,status:test}]";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCreateTask() {
        Task task = Task.getInstance("1234", "1234", "done");
        HttpEntity<Task> entity = new HttpEntity<>(task, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(createURLWithPort("/create"),
                HttpMethod.POST, entity, String.class);
        String actual = responseEntity.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(actual.contains("/"));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}

