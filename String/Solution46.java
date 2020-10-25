/*
面试题46：把数字翻译成字符串
*/

class Solution46 {
	
	// 递归解法
    public int translateNum1(int num) {
        if(num <= 9){
            return 1;
        }
        int ba = num % 100;  // 后两位
        if(ba < 10 || ba > 25){
            return translateNum(num / 10);
        }
        else{
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }
	
	
	// 非递归解法
	public int translateNum2(int num) {
        if(num < 0){
            return 0;
        }
        String numStr = num + "";
        
        int[] counts = new int[numStr.length()];
        for(int i = numStr.length() - 1; i >= 0; i--){
            int count;
            if(i < numStr.length() - 1){
                count = counts[i + 1];
                int digits1 = numStr.charAt(i) - '0';      // 本位
                int digits2 = numStr.charAt(i + 1) - '0';  // 后一位
                int temp = digits1 * 10 + digits2;
                if(temp >= 10 && temp <= 25){  // 此时本位和后一位组成的数字可以合并翻译
                    if(i < numStr.length() - 2){
                        count += counts[i + 2];
                    }
                    else{
                        count += 1;
                    }
                }
            }
            else{
                count = 1;
            }
            counts[i] = count;
        }
        return counts[0];
    }
}