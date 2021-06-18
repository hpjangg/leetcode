package medium.interview.sortingandsearching;

public class SortColors {

    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{2,0,2,1,1,0});
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public void sortColors(int[] nums) {
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;
        int tmp;
        while (curr <= p2) {
            if (isRed(nums[curr])) {
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (isBlue(nums[curr])) {
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else {
                curr++;
            }
        }
    }

    private boolean isRed(int num) {
        return num == 0;
    }

    private boolean isBlue(int num) {
        return num == 2;
    }
}
