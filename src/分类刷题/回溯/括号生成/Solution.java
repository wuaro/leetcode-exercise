package 分类刷题.回溯.括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        find(result,n,0,0,"");
        return result;
    }

    /**
     * 递归函数
     * @param result    每次有效的结果都要存入list列表
     * @param n         括号的对数
     * @param leftNum  当前字符串 左括号数量
     * @param rightNum 当前字符串 右括号数量
     */
    public static void find(List<String> result,int n,int leftNum,int rightNum,String nowString){
        StringBuilder stringAfterAppendStringBuilder = new StringBuilder(nowString);

        //1.括号数量超过限制 2.当前左括号数量少于右括号数量  都是不能进行下去了，直接return
        if (leftNum>n || rightNum>n || leftNum < rightNum){
            return;
        }
        //如果符合最终条件，则加入list
        if (leftNum==rightNum && leftNum==n){
            result.add(nowString);
            return;
        }
        //先试试加左括号
        String stringAfterAppend1 = stringAfterAppendStringBuilder.append('(').toString();
        find(result,n,leftNum+1,rightNum,stringAfterAppend1);
        //再试试加右括号
        //注意！！！这里要先把上面stringAfterAppend1所加的'('给删掉，还原到原本的字符串，再加')'才可以！！！
        String stringAfterAppend2 = stringAfterAppendStringBuilder
                                        .deleteCharAt(stringAfterAppend1.length()-1)
                                        .append(')')
                                        .toString();
        find(result,n,leftNum,rightNum+1,stringAfterAppend2);
    }
}
