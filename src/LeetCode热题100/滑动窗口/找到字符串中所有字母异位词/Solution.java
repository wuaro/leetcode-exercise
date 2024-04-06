package LeetCode热题100.滑动窗口.找到字符串中所有字母异位词;

/*
438. 找到字符串中所有字母异位词
中等
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

示例 1:
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

示例 2:
输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

提示:
1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static String charCount(String str){
        String result = "";
        int char_count[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char_count[str.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            result += "|";
            result += char_count[i];
        }
        return result;
    }

    /**
     * 方法一：滑动窗口
     *  创建和p等长的窗口
     *  使用字符统计法来判断是否是异位词
     *  窗口不断向后滑动
     *  如果新进入窗口内的字符为陌生字符，则将窗口左端直接跳转到该陌生字符右侧
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        System.out.println("sl="+sl+" pl="+pl);
        List<Integer> result = new ArrayList<>();
        String s1 = charCount(p);
        for (int i = 0; i < sl-pl+1; i++) {
            if (charCount(s.substring(i,i+pl)).equals(s1)){
                System.out.println("i="+i+"时：出现异位词，加入list");
                result.add(i);
            }else if (!p.contains(s.substring(i+pl-1,i+pl))){
                System.out.println("i="+i+"时：滑动窗末尾出现生字符，直接跳过");
                i+=pl-1;
            }else {
                System.out.println("i="+i+"时：无事发生");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = findAnagrams("abab","ab");
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i));
        }
    }


}
