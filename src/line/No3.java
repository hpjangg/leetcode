package line;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        List<String> resultList = new ArrayList<>();

        String ip = input;

        for (int i = 1; i < input.length() - 2; i++) {
            for (int j = i + 1; j < input.length() - 1; j++) {
                for (int k = j + 1; k < input.length(); k++) {
                    ip = ip.substring(0, k) + "." + ip.substring(k);
                    ip = ip.substring(0, j) + "." + ip.substring(j);
                    ip = ip.substring(0, i) + "." + ip.substring(i);

                    if (isValidIp(ip)) {
                        resultList.add(ip);
                    }
                    ip = input;
                }
            }
        }

        resultList.sort((o1, o2) -> {
            String[] a1 = o1.split("[.]");
            String[] a2 = o2.split("[.]");

            int result = -1;
            for (int i = 0; i < 4 && result != 0; i++) {
                result = a1[i].compareTo(a2[i]);
            }
            return result;
        });

        System.out.println(resultList.size());
        for (String result: resultList) {
            System.out.println(result);
        }
    }

    private static boolean isValidIp(String ip) {
        String[] segments = ip.split("[.]");
        for (String segment: segments) {
            int segI = Integer.parseInt(segment);
            if (segment.length() > 3 || segI < 0 || segI > 255) {
                return false;
            }
            if (segment.length() > 1 && segI == 0){
                return false;
            }
            if (segment.length() > 1 && segment.charAt(0) == '0') {
                return false;
            }
        }

        return true;
    }
}
