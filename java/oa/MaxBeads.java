package oa;

import java.util.HashSet;
import java.util.Set;

public class MaxBeads {
    /*
    A[0] = 5
  A[1] = 4
  A[2] = 0
  A[3] = 3
  A[4] = 1
  A[5] = 6
  A[6] = 2
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[] {5,4,0,3,1,6,2}));
    }
    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        int maxBeads = 0;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> curBeads = new HashSet<>();
        int start_idx = 0;
        while (start_idx < A.length) {
            curBeads.add(start_idx);
            int cur_idx = start_idx;
            while (!curBeads.contains(A[cur_idx])) {
                cur_idx = A[cur_idx];
                curBeads.add(cur_idx);
            }
            if (curBeads.size() > maxBeads) {
                maxBeads = curBeads.size();
            }
            visited.addAll(curBeads);
            curBeads.clear();
            while (visited.contains(start_idx)) {
                start_idx++;
            }
        }
        return maxBeads;
    }
}
