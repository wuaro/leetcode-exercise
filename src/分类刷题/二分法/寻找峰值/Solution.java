package 分类刷题.二分法.寻找峰值;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return 0;
        }

        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        while (left <= right){
            if (left==right && right==nums.length-1){
                return nums[nums.length-1];
            }else if (left==right && left==0){
                return nums[0];
            }
            if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }

            if (nums[mid] > nums[mid-1]){
                left = mid+1;
            }else if (nums[mid] < nums[mid-1]){
                right = mid-1;
            }



            mid = (left+right)/2;
        }
        return -1;
    }
}
