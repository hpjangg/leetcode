package medium.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1,2,3});
    }

    // Time Complexity: O(N * 2^N)
    // Space Complexity: O(N * 2^N)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            output.addAll(newSubsets);
        }
        return output;
    }
}
