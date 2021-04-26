package easy.interview.strings;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
//        new FirstUniqueCharacterInAString().firstUniqChar("leetcode");
        new FirstUniqueCharacterInAString().firstUniqChar("aabb");
    }

    public int firstUniqChar(String s) {
        String[] sArr = s.split("");

        for (int i = 0; i < sArr.length; i++) {
            boolean isUnique = true;

            for (int j = 0; j < sArr.length; j++) {
                if (i != j && sArr[i].equals(sArr[j])) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                return i;
            }
        }

        return -1;
    }

}
