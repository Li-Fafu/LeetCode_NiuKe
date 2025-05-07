/**
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。
 * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[] ret;
    int[] index;
    int[] tmpIndex;
    int[] tmpNums;
    public List<Integer> countSmaller(int[] nums) {
        ret = new int[nums.length];
        index = new int[nums.length];
        tmpIndex = new int[nums.length];
        tmpNums = new int[nums.length];
        
        //初始化索引数组
        for(int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        
        mergeSort(nums, 0, nums.length - 1);
        
        List<Integer> res = new ArrayList<>();
        for(int x : ret){
            res.add(x);
        }
        return res;
    }
    
    private void mergeSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        
        int mid = left + (right - left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        
        int curleft = left, curright = mid + 1, i = 0;
        
        while(curleft <= mid && curright <= right){
            
            if(nums[curleft] <= nums[curright]){
                tmpNums[i] = nums[curright];
                tmpIndex[i++] = index[curright++];
            } else {
                ret[index[curleft]] += right - curright + 1;
                tmpNums[i] = nums[curleft];
                tmpIndex[i++] = index[curleft++];
            }
        }
        
        while(curleft <= mid){
            tmpNums[i] = nums[curleft];
            tmpIndex[i++] = index[curleft++];
        }
        while(curright <= right){
            tmpNums[i] = nums[curright];
            tmpIndex[i++] = index[curright++];
        }
        
        
        for(int j = left; j <= right; j++){
            nums[j] = tmpNums[j - left];
            index[j] = tmpIndex[j - left];
        }
    }
}
