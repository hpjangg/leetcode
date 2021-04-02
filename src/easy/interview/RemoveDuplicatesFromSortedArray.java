package easy.interview;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedArrayImp().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

}

class RemoveDuplicatesFromSortedArrayImp {

    public int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[index++] = nums[i+1];
            }
        }

        return index;
    }

}
