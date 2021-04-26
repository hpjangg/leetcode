package easy.interview.strings;

public class ReverseInteger {

    public static void main(String[] args) {
//        new ReverseInteger().reverse(-120);
        new ReverseInteger().reverse(1534236469);
    }

    private static final String MINUS = "-";

    public int reverse(int x) {
        String xStr = String.valueOf(x);

        String[] xArr = xStr.split("");

        StringBuilder sb = new StringBuilder();
        for (int i = xArr.length-1; i >= 0; i--) {
            if (xArr[i].equals(MINUS)) {
                sb.insert(0, MINUS);
                break;
            }
            sb.append(xArr[i]);
        }

        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
