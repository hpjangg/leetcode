package medium.interview.arrayandstrings;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        new SetMatrixZeroes().setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }

    // Time Complexity: O(MN)
    // Space Complexity: O(M+N)
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

}
