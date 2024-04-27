package 分类刷题.滑动窗口.长度最小的子数组;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0 || nums.length == 1 && nums[0]<target) return 0;
        int left = 0;
        int right = 0;
        int end = nums.length-1;
        int sum = nums[0];
        int min_length = nums.length+1;   //最长就是nums.length

        do {
            if (sum < target){
                //右端点右移，滑动窗口扩大
                right++;
                sum += nums[right];
            }else {
                //左端点右移，滑动窗口缩小
                sum -= nums[left];
                left++;
            }
            if (sum >= target){
                min_length = (right-left+1)<min_length ? right-left+1 : min_length;
            }
            System.out.println("sum="+sum);
        }while (right < end && left <= right);

        if (right==end){
            while (sum >= target){
                //左端点右移，滑动窗口缩小
                sum -= nums[left];
                left++;
            }
            if (sum >= target){
                min_length = (right-left+1)<min_length ? right-left+1 : min_length;
            }
        }

        return min_length==nums.length+1 ? 0 : min_length;
    }
}
