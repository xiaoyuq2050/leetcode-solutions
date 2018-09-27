package oa;

import java.util.*;

public class SocialNetwork {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(3);
        solution(list);
    }

    public static void solution(List<Integer> counts) {
        Map<Integer, List<Integer>> count_idx = new HashMap<>();
        for (int i = 0; i < counts.size(); i++) {
            if (!count_idx.containsKey(counts.get(i))) {
                count_idx.put(counts.get(i), new ArrayList<>());
            }
            count_idx.get(counts.get(i)).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer key : count_idx.keySet()) {
            List<Integer> idx = count_idx.get(key);
            int group_count = idx.size() / key;
            for (int i = 0; i < group_count; i++) {
                List<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < key; j++) {
                    tmp.add(idx.get(i * key + j));
                }
                res.add(tmp);
            }
        }
        res.sort(Comparator.comparingInt(l -> l.get(0)));
        for (List<Integer> r : res) {
            for (int i = 0; i < r.size(); i++) {
                if (i == 0) {
                    System.out.print(r.get(i));
                } else {
                    System.out.print(" " + r.get(i));
                }
            }
            System.out.println();

        }
    }
}
