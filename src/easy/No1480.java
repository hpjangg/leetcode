package easy;

public class No1480 {

    public static void main(String[] args) {
        int[] testcase1 = {1,2,3,4};
        process(testcase1);
    }

    private static int[] process(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }

}
