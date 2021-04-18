package easy.interview.array;

public class MoveZeroes {

    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[]{0,1,0,3,12});
        new MoveZeroes().moveZeroes(new int[]{0,0,1});
    }

    /**
     * 시간복잡도
     * O(n^2)
     */
    public void moveZeroes(int[] nums) {
        int notZeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = i; j >= notZeroCount+1; j--) {
                    changeNum(nums, j);
                }
                notZeroCount++;
            }
        }
    }

    private void changeNum(int nums[], int j) {
        int temp = nums[j-1];
        nums[j-1] = nums[j];
        nums[j] = temp;
    }

}
