package Leetcode150Part2;

public class BuyandSellStockII {

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 6,2, 4, 3};   //[1,2,3,4,5] 7, 2, 5, 6,1, 4, 3
        System.out.println(maxProfit(price));
    }

   static  int maxProfit(int[] price){

        int profit = 0;
       for (int i = 1; i < price.length ; i++) {
           if (price[i] >price[i-1])
               profit +=(price[i]-price[i-1]);
       }
        return profit;
   }
}
