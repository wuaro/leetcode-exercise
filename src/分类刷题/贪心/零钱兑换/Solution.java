package 分类刷题.贪心.零钱兑换;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        Collections.reverse(Arrays.asList(coins));
        int residual_money = amount;
        
        return 0;
    }
}
