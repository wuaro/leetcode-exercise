package 分类刷题.回溯.组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        find(result,l,n,k,1);
        return result;
    }

    /**
     *
     * @param result
     * @param l
     * @param n 最大的数字就到n
     * @param k 算上当前这一层，二叉树还有k层
     * @param start 当前这一层能从start开始来进行添加）
     */
    public static void find(List<List<Integer>> result,List<Integer> l,int n,int k,int start){
        if (start+k > n+1){
            return;
        }
        if (k == 0){
            result.add(l);
            return;
        }

        for (int i = start; i <= n; i++) {
            List<Integer> ll = new ArrayList<>();
            for (int i1 = 0; i1 < l.size(); i1++) {
                ll.add(l.get(i1));
            }
            ll.add(i);
            find(result,ll,n,k-1,i+1);
        }
    }
}
