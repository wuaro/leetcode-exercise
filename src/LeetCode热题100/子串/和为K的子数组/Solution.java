package LeetCode热题100.子串.和为K的子数组;

import java.util.HashMap;

/*
560. 和为 K 的子数组
中等
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。

示例 1：
输入：nums = [1,1,1], k = 2
输出：2

示例 2：
输入：nums = [1,2,3], k = 3
输出：2

提示：
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */
public class Solution {
    //方法一：暴力（暴力就别写了）
    /**
     * 方法二：pre数组+哈希表（妙极妙极妙极！）
     * 通过暴力枚举来计算每个子数组的和，这种方法实在太笨了
     * 1.可以维护一个pre数组（一层for循环解决），pre[i]记录nums[i]前面所有数字的和（不包括自己），如果需要nums[i~j]的和可以通过pre[j]-pre[i]来获得
     * 所以如果要找和为k的子数组，只需要找到一组pre[j]-pre[i]=k,即可证明nums[i ~ j-1]之和为k
     *  也就是对于j结尾的数组，需要找到一个i使得pre[j+1]-k=pre[i]
     * 那么对于确定的j，如何找到对应的i？
     *  其实压根不需要找i，只需要记录下在j之前有多少个pre[i]=pre[j+1]-k即可
     *  也就是把之前的每一个pre[i]都记录在表里，到时候进去找即可，比如pre[i]==7出现了3次，就如实记录在表中（哈希表最合适）
     * 2.维护一个HashMap<Integer,Integer>来存储和读取，可以在o(1)时间内解决
     * 3.由于我们在for循环生成pre数组时，顺便就可以往HashMap中存储，所以其实pre数组已经不需要了，只需要一个pre变量即可（妙啊！）
     */
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>(){};
        int count = 0;
        /*
           首先在i=0的元素之前没有元素，所以和为0，
           也就是后面考虑以j结尾的子数组时，可以在表中找到，在此之前存在一个nums[0~i]的和为0的数组(i是多少其实根本就无所谓，只要是从nums[0]开始的就行)
         */
        mp.put(0,1);
        for (int i = 0,pre = 0; i < nums.length; i++) {
            pre += nums[i];
            System.out.print("i="+i+" pre="+pre+" ");
            if (mp.containsKey(pre-k)){
                count += mp.get(pre-k);
                System.out.print("找到子数组，count值升为"+count);
            }
            if (mp.containsKey(pre)){
                mp.put(pre,mp.get(pre)+1);
                System.out.print("pre="+pre+"++");
            }else{
                mp.put(pre,1);
                System.out.print("存入pre="+pre);
            }
            System.out.println();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3},3));
    }

}
