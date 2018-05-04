import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolutionTest {

    @Test
    public void mergeTest() {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 6));
        input.add(new Interval(8, 10));
        input.add(new Interval(15, 18));
        List<Interval> output = new Solution().merge(input);
        Iterator<Interval> iterator = output.iterator();
        while(iterator.hasNext()) {
            Interval interval = iterator.next();
            System.out.println(Integer.toString(interval.start) + "-" + Integer.toString(interval.end));
        }
    }

}
