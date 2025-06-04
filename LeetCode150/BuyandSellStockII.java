package LeetCode150;

public class BuyandSellStockII {
    public static void main(String[] args) {
       //int[]  arr ={7,1,5,3,6,4};
        int[] arr ={7,6,4,3,1};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
      int profit = 0;
        for (int i= 1; i <prices.length ; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);

            }
        }
        return profit;
    }
}
