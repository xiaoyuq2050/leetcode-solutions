package oa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmartSale {
    public static void main(String[] args) {
        List<Integer> newl = new ArrayList<>();
        newl.add(1);
        newl.add(1);
        newl.add(2);
        newl.add(2);
        newl.add(2);
        newl.add(3);
        System.out.println(deleteProducts(newl, 3));
    }
    public static int deleteProducts(List<Integer> ids, int m) {
        // Write your code here

        Map<Integer, Integer> idmap = new HashMap<>();
        for (int i = 0; i < ids.size(); i++) {
            if (idmap.containsKey(ids.get(i))) {
                idmap.put(ids.get(i), idmap.get(ids.get(i)) + 1);
            } else {
                idmap.put(ids.get(i), 1);
            }
        }
        List<int[]> idlist = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: idmap.entrySet()) {
            idlist.add(new int[] {entry.getKey(), entry.getValue()});
        }
        idlist.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        for (int i = 0; i < idlist.size(); i++) {
            count += idlist.get(i)[1];
            if (count > m) {
                return idlist.size() - i;
            }
            if (count == m) {
                return idlist.size() - i - 1;
            }
        }
        return 0;
    }


}
