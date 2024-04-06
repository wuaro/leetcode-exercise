package LeetCode热题100.哈希.字母异位词;

import java.util.*;

class Solution {
/*
49. 字母异位词分组
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

 示例 1:
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

示例 2:
输入: strs = [""]
输出: [[""]]

示例 3:
输入: strs = ["a"]
输出: [["a"]]

提示：
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母
 */


    //方法一：排序法
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();       //字符串转换为char[]（方便后面排序）
            Arrays.sort(s);                         //排序（异位词排序之后就一样了）
            String s1 = String.valueOf(s);          //转化回字符串，来判断是否和HashMap中字符串相同
            if (hm.containsKey(s1)) {                //每次判断，如果有一样的，就放入排序之前的字符串：strs[i]
                hm.get(s1).add(strs[i]);
                hm.put(s1, hm.get(s1));
            } else {                                   //如果是新的异位词，则创建新的list<String>加入HashMap
                List<String> slist = new ArrayList<String>();   //HashMap中的value是一个String的list
                slist.add(strs[i]);
                hm.put(s1, slist);
            }
        }
        //取出HashMap中所有的value，也就是所有的List<String>,放入一个大的Lits<List<String>>
        ArrayList<List<String>> lists = new ArrayList<List<String>>();
        Collection<List<String>> values = hm.values();
        for (List<String> value : values) {
            lists.add(value);
        }
        return lists;
    }

    //上面代码写的太臃肿，其实可以简化很多
    public static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> slhm = new HashMap<String, List<String>>();
        for (String s:strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String s1 = String.valueOf(charArray);      //注意这里不能用toString()，那样只会转化成char[]的地址
            if (!slhm.containsKey(s1)) slhm.put(s1,new ArrayList<String>());

            //直接加入就可以，不必再使用一次slhm.put()，主要是 slhm.get(s1).add(s)返回的是Boolean
            //下面这句是被复用，无论需不需要再HashMap中新建List，都需要往里面添加元素（妙极！我怎么没想到！）
            slhm.get(s1).add(s);
            //slhm.put(s1,slhm.get(s1).add(s));
        }
        //slhm.values()本来是返回Collection对象的，但是可以直接放入ArrayList中进行转化
        return new ArrayList<>(slhm.values());
    }


    //方法二：字符计数法
    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, ArrayList<String>> slhm = new HashMap<String, ArrayList<String>>();
        for (String s:strs){
            int[] charsnum = new int[26];
            for (int i = 0; i < s.length(); i++) {
                charsnum[s.charAt(i)-'a']++;           //在数组对应位置+1
            }

            //String s1 = new String();
            StringBuilder sb = new StringBuilder();
            //最终形成的String长这样：|0|1|2|0|2|......（以此类推），用来表示单词中26个字母出现的次数，从而判断异位词
            for (int c:charsnum) {
                sb.append('|');
                sb.append(c);
            }
            String s2 = sb.toString();
            if (!slhm.containsKey(s2)) slhm.put(s2,new ArrayList<>());
            slhm.get(s2).add(s);
        }
        return new ArrayList<>(slhm.values());
    }

    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams1(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}