/*
面试题59_2：队列的最大值
*/
class MaxQueue {

    private Queue<Integer> data;   // 数据队列
    private Deque<Integer> maxData;  // 最大值队列
    public MaxQueue() {
        data = new LinkedList<Integer>();
        maxData = new LinkedList<Integer>();
    }
    
    public int max_value() {
        return maxData.isEmpty() ? -1 : maxData.peekFirst();
    }
    
    public void push_back(int value) {
        while(!maxData.isEmpty() && value > maxData.peekLast()){
            maxData.pollLast();
        }
        maxData.offer(value);
        data.offer(value);
    }
    
    public int pop_front() {
        if(!maxData.isEmpty() && !data.isEmpty()){
            if((int)maxData.peekFirst() == (int)data.peek()){  // 当前要出队的元素是最大值队列的头部元素
                maxData.pollFirst();                      // 则数据队列和最大值队列同时出队
            }
            return data.poll();                // 否则只用数据队列出队
        }
        return -1;
    }
}
