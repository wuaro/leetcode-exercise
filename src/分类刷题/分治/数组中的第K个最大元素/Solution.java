package 分类刷题.分治.数组中的第K个最大元素;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20002];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]+10001]++;
        }
        for (int i = count.length-1; i > 0 && k > 0; i--) {
            k -= count[i];
            if (k <= 0){
                return i-10001;
            }
        }
        return 0;
    }
}
