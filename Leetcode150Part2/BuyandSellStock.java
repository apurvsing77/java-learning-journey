package Leetcode150Part2;

public class BuyandSellStock {
    public static void main(String[] args) {
        int[] price = {7, 2, 5, 6,1, 4, 3};   //[1,2,3,4,5]
        System.out.println(maxProfit(price));
    }
//    static  int maxProfit(int[] arr){
//        int buy_price=arr[0], current_profit=0,max_profit=0;
//        for (int i = 1; i < arr.length ; i++) {
//            buy_price =(buy_price > arr[i]? arr[i] :buy_price );
//            current_profit = Math.max(arr[i]-buy_price,current_profit);
//            max_profit = max_profit>current_profit? max_profit:current_profit;
//        }
//        System.out.println("buying price : "+buy_price+"\nSelling Price : "+current_profit);
//        return max_profit;
//    }


        public static int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;

            for (int price : prices) {
                // If current price is lower than the min we've seen so far, update it
                if (price < minPrice) {
                    minPrice = price;
                } else {
                    // Calculate profit and update maxProfit if it's higher
                    int profit = price - minPrice;
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }

            return maxProfit;
        }


}
