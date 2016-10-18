import static java.lang.reflect.Array.getLength;

/**
 * Created by MStev on 10/17/2016.
 */
public class Student {
    private String id;

    private String choice;

    String getChoice()
    {
        return choice;
    }

    Student(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

    void vote(MultiQuestion question, int selection)
    {
        if(selection + 1 > getLength(question.getOptions()))
        {
            System.out.println("Invalid option");
        } else
        {
            this.choice = question.getOptions().get(selection);
        }
    }
}
