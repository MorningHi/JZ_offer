/*
面试题41：数据流的中位数
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Solution41 {
    // 利用优先队列构造大顶堆,堆的大小为k
    // 需要制定自定义的比较器，按照从大到小顺序排序
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2){
            return o2.compareTo(o1);
        }
    });
    // 构建最小堆，默认比较器排序即可
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public void Insert(Integer num) {
        // 确保两个堆中的数据数目之差不大于1
        if(((minHeap.size() + maxHeap.size()) & 0x01) == 0){ // 总数为偶数时向最小堆中插入元素
            // 如果这个数字比最大堆的堆顶数字还要小,则将这个数插入最大堆，并且把最大堆堆顶数字放入最小堆
            if(maxHeap.size() > 0 && num < maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
        else{
            // 向最大堆添加元素时发现元素比最小堆的堆顶元素还大，则先添加到最小堆，并且将最小堆的堆顶元素移动到最大堆
            if(minHeap.size() > 0 && num > minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        int size = minHeap.si
            ze() + maxHeap.size();
        
        double mid = 0;
        if((size & 1) == 1){ // 数字总数为奇数
            mid = minHeap.peek();
        }
        else{
            mid = (double)(minHeap.peek() + maxHeap.peek()) / 2;
        }
        return mid;
    }
}