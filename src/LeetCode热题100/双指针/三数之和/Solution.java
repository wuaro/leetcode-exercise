package LeetCode热题100.双指针.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 三数之和
中等
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。
请你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。

示例 2：
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。

示例 3：
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。


提示：
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

public class Solution {

    /**失败的方法一：
     * 先排序
     * 从1到nums.length-1遍历 三个数中间那个数，然后在左右依次寻找匹配的数（麻烦，而且容易出错）
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int k = 1; k < nums.length-1; k++) {
            if(k>1&&nums[k-2] == nums[k]) {
                System.out.println("k="+k+"时跳过啦");
                continue;      //防止重复
            }
            int i = 0;
            int j = nums.length-1;
            while (i<k && j>k){
                System.out.println();
                if(nums[i] > 0 || nums[j] < 0) break;
                if (nums[i]+nums[j] > -nums[k]){
                    System.out.println("i,k,j="+i+" "+k+" "+j+"执行j--");
                    j--;
                } else if (nums[i]+nums[j] < -nums[k]) {
                    System.out.println("i,k,j="+i+" "+k+" "+j+"执行i++");
                    i++;
                }else if(nums[i]+nums[j] == -nums[k]){
                    System.out.println(i+" "+k+" "+j+" 加入");
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[k]);
                    a.add(nums[j]);
                    result.add(a);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 先排序，然后使i<left<right
     * 遍历每个i，在i的右侧找“和为 -i”的两个数（如果nums[i]==nums[i-1]则跳过）
     * 如果和小于-i则left++，大于-i则right--，等于则记录
     * 找到之后继续找（left++，right--），有可能一个i对应好几组不同的结果
     * 如果left++后和nums[left]和原来一样，则跳过，同理right也是
     * 同理 “找到之后继续找（left++，right--）” 也是
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            int flag = -1;
            while (left < right){
                if ((flag==1||flag==2) && nums[left]==nums[left-1]){       //避免重复
                    left++;
                    continue;
                }else if ((flag==0||flag==2) && nums[right]==nums[right+1]){
                    right--;
                    continue;
                }else {
                    if(nums[left]+nums[right] > -nums[i]){
                        right--; flag = 0;
                    } else if (nums[left]+nums[right] < -nums[i]) {
                        left++; flag = 1;
                    } else {
                        ArrayList<Integer> l = new ArrayList<>();
                        l.add(nums[left]);
                        l.add(nums[i]);
                        l.add(nums[right]);
                        result.add(l);
                        left++; right--;        //继续查找，因为还可能有另外两个数之和等于-nums[i]
                        flag = 2;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum1(new int[]{-4,-1,-1,0,1,2});
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
