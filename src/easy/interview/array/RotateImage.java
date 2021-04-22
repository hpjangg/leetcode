package easy.interview.array;

public class RotateImage {

    public static void main(String[] args) {
        new RotateImage().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}}); // [[7,4,1],[8,5,2],[9,6,3]]
        new RotateImage().rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}); // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < (len+1) / 2; i++) {
            for (int k = 0; k < len / 2; k++) {
                int ii = len - i - 1;
                int kk = len - k - 1;
                int temp = matrix[kk][i];
                matrix[kk][i] = matrix[ii][kk];
                matrix[ii][kk] = matrix[k][ii];
                matrix[k][ii] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }

}
