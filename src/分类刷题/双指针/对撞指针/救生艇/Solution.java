package 分类刷题.双指针.对撞指针.救生艇;


import java.util.Arrays;

/**
 * 对撞指针
 *  1. 从小到大排序，两个指针一头一尾（分别指向当前最轻和最重的人）
 *  2. 如果 最轻+最重>limit 则只让最重上船
 *  3. 如果 最轻+最重<=limit 则俩人一起上船
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 0 || people.length == 1){
            return people.length;
        }
        Arrays.sort(people);
        int l = 0;
        int r = people.length-1;
        int boat_num = 0;
        while (l < r){
            if (people[l] + people[r] <= limit){
                boat_num++;
                l++;
                r--;
            }else {
                boat_num++;
                r--;
            }
        }
        if (l == r) boat_num++;
        return boat_num;
    }
}
