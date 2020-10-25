/*
面试题16：数值的整数次方
关键：二分思想(考虑大数问题)
*/
public class Solution16 
	
	//递归解法
    public double Power(double base, int exponent) {
        if(Math.abs(base - 0.0) < 1e-8){  //底数为0的情况
            return 0;
        }
        double result = myPower(base, exponent);
        //最后根据指数的正负返回result或其相反数
        return exponent < 0 ? 1.0 / result : result;
    }
    private double myPower(double base, int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        double result = myPower(base, exponent / 2);
        result *= result;
        if((exponent & 0x01) == 1){  //指数为奇数
            result *= base;
        }
        return result;
    }
	
	// 非递归解法，发现时间和内存使用和递归解法基本一样
	public double Power2(double base, int exponent) {
        if(Math.abs(base - 0.0) < 1e-8){  //底数为0的情况
            return 0;
        }
        double result = 1.0;
        boolean flag = false;  //指数是否为负数的标志
        if(exponent < 0){
            flag = true;
        }
        while(exponent != 0){
            if((exponent & 0x01) == 1){
                result *= base;
            }
            base *= base;
            exponent /= 2;
        }
        return flag ? 1.0/result : result;
    }
}