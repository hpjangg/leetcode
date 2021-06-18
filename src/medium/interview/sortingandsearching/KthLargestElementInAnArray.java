package medium.interview.sortingandsearching;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        new KthLargestElementInAnArray().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    }

    // Time Complexity: O(N log k)
    // Space Complexity: O(k)
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
