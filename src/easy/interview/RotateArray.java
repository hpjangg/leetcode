package easy.interview;

public class RotateArray {

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

    /**
     * 시간복잡도
     * k * (n - 1) = O(n)
     */
    public void rotate(int[] nums, int k) {

        while (k > 0) {
            for (int i = nums.length-1; i > 0; i--) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
            k--;
        }

    }

}
