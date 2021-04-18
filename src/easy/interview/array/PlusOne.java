package easy.interview.array;

import java.util.LinkedList;
import java.util.List;

public class PlusOne {

    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6});
    }

    /**
     * 시간복잡도
     * O(n)
     */
    public int[] plusOne(int[] digits) {
        List<Integer> list = new LinkedList<>();

        digits[digits.length-1]++;

        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] == 10) {
                if (i == 0) {
                    list.add(0, 0);
                    list.add(0, 1);
                } else {
                    digits[i-1]++;
                    list.add(0, 0);
                }
            } else {
                list.add(0, digits[i]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

}
