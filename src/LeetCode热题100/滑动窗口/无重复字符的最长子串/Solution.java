package LeetCode热题100.滑动窗口.无重复字符的最长子串;

import java.util.HashMap;

/*
3. 无重复字符的最长子串
中等
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

提示：
0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
 */
public class Solution {
    /**
     * 方法一：滑动窗
     * 设置滑动窗，从left起到right止，起初left=right=0
     * 一直让right++，如果和表中现有元素不重复，就将新元素存入哈希表
     * 如果重复，则最优的办法是把left挪到原来的重复元素右边（这样可以保证从left到right之间的元素不重复）
     * 此时需要删表中存储的、原来的重复元素左侧的元素（因为窗口改变之后它们已经不在窗口内了）
     * 直到right到达字符串末尾，结束
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        while (right < s.length()){
            System.out.print("left:"+left+" right:"+right);
            if (hm.containsKey(s.charAt(right))){
                System.out.print(" 重复："+s.charAt(right));
                left = hm.get(s.charAt(right))+1;
                hm.clear();
                for (int i = left; i <= right; i++) {
                    hm.put(s.charAt(i),i);
                }
                right++;
            }else {
                hm.put(s.charAt(right),right);
                max = (right-left+1)>max ? (right-left+1) : max;
                System.out.print(" size:"+(right-left+1)+" max:"+max);
                right++;
            }
            System.out.println();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbacbb"));
    }

}
