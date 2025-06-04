package LeetCode150;
//121. Best Time to Buy and Sell Stock
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
public class BuyandSellStock {
    public static void main(String[] args) {
    //int[]  arr ={7,1,5,3,6,4};
    int[] arr ={7,6,4,3,1};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
      int buying_price=prices[0],current_profit = 0,max_profit=0;
        for (int i = 1; i <prices.length ; i++) {
            buying_price = (buying_price > prices[i]) ? prices[i] :buying_price;
            current_profit = Math.max(current_profit , prices[i] - buying_price);
            max_profit = (current_profit >max_profit) ? current_profit : max_profit;
        }
        return max_profit;
    }
}
