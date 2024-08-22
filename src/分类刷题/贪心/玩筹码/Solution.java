package 分类刷题.贪心.玩筹码;

public class Solution {
    public int minCostToMoveChips(int[] position) {
        if (position.length == 1) return 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i]%2 == 0){
                count1++;
            }else if (position[i]%2==1){
                count2++;
            }
        }
        return Math.min(count1,count2);
    }
}
