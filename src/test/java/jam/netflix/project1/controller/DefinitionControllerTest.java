package jam.netflix.project1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jam.netflix.project1.model.Definition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DefinitionController.class)
public class DefinitionControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    private List<Definition> definitionList;

    @Test
    public void shouldGetAllDefinitions() throws Exception
    {
        String outputJson = mapper.writeValueAsString(definitionList);
        mockMvc.perform(get("/definition"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetRandomDefinition() throws Exception
    {
        String outputJson = mapper.writeValueAsString(definitionList);
        mockMvc.perform(get("/definition/random"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetSpecificDefinitionByWord() throws Exception
    {
        String outputJson = mapper.writeValueAsString(definitionList);
        mockMvc.perform(get("/definition/Object"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnFailWithBadWord() throws Exception
    {
        String outputJson = mapper.writeValueAsString(definitionList);
        mockMvc.perform(get("/Definition/HowDoIExitVim"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
