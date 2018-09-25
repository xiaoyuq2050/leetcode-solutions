package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> test1 = new ArrayList<>();
        // [[1,3],[2,6],[8,10],[15,18]]
        test1.add(new Interval(1,4));
        test1.add(new Interval(4,5));
        test1.add(new Interval(-1, 0));
//        test1.add(new Interval(8,10));
//        test1.add(new Interval(2,6));

        System.out.println(merge1(test1));
    }

    // Solution 1
    public static List<Interval> merge1(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if (interval1.start < interval2.start) {
                    return -1;
                }
                if (interval1.start > interval2.start) {
                    return 1;
                }
                if (interval1.end < interval2.end) {
                    return -1;
                }
                if (interval1.end > interval2.end) {
                    return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < intervals.size(); i++) {
            System.out.println(intervals.get(i));
        }
        int index = 0;
        while (index < intervals.size() - 1) {
            // overlapping condition
            if (intervals.get(index + 1).start <= intervals.get(index).end) {
                intervals.add(index, new Interval(
                        intervals.get(index).start, Math.max(intervals.get(index).end, intervals.get(index + 1).end)));
                intervals.remove(index + 1);
                intervals.remove(index + 1);
            } else {
                index++;
            }
        }
        return intervals;
    }

    // Solution 2: 扫描线算法
    public static List<Interval> merge2(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval interval: intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
    public static class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
       @Override
       public String toString() {
           return "[" + start + "," + end + "]";
       }
   }

}
