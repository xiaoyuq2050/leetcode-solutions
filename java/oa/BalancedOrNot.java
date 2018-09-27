package oa;

import java.util.ArrayList;
import java.util.List;

public class BalancedOrNot {

    public static List<Integer> balancedOrNot(List<String> expressions, List<Integer> maxReplacements) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expressions.size(); i++) {
            int num_replace = 0;
            int depth = 0;
            for (int j = 0; j < expressions.get(i).length(); j++) {
                if (expressions.get(i).charAt(j) == '>') {
                    depth--;
                    if (depth < 0) {
                        num_replace++;
                        depth++;
                    }
                } else if (expressions.get(i).charAt(j) == '<') {
                    depth++;
                }
            }
            if (depth > 0 || num_replace > maxReplacements.get(i)) {
                res.add(1);
            } else {
                res.add(0);
            }
        }
        return res;
    }
}
