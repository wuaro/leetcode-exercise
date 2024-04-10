package 分类刷题.二分法.搜索插入位置;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        int mid = (left+right)/2;

        while (left < right){
            if (nums[mid] < target){
                left = mid+1;
            }else if (nums[mid] > target){
                right = mid-1;
            }else {
                return mid;
            }
            mid = (left+right)/2;
            if (left+1==right && nums[left]!=target){
                return left+1;
            }
        }
        return 0;
    }
}
