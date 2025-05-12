/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 * 解法一：暴力解法
 * 时间复杂度：N*N
 *
 * 解法二：利用哈希表
 * 时间复杂度：N
 */

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hash.containsKey(target-nums[i])){
                ret[0] = i;
                ret[1] = hash.get(target-nums[i]);
                break;
            }else {
                hash.put(nums[i], i);
            }
        }
        return ret;
    }
}
