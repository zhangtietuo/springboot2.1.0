package com.ztt.Arithmetic;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/20 9:17
 */
public class 买卖股票的最佳时机II {


    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int start;
        int end;
        int profit = 0;
        int i = 0;
        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            start = i;

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }

            end = i;
            profit += prices[end] - prices[start];
            i++;
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] numarr = new int[]{2, 4, 7, 1, 5};
        System.out.println(maxProfit(numarr));
    }
}
