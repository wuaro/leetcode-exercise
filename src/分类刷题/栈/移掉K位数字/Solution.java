package 分类刷题.栈.移掉K位数字;

public class Solution {
    public String removeKdigits(String num, int k) {
        //如果要扣除的数字数量已经等于或超过字符串长度了，那么肯定返回"0"
        if (k >= num.length())return "0";
        if (k == num.length()-1){
            char min = '9';
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) < min)min=num.charAt(i);
            }
            System.out.println("min:"+min);
            return String.valueOf(min);
        }
        //如果小于字符串长度，则要进行如下判断
        //如果当前数字大于其后面的数字，则删除当前数字,形成新的字符串
        //形成新的字符串后，下一次要重新从头判断，知道k被消耗完
        while (k != 0) {
            boolean flag_1 = false;   //表示本次是否删除了一个 大于其后面的数字
            for (int i = 0; i < num.length() - 1; i++) {
                if (num.charAt(i) > num.charAt(i + 1)) {
                    num = new StringBuilder(num).deleteCharAt(i).toString();
                    k--;
                    flag_1 = true;
                    break;
                }
            }
            //如果没有删除一个大于其后面的数字(也就是现在的每个数字是逐个递增（或不变）的)
            //注意：此时最后的数字才是最大的，应该从后往前删
            if (!flag_1) {
                for (int i = num.length() - 1; i > 0; i--) {
                    num = new StringBuilder(num).deleteCharAt(i).toString();
                    k--;
                    break;
                }
            }
        }
        int index = 999999;
        for (int i = 0; i < num.length()-1; i++) {
            if (num.charAt(i) != '0'){
                index = i;
                break;
            }
        }
        if (index < num.length()-1){
            return num.substring(index,num.length());
        }else {
            System.out.println(num);
            return "0";
        }
    }
}
