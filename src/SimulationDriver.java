import java.util.ArrayList;
import java.util.Random;

import static java.lang.reflect.Array.getLength;

/**
 * Created by MStev on 10/17/2016.
 */
public class SimulationDriver {
    public static void main(String[] args)
    {
        ArrayList<String> options = new ArrayList<>();
        options.add("A");
        options.add("B");
        options.add("C");
        MultiQuestion question = new MultiQuestion(options);
        IVoteService iVoteService = new IVoteService(question);

        ArrayList<Student> studentPool = new ArrayList<Student>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(5) + 3; i++)
        {
            studentPool.add(new Student((Integer.toString(i))));
        }

        for(int i = 0; i < getLength(studentPool); i++)
        {
            iVoteService.reserve(studentPool.get(i));
        }

        for(int i = 0; i < getLength(studentPool); i++)
        {
            studentPool.get(i).vote(question, random.nextInt(2));
        }

        iVoteService.tabulate();
    }
}
