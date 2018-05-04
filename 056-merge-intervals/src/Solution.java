import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {

    public List<Interval> sortInterval(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        while(!intervals.isEmpty()) {
            int min = Integer.MAX_VALUE;
            Interval minInterval = null;
            Iterator<Interval> iterator = intervals.iterator();
            while(iterator.hasNext()) {
                Interval interval = iterator.next();
                if(interval.start < min) {
                    min = interval.start;
                    minInterval = interval;
                }
            }
            res.add(minInterval);
            intervals.remove(minInterval);
        }
        return res;
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.isEmpty()) {
            return new ArrayList<>();
        }
        List<Interval> res = new ArrayList<>();
        List<Interval> input = sortInterval(intervals);
        Iterator<Interval> iterator = input.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;
        while(iterator.hasNext()) {
            interval = iterator.next();
            if(interval.start <= end && interval.end > end) {
                end = interval.end;
            }else if(interval.start >= start && interval.end <= end) {
                continue;
            }else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

}
