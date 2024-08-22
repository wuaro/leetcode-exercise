package 分类刷题.动态规划.斐波那契类型.完全平方数;

public class Solution {
    public int numSquares(int n) {
        int record[] = new int[n+1];  //记录从1到n每个数的numSquares
        record[0] = 0;
        record[1] = 1;
        for (int i = 2; i <record.length ; i++) {
            int min = i;    //先设置为1+1+1...这种情况的最大个数，再内层for循环中如果找到更少的数字个数，则替换
            // 如果i减去一个完全平方数之后>=0，则再试一个更大的完全平方数，如果刚好i-j*j==0则说明当前的i本身就是完全平方数
            for (int j = 1; i-j*j >= 0; j++) {
                min = 1 + record[i-j*j] < min ? 1 + record[i-j*j] : min;
            }
            record[i] = min;
            System.out.println("record[i]:" + record[i]);
        }
        return record[n];
    }
}
