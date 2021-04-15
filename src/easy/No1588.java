package easy;

public class No1588 {

    public static void main(String[] args) {
        new No1588().sumOddLengthSubarrays(new int[]{1,4,2,5,3});
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;

        int odd = initOdd();

        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            result += oddProcess(arr, i, odd);
        }

        return result;
    }

    private int initOdd() {
        return 3;
    }

    private int oddProcess(int[] arr, int idx, int odd) {
        int sum = 0;

        int availableIdx = idx + odd;

        if (availableIdx > arr.length) return sum;

        for (int i = idx; i < availableIdx; i++) {
            sum += arr[i];
        }

        odd += 2;

        if (odd <= arr.length) {
            sum += oddProcess(arr, idx, odd);
        }

        return sum;
    }

}
