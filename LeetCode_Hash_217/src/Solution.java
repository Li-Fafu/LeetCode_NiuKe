/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，
 * 返回 true ；如果数组中每个元素互不相同，返回 false 。
 */

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet();
        for(int x : nums){
            if(hash.contains(x)){
                return true;
            }
            hash.add(x);
        }
        return false;
    }
}
