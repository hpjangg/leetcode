package woowa;

import java.util.Arrays;

public class No4 {

    public static void main(String[] args) {
        new No4Imp().solution(new int[]{1,3,2,1}, new int[]{4,2,5,3,2});
    }

}

class No4Imp {

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);

        // 1, 1, 2, 3
        // 2, 2, 3, 4, 5

        int i = 0;
        for (int k = 0; k < n; k++) {
            if (B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

}
