/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 */
public class Solution {
    
    int[] tmp;
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        return mergeSort(nums,0,nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int left, int right) {
        if(left >= right){
            return 0;
        }
        int ret = 0;
        int mid = left + (right - left)/2;
        
        ret += mergeSort(nums,left,mid);
        ret += mergeSort(nums,mid + 1,right);
        
        int curleft = left, curright = mid + 1, i = 0;
        
        while(curleft <= mid){
            while(curright <= right && nums[curright] >= nums[curleft]/2.0){
                curright++;
            }
            if(curright > right){
                break;
            }
            ret += right - curright + 1;
            curleft++;
        }
        
        curleft = left;
        curright = mid + 1;
        
        while(curleft <= mid && curright <= right){
            if(nums[curleft] <= nums[curright]){
                tmp[i++] = nums[curright++];
            } else {
                tmp[i++] = nums[curleft++];
            }
        }
        while(curleft <= mid){
            tmp[i++] = nums[curleft++];
        }
        while(curright <= right){
            tmp[i++] = nums[curright++];
        }
        
        
        for(int j = left; j <= right ; j++) {
            nums[j] = tmp[j - left];
        }
        return ret;
    }
}
