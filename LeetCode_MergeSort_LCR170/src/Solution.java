/**
 *在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。
 * 请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 */
public class Solution {
    int[] tmp;
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int left, int right) {
        if(left >= right){
            return 0;
        }
        
        int ret = 0;
        int mid = left + (right - left)/2;
        
        ret += mergeSort(nums, left, mid);
        ret += mergeSort(nums, mid + 1, right);
        
        int curleft = left, curright = mid + 1, i = 0;
        
        while(curleft <= mid && curright <= right) {
            if(nums[curleft] <= nums[curright]) {
                tmp[i++] = nums[curleft++];
            } else {
                ret += mid - curleft + 1;
                tmp[i++] = nums[curright++];
            }
        }
        
        while(curleft <= mid) tmp[i++] = nums[curleft++];
        while(curright <= right) tmp[i++] = nums[curright++];
        
        for(int j = left; j <= right ; j++) {
            nums[j] = tmp[j - left];
        }
        return ret;
    }
}
