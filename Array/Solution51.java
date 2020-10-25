/*
面试题51：数组中的逆序对
*/

public class Solution51 {
    public int InversePairs(int [] array) {
        if(array.length <= 1){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i = 0; i < array.length; i++){
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count % 1000000007;
    }
    
    private int InversePairsCore(int[] array, int[] copy, int start, int end){
        if(start == end){
            copy[start] = array[start];
            return 0;
        }
        
        int middle = start + (end - start) / 2;
        int left = InversePairsCore(copy, array, start, middle);
        int right = InversePairsCore(copy, array, middle + 1, end);
        
        int i = middle, j = end;
        int copyIndex = end;
        int count = 0;
        while(i >= start && j >= middle + 1){
            if(array[i] > array[j]){
                copy[copyIndex--] = array[i--];
                count += (j - middle);
                count = count % 1000000007;
            }
            else{
                copy[copyIndex--] = array[j--];
            }
        }
        for(; i >= start; i--){
            copy[copyIndex--] = array[i];
        }
        for(; j >= middle + 1; j--){
            copy[copyIndex--] = array[j];
        }
        return (count + left + right) % 1000000007;
    }
}