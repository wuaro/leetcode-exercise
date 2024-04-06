package LeetCode热题100.哈希.两数之和;

/*
1. 两数之和(简单)
提示
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]

提示：
2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
只会存在一个有效答案

 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */


import java.util.HashMap;

public class Main {

    //最笨的暴力算法，两层循环解决问题，不优
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(nums[i] + nums[j] == target) return new int[]{i,j};
            }
        }
        return new int[]{0,0};
    }

    /*
    利用哈希表来减少一层循环：
    1. 把数组第一个元素装进hashmap
    2. 后面每一个元素都判断一下，是否能与hashmap中的元素配对，如果不能则存入hashmap
        这里由于hashmap可以以o(1)的时间复杂度来查找，所以会省掉一层循环
    3. 当找到配对的元素时，返回数组
     */
    public static int[] twoSum1(int[] nums, int target) {
        int l = nums.length;
        //这里设置hashmap容量是为了防止hashmap不断自动扩容，浪费时间。容量写l-1就行（因为一定会找到一对！）
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(l-1);
        hm.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            //如果hashmap中有与之匹配的值，则直接返回对应的数组
            if(hm.containsKey(target-nums[i])) return new int[]{i,hm.get(target-nums[i])} ;
            hm.put(nums[i],i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,7,11,15};
        for (int b:twoSum1(a, 9)){
            System.out.println(b);
        }
    }
}
