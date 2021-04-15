package easy.interview.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,1});
    }

    /**
     * 시간복잡도
     * O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }

}
