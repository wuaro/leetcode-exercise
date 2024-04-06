package LeetCode热题100.普通数组.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution {
    /*
    方法一：尝试使用一整个大数组来记录各个区间，但后来失败
     */
//    public static int[][] merge(int[][] intervals) {
//        int a[][] = new int[10000][2];
//        ArrayList<int[]> list = new ArrayList<>();
//        /*
//        a[10000][2]第一层： 每次将对应位置+1，如果该位置出现在k个区间中，则a[i][0]==k
//        a[10000][2]第二层： 如果该位置是某区间
//         */
//        for (int i = 0; i < intervals.length; i++) {
//            a[ intervals[i][0] ][1] = 1;
//            a[ intervals[i][1] ][1] = 2;
//            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
//                a[j][0]++;
//            }
//        }
//        for (int i = 0; i < 10000; i++) {
//            System.out.print(" "+a[i][0]);
//        }
//        int t = 0;
//        boolean flag = false;
//        int start = 0;
//        int end = 0;
//        int num = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (flag == false && a[i][0] > 0){
//                flag = true;
//                start = i;
//                a[start][1] = 1;
//                num++;
//            }else if (flag == true && a[i][0] == 0 || num == 0){        //在
//                flag = false;
//                end = i-1;
//                a[end][1] = 2;
//                list.add(new int[]{start,end});
//                t++;
//            }
//        }
//        return list.toArray(new int[list.size()][]);
//    }

    public static int[][] merge(int[][] intervals) {
        //二维数组按照第一列排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(" "+intervals[i][j]);
            }
            System.out.println();
        }

        ArrayList<int[]> list = new ArrayList<int[]>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("i"+i);
            System.out.print(" start"+start);
            System.out.println(" end"+end);
            if(intervals[i][0] > end){
                list.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else if(intervals[i][1] > end){
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start,end});
        System.out.print(" start"+start);
        System.out.println(" end"+end);
        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println();
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(" "+merge[i][j]);
            }
            System.out.println();
        }
    }
}
