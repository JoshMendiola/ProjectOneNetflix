package jam.netflix.project1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MagicController.class)
public class MagicControllerTest
{

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldGetAllAnswers() throws Exception
    {
        mockMvc.perform(get("/magic"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetOneAnswer() throws Exception
    {
        mockMvc.perform(get("/magic/choose/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
