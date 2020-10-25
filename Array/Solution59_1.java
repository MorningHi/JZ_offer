/*
面试题59_1：滑动窗口的最大值
*/
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution59_1 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num.length < size || size <= 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Integer> queue = new LinkedList<Integer>();  // 双向队列
        for(int i = 0; i < size; i++){
            while(!queue.isEmpty() && num[queue.peekFirst()] < num[i]){
                queue.pollFirst();
            }
            queue.offer(i);
        }
        for(int i = size; i < num.length; i++){
            list.add(num[queue.peekFirst()]);
            while(!queue.isEmpty() && num[queue.peekLast()] <= num[i]){
                queue.pollLast();
            }
            if(!queue.isEmpty() && queue.peekFirst() <= i - size){ // 移除队列中已经不在当前滑动窗口中的下标
                queue.pollFirst();
            }
            queue.offer(i);
        }
        list.add(num[queue.peekFirst()]);
        return list;
    }
}