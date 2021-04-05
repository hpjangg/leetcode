package woowa;

import java.util.Arrays;

public class No3 {

    public static void main(String[] args) {
        new No3Imp().solution(new int[]{3,2,-2,5,-3});
//        new No3Imp().solution(new int[]{1, 2, 3, -4});
    }

}

class No3Imp {

    /**
     * case
     *
     * [3,2,-2,5,-3]
     *
     * expected
     *
     * 3
     *
     */

    public int solution(int[] A) {
        Arrays.sort(A);

        int index = 0;

        for (int i = A.length-1; i >= 0; i--) {
            if(A[i] < 1 || i == index) return 0;

            if (A[i] == Math.abs(A[index])) {
                return A[i];
            }

            if (A[i] < Math.abs(A[index])) {
                index++;
                i++;
            }
        }

        return 0;
    }

}
