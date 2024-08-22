package 分类刷题.动态规划.字符串.最长回文子串;

public class Solution {

    public boolean isPalindrome(String s,int left ,int right){
        while(true){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
            if (left > right) return true;
        }
    }

    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        if (s.length() == 2){
            if (s.charAt(0) == s.charAt(1)) return s;
        }
        return "";
    }
}
