/**
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 *
 * MedianFinder() 初始化 MedianFinder 对象。
 *
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 *
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 */

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    
    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a,b) -> b - a);
        rightHeap = new PriorityQueue<>((a,b) -> a - b);
    }
    
    public void addNum(int num) {
        if(leftHeap.size() == rightHeap.size()) {
            if(leftHeap.isEmpty() || num <= leftHeap.peek()) {
                leftHeap.offer(num);
            } else {
                rightHeap.offer(num);
                leftHeap.offer(rightHeap.poll());
            }
        } else {
            if(num <= leftHeap.peek()) {
                leftHeap.offer(num);
                rightHeap.offer(leftHeap.poll());
            } else {
                rightHeap.offer(num);
            }
        }
    }
    
    public double findMedian() {
//        if(leftHeap.size() == rightHeap.size()) {
//            return Math.round((leftHeap.peek() + rightHeap.peek()) * 5.0) / 10.0;
//        } else {
//            return Math.round(leftHeap.peek() * 10) / 10.0;
//        }
        if(leftHeap.size() == rightHeap.size()) {
            return (leftHeap.peek() + rightHeap.peek())/2.0;
        } else {
            return leftHeap.peek();
        }
    }
    
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */