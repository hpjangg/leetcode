package medium;

public class No1769 {

    public static void main(String[] args) {
        minOperations("110");
        minOperations("001011");
    }

    public static int[] minOperations(String boxes) {
        String[] toStrArr = boxes.split("");

        int[] result = new int[toStrArr.length];

        for (int i = 0; i < toStrArr.length; i++) {
            for (int j = 0; j < toStrArr.length; j++) {
                moveBall(i, j, toStrArr, result);
            }
        }

        return result;
    }

    private static void moveBall(int i, int j, String[] toStrArr, int[] result) {
        if (isExistBall(i, j, toStrArr[j])) {
            result[i] += Math.abs(i-j);
        }
    }

    private static boolean isExistBall(int i, int j, String ball) {
        return i != j && ball.equals("1");
    }
}
