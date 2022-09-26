package jam.netflix.project1.model;

public class Answer
{
    int id;
    String answer;

    String question;

    public Answer(int id, String question, String answer)
    {
        this.id = id;
        this.answer = answer;
        this.question = question;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

}
