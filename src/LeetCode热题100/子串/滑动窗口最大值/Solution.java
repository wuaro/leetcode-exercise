package LeetCode热题100.子串.滑动窗口最大值;

import java.util.Arrays;

public class Solution {
    /*
    239. 滑动窗口最大值
    困难
    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    返回 滑动窗口中的最大值 。

    示例 1：
    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    输出：[3,3,5,5,6,7]
    解释：
    滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

    示例 2：
    输入：nums = [1], k = 1
    输出：[1]

    提示：
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    1 <= k <= nums.length
     */


    /**
     * 方法一：
     * 其实最初写的一版，用例都快过完了，但是还是超时了，因为遇到一个k=50000并且窗口中数字都差不多大的实例
     * 我写的方法中如果max被排出去了需要一个for循环“从左到右”遍历找到新的max，
     *  但如果出现有 很多值都==max的情况，从左到右遍历会找出最左端的max，
     *  这样它又会被很早排出去，从而又要重新遍历来寻找新的max，变相增加了很多时间成本
     * 所以应该“从右往左”找，找到最右边的max，这样它会更晚被排出去
     *
     * 改完之后就过了！
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = nums[k-1];
        int max_index = k-1;
        int[] array = new int[nums.length-k+1];
        for (int i = k-1; i >= 0; i--) {       //找到最开始滑动窗口内的 最大值和坐标（如果有一样最大的，留最左边的）
            if(nums[i] > max){
                max = nums[i];
                max_index = i;
            }
        }
        for (int i = 0; i < nums.length-k+1; i++) {
            if (i > 0){
                if (nums[i+k-1] >= max){                    //如果从右边进来一个更大的，则直接替换掉最大值和坐标
                    max = nums[i+k-1];
                    max_index = i+k-1;
                }else {                                     //如果没进来更大的，则要考虑此次右移是否把最大值排出去了
                    if (i-1 == max_index){
                        max = nums[i+k-1];
                        max_index = i+k-1;
//                        for (int j = i; j < i+k; j++) {       //如果最大的被排出去了，就重新寻找最大的
//                            if(nums[j] > max){
//                                max = nums[j];
//                                max_index = j;
//                            }
//                        }
                        for (int j = i+k-1; j >= i; j--) {       //如果最大的被排出去了，就重新寻找最大的（找尽量靠右的，能更晚被排出去）
                            if(nums[j] > max){
                                max = nums[j];
                                max_index = j;
                            }
                        }
                    }
                }
            }
            array[i] = max;
        }
        return array;
    }

}
