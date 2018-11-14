package oa;

import java.util.*;

public class Coursera {
    public static void main(String[] args) {
//        FinalDiscountedPrice(new int[] {5,1,3,4,6,2});
        LongestSubarray(new int[] {5,7,2,1,2,1,3}, 4);
    }
    /*
    [5,1,3,4,6,2]
    output: 14;1 5

    [1,3,3,2,5]
    output: 9;0 3 4
     */
    public static void FinalDiscountedPrice(int[] input) {
        int[] res1 = new int[input.length];
        int res = 0;
        Stack<Integer> monoStack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            while ((!monoStack.isEmpty()) && input[monoStack.peek()] >= input[i]) {
                res1[monoStack.peek()] = input[monoStack.peek()] - input[i];
                res += input[monoStack.peek()] - input[i];
                monoStack.pop();
            }
            monoStack.push(i);
        }
//        System.out.println(monoStack);
        List<Integer> res2 = new ArrayList<>();
        while (!monoStack.empty()) {
            res2.add(monoStack.peek());
            res += input[monoStack.pop()];
        }
        System.out.println("result=" + res);
//        System.out.println(Arrays.toString(res1));
        System.out.println(res2);
    }

    public static void LongestSubarray(int[] input, int k) {
        int sum = 0;
        int maxL = 0;
        int len = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            while (!list.isEmpty() && sum + input[i] > k) {
                sum -= list.peekFirst();
                len -= 1;
                list.removeFirst();
            }
            if (sum + input[i] <= k) {
                list.add(input[i]);
                len += 1;
                maxL = Math.max(maxL, len);
                sum += input[i];
            }
        }
        System.out.println(maxL);
    }

    /*
    3,2,1,2,7
     */
    public static int getMinimumUniqueSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int n = arr.size();

        int sum = arr.get(0);
        int prev = arr.get(0);

        for( int i = 1; i < n; i++ ) {
            int curr = arr.get(i);

            if( prev >= curr ) {
                curr = prev+1;
            }
            sum += curr;
            prev = curr;
        }
        return sum;
    }


}
