package oa;

import java.util.ArrayList;
import java.util.List;

public class GS_OA {
    static List<String> charityAllocation(List<Float> profits) {
        List<String> res = new ArrayList<>();
        if (profits.size() == 0) {
            return null;
        }
        float[] donation = new float[3];
        float min = 0;
        int minInt = 0;
        for (Float profit : profits) {
            for (int j = 0; j < 3; j++) {
                if (donation[j] < min) {
                    min = donation[j];
                    minInt = j;
                }
            }
            if (minInt == 0) {
                res.add("A");
            } else if (minInt == 1) {
                res.add("B");
            } else {
                res.add("C");
            }
            donation[minInt] += profit;
            min = donation[0];
            minInt = 0;
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(2);
        test.add(2);
        test.add(-7);
        test.add(-5);
        test.add(4);
        test.add(8);
        test.add(3);
        test.add(1);
        test.add(9);
        test.add(4);
        System.out.println(maxDifferenceOddEven(test));
    }
    static int maxDifferenceOddEven(List<Integer> a) {
        if (a.size() < 2) {
            return -1;
        }
        int firstOddIdx = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) % 2 == 1 || a.get(i) % 2 == -1) {
                firstOddIdx = i;
                break;
            }
        }
        if (firstOddIdx == -1 || firstOddIdx == a.size() - 1) {
            return -1;
        }
        int minOdd = a.get(firstOddIdx);
        int maxDiff = Integer.MIN_VALUE;
        for (int j = firstOddIdx + 1; j < a.size(); j++) {
            if (a.get(j) % 2 == 1 || a.get(j) % 2 == -1) {
                minOdd = Math.min(minOdd, a.get(j));
            } else {
                maxDiff = Math.max(maxDiff, a.get(j) - minOdd);
            }
        }
        if (maxDiff == Integer.MIN_VALUE) {
            return -1;
        }
        return maxDiff;
//        if (a.size() < 2) {
//            return -1;
//        }
//        int minOdd = Integer.MAX_VALUE;
//        int maxDiff = Integer.MIN_VALUE;
//        int firstOddIdx = 0;
//        int lastEvenIdx = 0;
//        boolean findFirstOdd = false;
//        boolean allOdd = true;
//        boolean allEven = true;
//        for (int i = 0; i < a.size(); i++) {
//            if (a.get(i) % 2 == 1 && (!findFirstOdd)) {
//                firstOddIdx = i;
//                allEven = false;
//                findFirstOdd = true;
//            } else {
//                allOdd = false;
//                lastEvenIdx = i;
//            }
//        }
//        if (allOdd || allEven || firstOddIdx > lastEvenIdx) {
//            return -1;
//        }
//        for (int j = firstOddIdx; j < a.size(); j++) {
//            if (a.get(j) % 2 == 1) {
//                if (a.get(j) < minOdd) {
//                    minOdd = a.get(j);
//                }
//            } else {
//                if (minOdd != Integer.MAX_VALUE) {
//                    maxDiff = Math.max(maxDiff, a.get(j) - minOdd);
//                }
//            }
//        }
//        return maxDiff;
    }

}
