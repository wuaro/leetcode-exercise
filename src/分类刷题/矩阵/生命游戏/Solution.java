package 分类刷题.矩阵.生命游戏;

public class Solution {

    /*
    思路：
        原地解决
        如果不需要变动，则依旧为0或1
        如果需要从0变成1，则改为-2。如果需要从1变成0，则改为2
        在判断时，如果是0或-2，则证明原本是0.如果是1或2，则证明原本是1
        在最后，将所有-2改为1，将所有2改为0


        两个for循环，遍历每个元素,int one_num和zero_num分别记录0和1的数量
        对于每个元素，两层for循环分别让i从i-1到i+1（j同理）
            如果ii<0或ii>board.length或jj<0或jj>board[0].length-1或（ii==i且jj==j），则continue

     */

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //对于每个元素，计算周围一圈的0和1数量
                int one_num = 0;
                int zero_num = 0;
                for (int ii = i-1; ii <= i+1; ii++) {
                    for (int jj = j-1; jj <= j+1; jj++) {
                        //如果出上界，下界，左界，右界，本身，则跳过
                        if (ii<0 || ii>board.length-1 || jj<0 || jj>board[0].length-1 || ii==i&&jj==j){
                            continue;
                        }
                        if (board[ii][jj] == 0 || board[ii][jj] == -2)zero_num++;
                        else one_num++;
                    }
                }
                if (board[i][j] == 1){
                    if (one_num<2 || one_num>3) board[i][j] = 2;
                }else {
                    if (one_num==3) board[i][j] = -2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -2)board[i][j] = 1;
                if (board[i][j] == 2)board[i][j] = 0;
            }
        }
    }
}
