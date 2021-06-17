package medium.interview.arrayandstrings;

public class IncreasingTripletSubsequence {

    // https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/

    public static void main(String[] args) {
        new IncreasingTripletSubsequence().increasingTriplet(new int[]{10,20,3,2,1,1,2,0,4});
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n <= first_num) {
                first_num = n;
            } else if (n <= second_num) {
                second_num = n;
            } else {
                return true;
            }
        }
        return false;
    }

}
