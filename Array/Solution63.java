/*
面试题63：股票的最大利润
*/

class Solution63 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }

        int maxProf = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            min = min < prices[i] ? min : prices[i];
            int currProf = prices[i] - min;
            maxProf = currProf > maxProf ? currProf : maxProf;
        }
        return maxProf;
    }
}