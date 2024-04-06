package LeetCode热题100.子串.最小覆盖子串;

/*
76. 最小覆盖子串
困难
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：
对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。

示例 1：
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。

示例 2：
输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。

示例 3:
输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。

提示：
m == s.length
n == t.length
1 <= m, n <= 105
s 和 t 由英文字母组成
 */





import java.util.HashMap;

public class Solution {

    //把字符串转化为对应的计数数组

    //判断子串是否符合条件
//    public static Boolean s_include_t(int left,int right,String s,){
//        while(){
//
//        }
//        return true;
//    }
//
//
//    public static String minWindow(String s, String t) {
//        if (t.length()>s.length() || t.length() == 0) return "";
//        if (s.length() == 1){
//            if (s.charAt(0) == t.charAt(0)){
//                return t;
//            }else {
//                return "";
//            }
//        }
//        HashMap<Character, Integer> hm = new HashMap<>();
//        int finish = 0;
//        //把t里的各个字符及其出现次数记载hashmap中，finish表示不同字符的数量
//        for (int i = 0; i < t.length(); i++) {
//            if(!hm.containsKey(t.charAt(i))){           //如果hashmap里没有该字符，说明是新出现的，finish++
//                hm.put(t.charAt(i),1);                  //新加入的，第一次出现
//                finish++;
//            }else {
//                hm.put(t.charAt(i),hm.get(t.charAt(i))+1);  //以前已经有的，出现次数+1了
//            }
//        }
//
//        int left = 0;           //左右指针夹着滑动窗口
//        int right = 0;
//
//        String result = "";         //随时记录当前最小子串以及长度
//        int min_len = s.length();
//
//        System.out.println(finish);
//        while (right < s.length()-1){
//
//            /*
//            right一直往右跑，直到子串中出现t中全部字符（此时hashmap中所有值都<=0）
//             */
//            while (finish != 0){
//                if(hm.containsKey(s.charAt(right))){
//                    hm.put(s.charAt(right),hm.get(s.charAt(right))-1);  //子集中出现t中字符，则hm中相应-1
//                    if (hm.get(s.charAt(right)) == 0){                  //如果hm中有一个字符已经减到0了，说明已经有一个字符足够了，finish--
//                        finish--;
//                    }
//                }
//                right++;
//            }
//
//            /*
//            left往右跑，直到子串第1个字符属于t（答案一定得满足子串第一个 和 最后一个字符都是在t之内的字符）
//             */
//            while (!hm.containsKey(s.charAt(left))){
//                left++;
//            }
//            if ((right-left) < min_len){              //一旦比之前找到的符合条件子串更小，就替换
//                result = s.substring(left,right);
//                min_len = right-left+1;
//            }
//            if (left < right) {
//                hm.put(s.charAt(left),hm.get(s.charAt(left))+1);
//                if (hm.get(s.charAt(left)) > 0){
//                    finish++;               //说明这次left动，丢掉子串最左侧字符后，又再次出现为满足条件的字符了
//                }
//                left++;
//            }
//
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(minWindow("ab","A"));
//    }
//}
}