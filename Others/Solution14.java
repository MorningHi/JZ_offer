/*
面试题14：剪绳子
*/

public class Solution14 {
	
	// 动态规划法：f(n) = max(f(i)*f(n-i))
    public int cutRope1(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        
        int[] products = new int[target + 1];
        for(int i = 0; i <= 3; i++){
            products[i] = i;
        }
        int max; // max记录长度为target时不同裁剪方式最大乘积
        for(int i = 4; i <= target; i++){
            max = 0;
            for(int j = 1; j <= i/2; j++){  // 遍历所有的裁剪方式，更新max
                int product = products[j] * products[i - j];
                if(product > max){
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[target];
	}
		
	// 贪婪算法：尽可能多地剪长度为3的绳子	
	public int cutRope2(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        
        int numThree = target / 3;
        // 剪完3后剩余长度为1，由于3*1<2*2，因此少剪一段3
        if(target - numThree * 3 == 1){
            numThree--;
        }
        int numTwo = (target - numThree * 3) / 2;
        return (int)(Math.pow(3, numThree) * Math.pow(2, numTwo));
    }
}