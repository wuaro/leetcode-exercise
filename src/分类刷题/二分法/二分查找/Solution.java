package 分类刷题.二分法.二分查找;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;

        while (left <= right){
            if (nums[mid] < target){
                left = mid+1;
            }else if (nums[mid] > target){
                right = mid-1;
            }else {
                return mid;
            }
            mid = (left+right)/2;
        }
        return -1;
    }
}
