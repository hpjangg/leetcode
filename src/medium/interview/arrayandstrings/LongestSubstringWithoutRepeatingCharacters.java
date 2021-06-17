package medium.interview.arrayandstrings;

public class LongestSubstringWithoutRepeatingCharacters {

    // https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/

    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew");
    }

    // Time Complexity: O(N)
    // Space Complexity: O(M)
    public int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }

            res = Math.max(res, right - left + 1);

            chars[r] = right;
            right++;
        }

        return res;
    }
}
