package 分类刷题.分治.多数元素;

public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                candidate = nums[i];
            }
            if (candidate == nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }
}
