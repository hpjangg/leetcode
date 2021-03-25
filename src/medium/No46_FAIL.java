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

        return list;
    }

    private int getOutputLength(int length) {
        if (length <= 1) {
            return length;
        } else {
            return getOutputLength(length-1) * length;
        }
    }

}