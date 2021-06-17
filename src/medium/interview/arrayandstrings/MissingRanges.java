package medium.interview.arrayandstrings;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
        new MissingRanges().findMissingRanges(new int[]{0,1,3,50,75}, 0, 99);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            if (lower < curr) {
                result.add(formatRange(lower, curr - 1));
            }
            lower = curr + 1;
        }

        return result;
    }

    // formats range in the requested format
    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }

}
