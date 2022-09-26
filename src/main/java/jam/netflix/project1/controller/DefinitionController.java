package jam.netflix.project1.controller;

import jam.netflix.project1.model.Definition;
import jam.netflix.project1.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class DefinitionController
{
    private List<Definition> definitionList;

    public DefinitionController()
    {
        Definition definition1 = new Definition(1,"Aggregation","A type of association where the aggregated object has a weaker form of association with the objects " +
                "that it is aggregating than is the case with composition. These objects have an existence independent of the aggregated object " +
                "and can continue to exist even after the aggregated object is disposed of");
        Definition definition2 = new Definition(2,"Attribute","A property or characteristic of an entity (databases) or an object (OOP).");
        Definition definition3 = new Definition(3,"Decryption","Using an algorithm and a key to convert encrypted message data into its plain text equivalent.");
        Definition definition4 = new Definition(4,"Inheritance","The relationship between two object types in which one is a kind of the other and shares some of its properties or behaviours.");
        Definition definition5 = new Definition(5,"List","A collection of elements with an inherent order.");
        Definition definition6 = new Definition(6,"Model","An abstraction of an entity in the real world or in the problem that enables an automated solution. The abstraction is a representation of the problem that leaves out unnecessary detail.");
        Definition definition7 = new Definition(7,"Object","An instance of a class.");
        Definition definition8 = new Definition(8,"Polymorphism","Giving an action one name that is shared up and down a class hierarchy. Each class in the hierarchy implements the action in a way appropriate to itself.");
        Definition definition9 = new Definition(9,"Server","A computer that provides shared resources to network users.");
        Definition definition10 = new Definition(10,"Netflix","an American subscription streaming service and production company based in Los Gatos, California. Founded on August 29, 1997, by Reed Hastings and Marc Randolph in Scotts Valley, California, it offers a film and television series library through distribution deals as well as its own productions, known as Netflix Originals.");

        definitionList = Arrays.asList(definition1,definition2,definition3,definition4,definition5,definition6,definition7,definition8,definition9,definition10);
    }

    @RequestMapping(value = "/definition", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Definition> GetAllDefinitions()
    {
        return definitionList;
    }

    @GetMapping(value = "/definition/random")
    @ResponseStatus(value = HttpStatus.OK)
    public Definition GetRandomDefinition()
    {
        Definition selectedDefinition = null;
        Random rand = new Random();
        selectedDefinition = definitionList.get(rand.nextInt(definitionList.size()));
        return selectedDefinition;
    }

    @GetMapping(value = "/definition/choose/{word}")
    @ResponseStatus(value = HttpStatus.OK)
    public Definition GetDefinitionByWord(@PathVariable String word)
    {
        for(Definition thisDefinition : definitionList)
        {
            if (thisDefinition.getWord().equals(word))
            {
                return thisDefinition;
            }
        }
        throw new IllegalArgumentException("Word is not in definition system");
    }
}
