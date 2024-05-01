package 分类刷题.回溯.子集;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        result.add(l);
        find(result,nums,l,0,nums.length-1);
        return result;
    }
    /**
     *
     * @param result
     * @param l
     * @param start 当前这一层能从start开始来进行添加）
     */
    public static void find(List<List<Integer>> result,int[] nums,List<Integer> l,int start,int end){
        if (start>end){
            return;
        }
        for (int i = start; i <= end; i++) {

            //复制l给lll,然后在lll后添加nums[i]
            List<Integer> lll = new ArrayList<>();
            for (int i1 = 0; i1 < l.size(); i1++) {
                lll.add(l.get(i1));
                System.out.print(l.get(i1) + " ");
            }
            lll.add(nums[i]);
            result.add(lll);
            System.out.println(nums[i]);
            find(result,nums,lll,i+1,end);
        }
    }
}
