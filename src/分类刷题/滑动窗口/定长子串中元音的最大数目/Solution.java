package 分类刷题.滑动窗口.定长子串中元音的最大数目;

public class Solution {

    // 判断是否是元音
    public Boolean is_yuan(char s){
        switch (s){
            case 'a':return true;
            case 'e':return true;
            case 'i':return true;
            case 'o':return true;
            case 'u':return true;
            default:return false;
        }
    }

    public int maxVowels(String s, int k) {
        int total = 0;
        int max;

        for (int i = 0;i < k;i++){
            if ( is_yuan(s.charAt(i)) ){
                total++;
            }
        }
        max = total;

        for (int i = k-1;i < s.length()-1;i++){
            if ( is_yuan(s.charAt(i+1)) ){
                 total++;
            }
            if (is_yuan(s.charAt(i-k+1))){
                total--;
            }
            if (total > max) max = total;
        }
        return max;
    }
}
