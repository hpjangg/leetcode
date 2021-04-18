package easy.interview.array;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    /**
     * 시간복잡도
     * O(n)
     */
    public int removeDuplicates(int[] nums) {
        int idx = 1;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[idx++] = nums[i+1];
            }
        }

        return idx;
    }

}
