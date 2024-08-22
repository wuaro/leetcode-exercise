package 分类刷题.贪心.跳跃游戏;

import java.util.Stack;

public class Solution {
    /**
     * 直接模拟整个过程（会超时！！！）
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        Stack<Integer> path_stack = new Stack<>();
        int path_length = 0;
        while (path_length < nums.length-1){

            //如果遇到0，说明前面的某一步走错了，此时应该退回去重新走
            if (nums[path_length] == 0){
                //首先把栈顶的1全部去掉（因为1已经无法减1了，因此需要进一步往前退）
                while (!path_stack.empty() && path_stack.peek() == 1){
                    path_stack.pop();
                    path_length--;
                }

                //如果把1全部出栈后，栈里没有元素了，就说明原本栈里全都是1，那么就说明已经没有任何其他走法能够保证不走到0了
                if (path_stack.empty()) return false;

                //如果把1全部退掉之后还有“非1元素”，那么说明还有可以悔改的机会，这个时候把栈顶元素-1，也就是让当前所走的前一步-1
                int peek = path_stack.peek();
                path_stack.pop();
                path_stack.push(peek-1);
                path_length -= 1;
            }else {
                path_stack.push(nums[path_length]);
                path_length += nums[path_length];
            }
        }
        return true;
    }

    public boolean canJump(int[] nums) {

        int max_path_length = 0;    //记录当前已经遍历过的这些格子里面，最远能跳到的位置
        for (int i = 0; i < nums.length; i++) {

            //如果当前所在的格子距离起点的距离已经超过max_path_length，则说明从前面i-1个格子出发，无论怎么跳都不可能跳到当前格子
            //那再研究后面的格子就没有意义了，后面的格子一定也到达不了，终点也一定到达不了，所以直接return false就行了
            if (i > max_path_length) return false;

            //如果发现从当前格子所能跳的最大距离跳出去，能跳到比max_path_length更远的地方，则更新max_path_length
            max_path_length = Math.max(max_path_length,i+nums[i]);

            //如果更新完max_path_length发现已经超过nums[]的长度了，那就一定能跳到终点
            if (max_path_length >= nums.length-1) return true;
        }
        return false;
    }

}
