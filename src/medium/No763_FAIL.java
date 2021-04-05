package medium;

import java.util.LinkedList;
import java.util.List;

public class No763_FAIL {

    public static void main(String[] args) {
//        new No763_FAIL().partitionLabels("ababcbacadefegdehijhklij");
//        new No763_FAIL().partitionLabels("caedbdedda");
        new No763_FAIL().partitionLabels("eaaaabaaec");
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> resList = new LinkedList<>();

        while (!S.isEmpty()) {
            String first = S.substring(0, 1);

            int lastIndex = 0;

            for (int i = 0; i < S.length(); i++) {
                String current = S.substring(i, i+1);
                if (first.equals(current)) {
                    lastIndex = i;
                }
            }

            if (lastIndex != 0) {
                resList.add(S.substring(0, lastIndex+1).length());
                S = S.substring(lastIndex+1);
            } else {
                if (!resList.isEmpty()) {
                    resList.set(resList.size()-1, resList.get(resList.size()-1) + 1);
                } else {
                    resList.add(1);
                }
                S = S.substring(1);
            }
        }

        return resList;
    }

    public List<Integer> partitionLabels2(String S) {
        List<java.lang.Integer> resList = new LinkedList<>();

        while (!S.isEmpty()) {
            String a = S.substring(0, 1);

            int max = 0;
            for (int j = 1; j < S.length(); j++) {
                String b = S.substring(j, j+1);
                if (a.equals(b)) {
                    max = j;
                }
            }

            if (resList.isEmpty() && max == 0) {

            }

        }

        return resList;
    }

}
