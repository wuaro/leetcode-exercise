package LeetCode热题100.哈希.最长连续序列;

import java.util.HashMap;

/*
128. 最长连续序列

给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

示例 1：
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

示例 2：
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9

提示：
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
 */
class Solution {
    //方法一：完全使用数组来空间换时间（不可取，那会消耗太多内存）
    //方法二：利用哈希表存储，遍历所有-10^9 <= nums[i] <= 10^9范围内的数（不可取，会超时）
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> ibhm = new HashMap<>();
        int max = 0;
        int length = 0;
        Boolean flag = false;
        for (int a:nums) {
            ibhm.put(a, true);
        }
        for (int i = (int) -Math.pow(10,9); i < (int) Math.pow(10,9); i++) {
            if (flag){
                if (!ibhm.containsKey(i)){
                    if (length > max) max = length;
                    length = 0;
                    flag = false;
                }else {
                    length++;
                }
            }else {
                if (!ibhm.containsKey(i)){
                    continue;
                }else {
                    flag = true;
                    length++;
                }
            }
        }
        return max;
    }

    /*
    题目要求使用o(n)，n指的是传进来的数组长度，即：0 <= nums.length <= 10^5
    方法三：全部存入HashMap，遍历每个元素a时，判断a+1,a+2...是否在HashMap中
    但是这种方法也需要套两层循环，极端情况下也会达到o(n^2)
     */
    public static int longestConsecutive1(int[] nums) {
        HashMap<Integer, Boolean> ibhm = new HashMap<>();
        int max = 0;

        for (int a:nums){       //全部存入HashMap
            ibhm.put(a,false);
        }
        for (int i = 0; i < nums.length; i++) {     //遍历每个元素a时，判断a+1,a+2...是否在HashMap中
            int length = 0;
            while (ibhm.containsKey(nums[i]++)){
                length++;
            }
            if(length > max) max = length;
        }
        return max;
    }

    /*
    上述方法也需要套两层循环，极端情况下也会达到o(n^2)
    实际上上述方法进行了很多冗余的判断，实际上我们只需要在一段连续序列的开头开始判断即可
    比如：存在1,2,3,4,5，我们只需要从1开始判断即可，不需要对2、3、4、5进行判断（即：不需要判断数组中所有的元素，要有选择地进行判断）
    //方法四：只在a-1不存在时（a是一段连续序列的开头）才开始判断
    */
    public static int longestConsecutive2(int[] nums) {
        HashMap<Integer, Boolean> ibhm = new HashMap<>();
        int max = 0;

        for (int a:nums){       //全部存入HashMap
            ibhm.put(a,false);
        }
        //遍历每个元素a，在a-1不存在时（a是一段连续序列的开头），判断a+1,a+2...是否在HashMap中
        for (int i = 0; i < nums.length; i++) {
            if(!ibhm.containsKey(nums[i]-1)){
                int length = 0;
                while (ibhm.containsKey(nums[i]++)){
                    length++;
                }
                if(length > max) max = length;
            }else{
                continue;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive1(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
