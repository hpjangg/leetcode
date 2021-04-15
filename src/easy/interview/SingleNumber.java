package easy.interview;

import java.util.Arrays;

public class SingleNumber {

    public static void main(String[] args) {
        new SingleNumber().singleNumber(new int[]{4,1,2,1,2});
    }

    /**
     * 시간복잡도
     * O(n)
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];

        Arrays.sort(nums);

        int prevNum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length-1) return nums[i];

            if (i == 0) {
                if (nums[i] != nums[i+1]) {
                    return nums[i];
                }
            } else {
                if (prevNum != nums[i] && nums[i] != nums[i+1]) {
                    return nums[i];
                }
            }

            prevNum = nums[i];
        }

        return result;
    }

}
