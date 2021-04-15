package easy.interview.array;

import java.util.*;

public class IntersectionOfTwoArrays2 {

    public static void main(String[] args) {
        new IntersectionOfTwoArrays2().intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
    }

    /**
     * 시간복잡도
     * O(n^2)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length < nums2.length) {
            return intersectProcess(nums1, nums2);
        } else {
            return intersectProcess(nums2, nums1);
        }
    }

    private int[] intersectProcess(int[] smallerSizeNums, int[] biggerSizeNums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < smallerSizeNums.length; i++) {
            for (int j = 0; j < biggerSizeNums.length; j++) {
                if (smallerSizeNums[i] == biggerSizeNums[j]) {
                    list.add(smallerSizeNums[i]);
                    smallerSizeNums[i] = -1;
                    biggerSizeNums[j] = -1;
                    break;
                }
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

}
