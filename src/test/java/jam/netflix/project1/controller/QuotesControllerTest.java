package jam.netflix.project1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jam.netflix.project1.model.Quote;
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
@WebMvcTest(QuotesController.class)
public class QuotesControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Quote> quoteList;

    @Test
    public void shouldGetAllQuotes() throws Exception
    {
        String outputJson = mapper.writeValueAsString(quoteList);
        mockMvc.perform(get("/quotes"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetRandomQuote() throws Exception
    {
        String outputJson = mapper.writeValueAsString(quoteList);
        mockMvc.perform(get("/quotes/random"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetSpecificQuote() throws Exception
    {
        String outputJson = mapper.writeValueAsString(quoteList);
        mockMvc.perform(get("/quotes/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnFailWithBadId() throws Exception
    {
        String outputJson = mapper.writeValueAsString(quoteList);
        mockMvc.perform(get("/quotes/12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
