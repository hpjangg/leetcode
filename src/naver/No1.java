package naver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1 {

    public static void main(String[] args) {

        // 240
        new No1().solution(new int[]{100,100,100}, new String[]{"2020-12-31","2020-12-22","2020-12-03"});

        // 25
        new No1().solution(new int[]{180,-50,-25,-25}, new String[]{"2020-01-01","2020-01-01","2020-01-01","2020-01-31"});

        // -164
        new No1().solution(new int[]{1,-1,0,-105,1}, new String[]{"2020-12-31","2020-04-04","2020-04-04","2020-04-14","2020-07-12"});

        // 80
        new No1().solution(new int[]{100,100,-10,-20,-30}, new String[]{"2020-01-01","2020-02-01","2020-02-11","2020-02-05","2020-02-08"});
    }

    private static final int FEES_AMOUNT = 5;
    private static final int ALL_FEES_AMOUNT = FEES_AMOUNT * 12;

    public int solution(int[] A, String[] D) {
        int sum = Arrays.stream(A).sum() - ALL_FEES_AMOUNT; // 수입 - 지출 - 카드수수료

        Map<String, PayInfo> monthPayInfo = getMonthPayAndCount(A, D); // 월별 카드 결제 금액 합계와 결제 횟수

        for (PayInfo payInfo: monthPayInfo.values()) {
            if (payInfo.isExempt()) { // 해당 월이 카드 수수료 면제라면
                sum += FEES_AMOUNT;
            }
        }

        return sum;
    }

    /**
     * 월별 결제 금액 합계와 결제 횟수
     */
    private Map<String, PayInfo> getMonthPayAndCount(int[] A, String[] D) {
        Map<String, PayInfo> monthPayInfo = new HashMap<>();
        for (int i = 0; i < D.length; i++) {
            if (A[i] < 0) { // 카드 결제인 경우
                String yearMonth = D[i].substring(0,7);
                addPayAmount(monthPayInfo, yearMonth, A[i]);
            }
        }
        return monthPayInfo;
    }

    /**
     * 특정 달에 결제 금액과 횟수 카운트
     */
    private void addPayAmount(Map<String, PayInfo> monthPayInfo, String yearMonth, int pay) {
        if (!monthPayInfo.containsKey(yearMonth)) {
            monthPayInfo.put(yearMonth, new PayInfo(pay));
        } else {
            monthPayInfo.get(yearMonth).addAmount(pay);
        }
    }

}

class PayInfo {
    private static final int EXEMPT_FEES = -100;
    private static final int EXEMPT_PAY_COUNT = 3;

    private int amount;
    private int count = 1;

    PayInfo(int amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
        this.count++;
    }

    public boolean isExempt() {
        return isExemptFees() && isExemptPayCount();
    }

    private boolean isExemptFees() {
        return this.amount <= EXEMPT_FEES;
    }

    private boolean isExemptPayCount() {
        return this.count >= EXEMPT_PAY_COUNT;
    }
}
