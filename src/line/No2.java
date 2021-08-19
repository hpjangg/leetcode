package line;

import java.util.*;

public class No2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] inputs = new int[n][2];
        for (int i = 0; i < n; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            inputs[i] = (Arrays.stream(new int[]{first, second}).sorted().toArray());
        }

        Arrays.sort(inputs, Comparator.comparingInt(o -> o[0]));

        Map<Integer, Set<Integer>> resultMap = new HashMap<>();

        int index = 1;
        Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("start"+index, inputs[0][0]);
        numberMap.put("end"+index, inputs[0][1]);

        boolean isChange;
        for (int i = 1; i < inputs.length; i++) {
            isChange = false;
            if (inputs[i][0] >= numberMap.get("start"+index) && inputs[i][0] <= numberMap.get("end"+index)) {
                if (inputs[i][1] > numberMap.get("end"+index)) {
                    numberMap.put("end"+index, inputs[i][1]);
                }
                isChange = true;
            }

            if (inputs[i][1] <= numberMap.get("end"+index) && inputs[i][1] >= numberMap.get("start"+index)) {
                if (inputs[i][0] < numberMap.get("start"+index)) {
                    numberMap.put("start"+index, inputs[i][0]);
                }
                isChange = true;
            }

            if (!isChange) {
                index++;
                numberMap.put("start"+index, inputs[i][0]);
                numberMap.put("end"+index, inputs[i][1]);
            }
        }

        index = 1;
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i][0] >= numberMap.get("start"+index) && inputs[i][1] <= numberMap.get("end"+index)) {
                numberSet.add(inputs[i][0]);
                numberSet.add(inputs[i][1]);
                resultMap.put(index, numberSet);
            } else {
                numberSet = new HashSet<>();
                i--;
                index++;
            }
        }

        System.out.println(resultMap.size());
    }

}
