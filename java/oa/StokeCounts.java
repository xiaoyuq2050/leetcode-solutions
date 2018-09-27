package oa;

import java.util.TreeMap;

public class StokeCounts {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3,2,1,2,1,5,3,3,4,2}));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 0;
        }
        int height = 0;
        for (int a : A) {
            if (a > height) {
                height = a;
            }
        }
        if (A.length == 1) {
            return height;
        }
        int stroke_count = 0;
        boolean[] stroke_continue = new boolean[height];
        for (int j = 0; j < height; j++) {
            if (A[0] > j) {
                stroke_continue[j] = true;
            }
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < height; j++) {
                if (stroke_continue[j]) {
                    if (A[i] <= j) {
                        stroke_continue[j] = false;
                        stroke_count++;
                        if (stroke_count > 1000000000) {
                            return -1;
                        }
                    }
                } else {
                    if (A[i] > j) {
                        stroke_continue[j] = true;
                    }
                }
            }
        }
        for (int j = 0; j < height; j++) {
            if (stroke_continue[j]) {
                stroke_count++;
                if (stroke_count > 1000000000) {
                    return -1;
                }
            }
        }
        return stroke_count;
    }
}
