package 分类刷题.动态规划.矩阵类型.三角形最小路径和;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int record[][] = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        int min = 200 * 10000;
        record[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            record[i][0] = record[i-1][0] + triangle.get(i).get(0);     //每一行的第一个元素 和 最后一个元素都只能从上一行的唯一一个位置走下来
            record[i][i] = record[i-1][i-1] + triangle.get(i).get(i);
        }
        for (int i = 2; i < triangle.size(); i++) {
            for (int j = 1; j < i; j++) {
                record[i][j] = Math.min(record[i-1][j]+triangle.get(i).get(j) , record[i-1][j-1]+triangle.get(i).get(j));
            }
        }

        for (int i = 0; i < record.length; i++) {
            for (int i1 = 0; i1 < record[0].length; i1++) {
                System.out.print(record[i][i1]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++) {
            if (record[triangle.size()-1][i] < min){
                min = record[triangle.size()-1][i] < min ? record[triangle.size()-1][i] : min;
            }
        }
        return min;
    }
}
