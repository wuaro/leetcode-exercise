package 分类刷题.动态规划.杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> yh = new ArrayList<>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        yh.add(first);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> l = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    l.add(1);
                }else {
                    l.add(yh.get(i-1).get(j-1) + yh.get(i-1).get(j));
                }
            }
            yh.add(l);
        }
        return yh;
    }
}
