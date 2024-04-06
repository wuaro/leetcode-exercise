package LeetCode热题100.双指针.两数之和;

/**
 * 给出一个数组，和一个target，返回 和为target的两数下标
 *
 * 暴力、哈希、双指针
 */



import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while (i < j){
            if (nums[i]+nums[j]>target){
                j--;
            } else if (nums[i]+nums[j]<target) {
                i++;
            }else {
                i = nums[i];
                j = nums[j];
                break;
            }
        }
        int[] result = new int[2];
        for (int k = 0; k < n.length; k++) {
            if(i == n[k]) {
                result[0] = k; break;
            }
        }
        for (int k = n.length-1; k > 0; k--) {
            if (j == n[k]) {
                result[1] = k; break;
            }
        }
        return result;
    }
}
