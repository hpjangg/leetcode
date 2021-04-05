package woowa;

public class No1 {

    public static void main(String[] args) {
        new No1().solution(3, 2, new int[]{2,1,1,0,1});
        new No1().solution(2, 3, new int[]{0,0,1,1,2});
    }

    /**
     * case
     *
     * [2,1,1,0,1]
     *
     * expected
     *
     * 111000,10001
     */

    public String solution(int U, int L, int[] C) {
        StringBuilder uBuilder = new StringBuilder();
        StringBuilder lBuilder = new StringBuilder();

        for (int i = 0; i < C.length; i++) {
            U = rowsProcess(U, C, i, uBuilder);
            L = rowsProcess(L, C, i, lBuilder);
        }

        return isNotZero(U, L) ?
                "IMPOSSIBLE" : sumByUBuilderAndLBuilder(uBuilder, lBuilder).toString();
    }

    private int rowsProcess(int UL, int[] C, int i, StringBuilder ULBuilder) {
        if (UL != 0 && C[i] > 0) {
            ULBuilder.append("1");
            UL--;
            C[i]--;
        } else {
            ULBuilder.append("0");
        }
        return UL;
    }

    private boolean isNotZero(int U, int L) {
        return U != 0 || L != 0;
    }

    private StringBuilder sumByUBuilderAndLBuilder(StringBuilder uBuilder, StringBuilder lBuilder) {
        return new StringBuilder(uBuilder).append(",").append(lBuilder);
    }

}