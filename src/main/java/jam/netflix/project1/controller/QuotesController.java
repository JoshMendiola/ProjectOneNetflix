package jam.netflix.project1.controller;

import jam.netflix.project1.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class QuotesController
{

    private List<Quote> quoteList;

    public QuotesController()
    {
        Quote quote1 = new Quote(001, "Don Miguel Ruiz",
                "Always Do Your Best. Your best is going to change from moment to moment; " +
                        "it will be different when you are healthy as opposed to sick." +
                        " Under any circumstance, simply do your best, and you will avoid self-judgment, self-abuse and regret");
        Quote quote2 = new Quote(2, "Guillermo Del Toro",
                "There is beauty and humility in perfection.");
        Quote quote3 = new Quote(3, "Emiliano Zapata",
                "It is better to die on your feet than to live on your knees");
        Quote quote4 = new Quote(4, "Frida Kahlo",
                "Feet, what do I need you for when I have wings to fly?");
        Quote quote5 = new Quote(5, "Canelo Alvarez",
                "The more desperate you are, the more mistakes you make.");
        Quote quote6 = new Quote(6, "Octavio Paz",
                "Deserve your dream");
        Quote quote7 = new Quote(7, "Julio Cesar Chavez Sr.",
                "The fighter is born. He cannot be made");
        Quote quote8 = new Quote(8, "Juan Gabriel",
                "You don't ask about what can be seen");
        Quote quote9 = new Quote(9, "Anthony Quinn",
                "Thirteen, 13 children, and I love - I love them all. And I think I've been a good father to all of them.");
        Quote quote10 = new Quote(10, "Diego Luna",
                "Cinema is a mirror that can change the world");

        quoteList = Arrays.asList(quote1,quote2,quote3,quote4,quote5,quote6,quote7,quote8,quote9,quote10);
    }

    @RequestMapping(value = "/quotes", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Quote> GetAllQuotes()
    {
        return quoteList;
    }

    //returns a random quote as per the criteria
    @GetMapping(value = "/quotes/random")
    @ResponseStatus(value = HttpStatus.OK)
    public Quote GetRandomQuote()
    {
        Quote selectedQuote = null;
        Random rand = new Random();
        selectedQuote = quoteList.get(rand.nextInt(quoteList.size()));
        return selectedQuote;
    }

    //searches the list for quote by ID in the case that a user does not want a random quote
    @GetMapping(value = "/quotes/choose/{quoteID}")
    @ResponseStatus(value = HttpStatus.OK)
    public Quote GetQuotesById(@PathVariable int quoteID)
    {
        for(Quote thisQuote : quoteList) {
            if (thisQuote.getId() == (quoteID)) {
                return thisQuote;
            }
        }
        throw new IllegalArgumentException("Quote ID does not exist");
    }
}
