package oa;

import java.util.*;

public class MaximumDifference {
    public static int maximumDifference(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
        List<TreeSet<Integer>> setList = new ArrayList<>();
        for (int i = 0; i < gFrom.size(); i++) {
            int from = gFrom.get(i);
            int to = gTo.get(i);
            boolean added = false;
            for (TreeSet<Integer> curset: setList) {
                if (curset.contains(from)) {
                    curset.add(to);
                    added = true;
                    break;
                } else {
                    if (curset.contains(to)) {
                        curset.add(from);
                        added = true;
                        break;
                    }
                }
            }
            if (!added) {
                TreeSet<Integer> newset = new TreeSet<Integer>();
                newset.add(from);
                newset.add(to);
                setList.add(newset);
            }
        }
        int max = 0;
        for (TreeSet<Integer> curset: setList) {
            int curmax = curset.last() - curset.first();
            max = Math.max(max, curmax);
        }
        return max;
    }
}
