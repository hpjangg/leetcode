package medium;

import java.util.ArrayList;
import java.util.List;

public class No46_FAIL {

    public static void main(String[] args) {
        new No46Implement().permute(new int[]{1, 2, 3, 4});
    }

}

class No46Implement {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        int outputLength = getOutputLength(nums.length);

        for (int i = 0; i < outputLength; i++) {
            List<Integer> integerList = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {
                integerList.add(nums[j]);
            }

            list.add(integerList);

            int prevNum = nums[nums.length-1];
            nums[nums.length-1] = nums[nums.length-2];
            nums[nums.length-2] = prevNum;

            if (list.size() % 2 == 0) {
                int prevNum2 = nums[nums.length-2];
                nums[nums.length-2] = nums[nums.length-3];
                nums[nums.length-3] = prevNum2;
            }

            if (list.size() % 6 == 0) {

            }

            if (list.size() % 24 == 0) {

            }

            if (list.size() % 120 == 0) {

            }

        }

        List<Integer> integerList = new ArrayList<>();
        integerList.add(nums[0]);
        integerList.add(nums[1]);
        integerList.add(nums[2]);
        integerList.add(nums[3]);
        integerList.add(nums[4]);
        list.add(integerList);

        // 1234
        // 1243
        // 1324
        // 1342
        // 1423
        // 1432

        // 2134
        // 2143
        // 2314
        // 2341
        // 2413
        // 2431


        return list;
    }

//    private int getOutputLength(int length) {
//        int outputLength = 1;
//        for (int i = 1; i <= length; i++) {
//            outputLength *= i;
//        }
//        return outputLength;
//    }

    private int getOutputLength(int length) {
        if (length <= 1) {
            return length;
        } else {
            return getOutputLength(length-1) * length;
        }
    }

}