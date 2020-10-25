/*
面试题60：n个骰子的点数
*/

class Solution60 {
    public double[] Probability(int n) {
        if(n < 1){
            return null;
        }
        int maxValue = 6;
        int[][] probs = new int[2][maxValue * n + 1];
        
        int flag = 0;
        for(int i = 1; i <= maxValue; i++){
            probs[flag][i] = 1;
        }
        
        for(int k = 2; k <= n; k++){
            for(int i = 0; i < k; i++){
                probs[1 - flag][i] = 0;
            }
            
            for(int i = k; i <= maxValue * n; i++){
                probs[1 - flag][i] = 0;
                for(int j = 1; j <= i && j <= maxValue; j++){
                    probs[1 - flag][i] += probs[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        
        double[] result = new double[n * maxValue - n + 1];
        double total = Math.pow(maxValue, n);
        for(int i = n; i <= maxValue * n; i++){
            result[i - n] = probs[flag][i] / total;
        }
        return result;
    }
}