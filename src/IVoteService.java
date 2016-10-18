import java.util.ArrayList;
import java.util.Collections;

import static java.lang.reflect.Array.getLength;

/**
 * Created by MStev on 10/17/2016.
 */
public class IVoteService {
    private ArrayList<Student> studentArrayList;
    private boolean validateAnswers;
    Question question;
    private ArrayList<String> validator;
    ArrayList<String> answers;

    void reserve(Student student)
    {
        studentArrayList.add(student);
    }

    IVoteService(MonoQuestion monoQuestion)
    {
        //do nothing
    }

    IVoteService(MultiQuestion multiQuestion)
    {
        validateAnswers = true;
        this.validator = multiQuestion.getOptions();
    }

    private boolean validation (String answer)
    {
        for (int i = 0; i < getLength(this.validator); i++)
        {
            if(answer.equals(this.validator.get(i)))
            {
                return true;
            }
        }

        return false;
    }

    void tabulate ()
    {
        ArrayList<String> choices = new ArrayList<>();
        ArrayList<String> choicesSansDuplicates = new ArrayList<>();
        for(int i = 0; i < getLength(studentArrayList); i++)
        {
            choices.add(studentArrayList.get(i).getChoice());
        }

        for(int i = 0; i < getLength(choices); i++)
        {
            boolean add = true;
            for(int j = 0; j < getLength(choicesSansDuplicates); j++)
            {
                if(choicesSansDuplicates.get(j).equals(choices.get(i)))
                {
                    add = false;
                }
            }
            if (add)
            {
                choicesSansDuplicates.add(choices.get(i));
            }
        }

        for(int i = 0; i < getLength(choicesSansDuplicates); i++)
        {
            boolean print = true;
            if(validateAnswers)
            {
                print = validation(choicesSansDuplicates.get(i));
            }
            if (print) {System.out.println(choicesSansDuplicates.get(i) + " :: " + Collections.frequency(choices, choicesSansDuplicates.get(i)));}
        }
    }

}
