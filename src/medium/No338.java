package medium;

public class No338 {

    public static void main(String[] args) {
        new No338Implement().countBits(2);
    }

}

class No338Implement {
    public int[] countBits(int num) {
        int[] result = new int[num+1];

        for (int i = 0; i <= num; i++) {
            String binaryString = Integer.toBinaryString(i).replaceAll("0", "");
            result[i] = binaryString.length();
        }

        return result;
    }
}
