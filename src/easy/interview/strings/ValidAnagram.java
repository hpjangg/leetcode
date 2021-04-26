package easy.interview.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidAnagram {

    public static void main(String[] args) {
        new ValidAnagram().isAnagram("anagram", "nagaram");
    }

    public boolean isAnagram(String s, String t) {
        List<String> sList = Arrays.stream(s.split("")).collect(Collectors.toList());
        List<String> tList = Arrays.stream(t.split("")).collect(Collectors.toList());

        for (int i = sList.size()-1; i >= 0; i--) {
            if (tList.contains(sList.get(i))) {
                tList.remove(sList.get(i));
                sList.remove(i);
            }
        }

        return sList.isEmpty() && tList.isEmpty();
    }

}
