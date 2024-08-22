package 分类刷题.动态规划.斐波那契类型.删除并获得点数;

import java.util.HashMap;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int earn = 0;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsValue(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }

        Integer count_earn[] = new Integer[10000];
        for (Integer i = 0; i < 10000; i++) {
            if (count.containsValue(i)) {
                count_earn[i] += i * count.get(i);
            }
        }

        if (count_earn[0] > count_earn[1]) count_earn[1] = count_earn[0];

        for (int i = 2; i < count_earn.length; i++) {
            count_earn[i] = Math.max(count_earn[i - 2] + count_earn[i], count_earn[i - 1]);
        }
        return count_earn[count_earn.length - 1];

    }
}
