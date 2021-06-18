package medium.interview.sortingandsearching;

public class FindPeekElement {

    public static void main(String[] args) {
        new FindPeekElement().findPeakElement(new int[]{1,2,1,3,5,6,4});
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}
