package easy.interview.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    private static final int DOT = 46;
    private static final int ALL_BOX_COUNT = 9;

    public static void main(String[] args) {
        boolean testCase1 = new ValidSudoku().isValidSudoku(
                new char[][]{
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                }
        );
        boolean testCase2 = new ValidSudoku().isValidSudoku(
                new char[][]{
                        {'8','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                }
        );

        System.out.println(testCase1);
        System.out.println(testCase2);
    }

    public boolean isValidSudoku(char[][] board) {
        return checkRows(board) && checkColumns(board) && checkSubBoxes(board);
    }

    private boolean checkRows(char[][] board) {
        for (char[] chars : board) {
            Set<Integer> rowValues = new HashSet<>();
            for (char aChar : chars) {
                if (aChar != DOT) {
                    if (rowValues.contains((int) aChar)) {
                        return false;
                    }
                    rowValues.add((int) aChar);
                }
            }
        }
        return true;
    }

    private boolean checkColumns(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Integer> colValues = new HashSet<>();
            for (char[] chars : board) {
                if (chars[i] != DOT) {
                    if (colValues.contains((int) chars[i])) {
                        return false;
                    }
                    colValues.add((int) chars[i]);
                }
            }
        }
        return true;
    }

    private boolean checkSubBoxes(char[][] board) {
        int boxCnt = 0;
        int rowIdx = 0;
        int colIdx = 0;

        while (boxCnt < ALL_BOX_COUNT) {
            Set<Integer> boxValues = new HashSet<>();
            for (int i = colIdx; i < colIdx+3; i++) {
                for (int j = rowIdx; j < rowIdx+3; j++) {
                    if (board[i][j] != DOT) {
                        if (boxValues.contains((int) board[i][j])) {
                            return false;
                        }
                        boxValues.add((int) board[i][j]);
                    }
                }
            }

            colIdx += 3;

            if (colIdx == ALL_BOX_COUNT) {
                colIdx = 0;
                rowIdx += 3;
            }

            boxCnt++;
        }
        return true;
    }

}
