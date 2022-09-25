package jam.netflix.project1.controller;

import jam.netflix.project1.model.Answer;
import jam.netflix.project1.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class AnswerController
{
    private List<Answer> answerList;

    public AnswerController()
    {
        Answer answer1 = new Answer(1, "Yes");
        Answer answer2 = new Answer(2, "No");
        Answer answer3 = new Answer(3, "Maybe");
        Answer answer4 = new Answer(4, "Ask again later");
        Answer answer5 = new Answer(5, "Perhaps");
        Answer answer6 = new Answer(6, "Definitely");
        Answer answer7 = new Answer(7, "If you say so");
        Answer answer8 = new Answer(8, "Definitely Not");
        Answer answer9 = new Answer(9, "For sure");
        Answer answer10 = new Answer(10, "Dont even think about it");

        answerList =  Arrays.asList(answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,answer9,answer10);
    }

    @RequestMapping(value = "/answer", method = RequestMethod.GET)
    public List<Answer> getAllAnswers()
    {
        return answerList;
    }

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> getAnswerByQuestion(@RequestBody String question)
    {
        Answer selectedAnswer = null;
        Random rand = new Random();
        selectedAnswer = answerList.get(rand.nextInt(answerList.size()));
        return new ResponseEntity(selectedAnswer.getAnswer(),HttpStatus.OK);
    }
}
