/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for(String s : strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            if(!hash.containsKey(key)){
                hash.put(key,new ArrayList());
            }
            hash.get(key).add(s);
        }
        return new ArrayList<>(hash.values());
    }
}
