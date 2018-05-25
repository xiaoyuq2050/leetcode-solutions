package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < k ; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < queue.peek()) {
                continue;
            }
            else {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        System.out.println(Arrays.toString(queue.toArray()));
        return (int) queue.toArray()[0];
    }
}
