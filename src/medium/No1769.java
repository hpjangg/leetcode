package medium;

import java.util.Arrays;

/**
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 *
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 *
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 *
 * Each answer[i] is calculated considering the initial state of the boxes.
 *
 *
 * Example 1:
 *
 * Input: boxes = "110"
 * Output: [1,1,3]
 * Explanation: The answer for each box is as follows:
 * 1) First box: you will have to move one ball from the second box to the first box in one operation.
 * 2) Second box: you will have to move one ball from the first box to the second box in one operation.
 * 3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
 *
 * Example 2:
 *
 * Input: boxes = "001011"
 * Output: [11,8,5,4,3,4]
 *
 *
 * Constraints:
 *
 * n == boxes.length
 * 1 <= n <= 2000
 * boxes[i] is either '0' or '1'.
 */

public class No1769 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new No1769().minOperations(getTestcase01()))
        );
        System.out.println(
                Arrays.toString(new No1769().minOperations(getTestcase02()))
        );
    }

    private static String getTestcase01() {
        return "110";
    }

    private static String getTestcase02() {
        return "001011";
    }

    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];

        String[] toStrArr = boxes.split("");

        for (int i = 0; i < toStrArr.length; i++) {
            for (int j = 0; j < toStrArr.length; j++) {
                moveBall(i, j, toStrArr, result);
            }
        }

        return result;
    }

    private void moveBall(int i, int j, String[] toStrArr, int[] result) {
        if (isExistBall(i, j, toStrArr[j])) {
            result[i] += Math.abs(i-j);
        }
    }

    private boolean isExistBall(int i, int j, String ball) {
        return i != j && ball.equals("1");
    }

}
