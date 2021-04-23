package easy.interview.strings;

public class ReverseString {

    public static void main(String[] args) {
        new ReverseString().reverseString(new char[]{'h','e','l','l','o'});
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            int changeIndex = s.length - i - 1;
            char temp = s[i];
            s[i] = s[changeIndex];
            s[changeIndex] = temp;
        }
    }

}
