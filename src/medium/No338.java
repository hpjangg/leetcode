package medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given an integer num, return an array of the number of 1's in the binary representation of every number in the range [0, num].
 *
 *
 * Example 1:
 *
 * Input: num = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 *
 * Example 2:
 *
 * Input: num = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 * Constraints:
 *
 * 0 <= num <= 105
 */

public class No338 {

    public static void main(String[] args) {
        new No338Implement().countBits(2);
    }

}

class No338Implement {
    public int[] countBits(int num) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i <= num; i++) {
            list.add(Integer.toBinaryString(i).replaceAll("0", "").length());
        }

        return Arrays.stream(list.toArray(new Integer[0]))
                .mapToInt(s -> s).toArray();
    }
}
