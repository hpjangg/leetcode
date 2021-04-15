package easy.interview.array;

public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock2().maxProfit(new int[]{7,1,5,3,6,4});
    }

    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {
                result += prices[i+1]-prices[i];
            }
        }

        return result;
    }

}
