package line;

import java.util.*;

public class No1 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String D = sc.next();
        String L = sc.next();

        List<String> results = new ArrayList<>();

        char[] dChars = D.toCharArray();
        char[] lChars = L.toCharArray();

        // Time Complexity
        // D.length = N, L.length = M
        // O(NM)
        for (char dChar: dChars) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lChars.length; j++) {
                sb.append(lChars[j]);
                sb.append(j < lChars.length-1 ? dChar : "");
            }
            results.add(sb.toString());
        }

        // All Possible Combinations
        List<List<Character>> combinations = getCombinations(dChars);

        // Time Complexity
        // combinations.size = N, lChars.length = M
        // O(NM)
        for (List<Character> chars: combinations) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lChars.length; j++) {
                sb.append(lChars[j]);
                sb.append(j < lChars.length-1 ? chars.get(j) : "");
            }
            results.add(sb.toString());
        }

        Collections.sort(results);

        System.out.println(results.size());
        for (String result: results) {
            System.out.println(result);
        }
    }

    // Time Complexity
    // dChars.length = N
    // Better than O(N * N!), Slower than O(N!)
    private static List<List<Character>> getCombinations(char[] dChars) {
        List<List<Character>> combinations = new LinkedList<>();

        List<Character> dCharList = new ArrayList<>();
        for (Character dChar : dChars) {
            dCharList.add(dChar);
        }

        int n = dChars.length;
        backtrackForCreateCombinations(n, dCharList, combinations, 0);

        return combinations;
    }

    private static void backtrackForCreateCombinations(
            int n, List<Character> chars, List<List<Character>> combinations, int first
    ) {
        if (first == n) {
            combinations.add(new ArrayList<>(chars));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(chars, first, i);

            backtrackForCreateCombinations(n, chars, combinations, first + 1);

            Collections.swap(chars, first, i);
        }
    }
}
