package medium.interview.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        new UniquePaths().uniquePaths(3, 7);
    }

    // Time Complexity: O(NM)
    // Space Complexity: O(NM)
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        for(int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for(int col = 1; col < m; ++col) {
            for(int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }

}
