/**
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 */

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //建立映射关系，统计出现的次数
        HashMap<String, Integer> hash = new HashMap<>();
        for(String s : words) {
            hash.put(s,hash.getOrDefault(s,0) + 1);
        }
        
        //建立大小为 k 堆
        PriorityQueue<Pair<String, Integer>> heap = new PriorityQueue<>(
                (a,b) -> {
                    if(a.getValue().equals(b.getValue())){
                        //当频次相同时，按照字典顺序排序
                        return b.getKey().compareTo(a.getKey());
                    }
                    //按照频次排序
                    return a.getValue() - b.getValue();
                }
        );
        
        for(Map.Entry<String, Integer> e : hash.entrySet()) {
            heap.add(new Pair<>(e.getKey(), e.getValue()));
            if(heap.size() > k) {
                heap.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while(!heap.isEmpty()) {
            ret.add(heap.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
        
    }
}
