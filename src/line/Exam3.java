package exam.cm.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Exam3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputNotValidAddress = sc.nextLine();

        convertValidAddress(inputNotValidAddress)
                .stream()
                .sorted((o1, o2) -> {
                    String o1DelimiterSplit[] = o1.split("\\.");
                    String o2DelimiterSplit[] = o2.split("\\.");

                    int sorted = -1;
                    for (int i = 0; i < o1DelimiterSplit.length; i++) {
                        sorted = o1DelimiterSplit[i].compareTo(o2DelimiterSplit[i]);
                        if(sorted == 0) break;
                    }
                    return sorted;
                })
                .forEach(System.out::println);

    }


    private static ArrayList<String> convertValidAddress(String notValidAddress) {
        int size = notValidAddress.length();

        String temp = notValidAddress;

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    temp = makeAddDelimiter(temp, k);
                    temp = makeAddDelimiter(temp, j);
                    temp = makeAddDelimiter(temp, i);

                    boolean isRange = true;
                    if(Pattern.matches("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])([.](?!$)|$)){4}", temp)){
                        list.add(temp);
                    }
                    temp = notValidAddress;
                }
            }
        }
        return list;
    }

    private static String makeAddDelimiter(String temp, int index){
        return temp.substring(0, index) + "." + temp.substring(index);
    }

}