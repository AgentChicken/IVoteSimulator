import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by MStev on 10/17/2016.
 */
class Question {
    private String id;

    public String getInquiry() {
        return id;
    }
}

//multiQuestion supports multiple-choice questions. A list of acceptable responses is sent to Students
class MultiQuestion extends Question
{
    private ArrayList<String> options;

    ArrayList<String> getOptions() {
        return options;
    }

    MultiQuestion(ArrayList<String> options)
    {
        this.options = options;
    }
}


//monoQuestion supports single-answer, open-ended questions
//suggestedOptions can be used to print suggestions, but, since this is a simulation, the method isn't used
class MonoQuestion extends Question
{
    private ArrayList suggestedOptions;
}

/*
*   private String inquiry;
    private ArrayList options;

    Question(String s, ArrayList e)
    {
        this.inquiry = s;
        this.options = e;
    }

    public String getInquiry() {
        return inquiry;
    }

    public ArrayList getOptions() {
        return options;
    }*/