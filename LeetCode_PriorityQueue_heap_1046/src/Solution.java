import java.util.PriorityQueue;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */


public class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for(int x : stones) {
            heap.add(x);
        }
        while(!heap.isEmpty()) {
            int t1 = heap.poll();
            int t2 = heap.poll();
            if(t1 != t2) {
                heap.add(Math.abs(t1 - t2));
            }
            if(heap.size() == 1) {
                return heap.poll();
            }
        }
        return 0;
    }
    
}
