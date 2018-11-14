package array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> newLine = new ArrayList<>();
            newLine.add(1);
            for (int j = 1; j < i; j++) {
                newLine.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            if (newLine.size() < i + 1) {
                newLine.add(1);
            }
            res.add(newLine);
        }
        return res;
    }
}
