package line.pretest.reverse;

public class ReverseString {

    public static void main(String[] args) {
        new ReverseString().getReversedString("abcdefg");
    }

    public String getReversedString(String input) {
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder(chars.length);
        for (int i = chars.length-1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

}
