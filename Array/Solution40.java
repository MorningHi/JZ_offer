/*
面试题40：最小的k个数
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Solution40 {
	
	//1. 基于快速排序Partion思想的解法
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        if(k <= 0 || input.length < k){
            return new ArrayList();
        }
        ArrayList<Integer> list = new ArrayList();
        int lo = 0, hi = input.length - 1;
        int index = Partion(input, lo, hi);
        while(index != k - 1){
            if(index > k - 1){
                hi = index - 1;
                index = Partion(input, lo, hi);
            }
            else{
                lo = index + 1;
                index = Partion(input, lo, hi);
            }
        }
        for(int i = 0; i <= index; i++){
            list.add(input[i]);
        }
        return list;
    }
    
    private int Partion(int[] input, int lo, int hi){
        int index = (int)Math.random() * (hi - lo) +  lo;  // 随机生成分割点
        int small = lo - 1;
        swap(input, hi, index);   // 分割数字先放到数组末尾
        // 所有比分割数字小的数前移
        for(index = lo; index < hi; index++){
            if(input[index] < input[hi]){
                small++;
                if(small != index){
                    swap(input, index, small);
                }
            }
        }
        small++;  // 最后将分割数字交换到分割点
        swap(input, small, hi);
        return small;
    }
    
    private void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
	



	//2. 利用java优先队列的解法，优先队列是基于堆实现的
	public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        if(k <= 0 || input.length < k){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        // 利用优先队列构造大顶堆,堆的大小为k
        // 需要制定自定义的比较器，按照从大到小顺序排序
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
        	public int compare(Integer o1, Integer o2){
        		return o2.compareTo(o1);
        	}
		});  
        for(int i = 0; i < input.length; i++){
        	if(maxHeap.size() < k){    // 先向将堆填满
        		maxHeap.offer(input[i]);
        	}
        	// 接下来用数组中较小的元素替代堆顶元素
        	else if(input[i] < maxHeap.peek()){
        		maxHeap.poll();
        		maxHeap.offer(input[i]);
        	}
        }
        
        for(int i: maxHeap){
            list.add(i);
        }
        return list;
    }
	
}