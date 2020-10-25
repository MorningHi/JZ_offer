/*
面试题56：数组中只出现一次的两个数字
*/

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution56 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length <= 1){
            return;
        }
        
        int flag = 0;
        for(int i = 0; i < array.length; i++){
            flag ^= array[i];
        }
        int indexOf1 = findFirst1(flag);  // 找到最低位的1的index
        
        int n1 = 0, n2 = 0;
        for(int i = 0; i < array.length; i++){
            if(isBit1(array[i], indexOf1)){  // 根据当前位是否为1分开求异或
                n1 ^= array[i];
            }
            else{
                n2 ^= array[i];
            }
        }
        num1[0] = n1;
        num2[0] = n2;
    }
    
    private int findFirst1(int num){
        int index = 0;
        while((num & 0x01) == 0){
            num = num >> 1;
            index++;
        }
        return index;
    }
    
    private boolean isBit1(int num, int index){
        while(index-- > 0){
            num = num >> 1;
        }
        return (num & 0x01) == 1;
    }
}