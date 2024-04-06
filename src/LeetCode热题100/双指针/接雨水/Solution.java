package LeetCode热题100.双指针.接雨水;

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
class Solution {
    //利用二维数组填充0,1  然后在填充好的二维数组中进行判断（可行，但会导致内存爆炸）
    public static int trap(int[] height) {
        //找出最高的柱子
        int max =0;
        int num = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] > max) max = height[i];
        }
        int[][] a = new int[max][height.length];
        //形成可视化二维数组
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[i]; j++) {
                a[j][i] = 1;
            }
        }
        for (int i = 0; i < max; i++) {
            boolean flag = false;
            int l = -1;
            int r = -1;
            //记录左右第一堵墙
            for (int j = 0; j < height.length; j++) {
                if (a[i][j] == 1) {
                    l = j;
                    break;
                }
            }
            for (int j = height.length-1; j > 0; j--) {
                if (a[i][j] == 1) {
                    r = j;
                    break;
                }
            }
            //在lr中找到的所有0都是水
            for (int j = l; j < r; j++) {
                if (a[i][j] == 0) num++;
            }
        }
        return num;
    }


    //不用二维数组也可以，也是一层一层判断，只需要判断高度就可以
    public static int trap1(int[] height) {
        //找出最高的柱子
        int max =0;
        int num = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] > max) max = height[i];
        }
        for (int i = 1; i <= max; i++) {
            boolean flag = false;
            int l = -1;
            int r = -1;
            //记录左右第一堵墙
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i) {
                    l = j;
                    break;
                }
            }
            for (int j = height.length-1; j > 0; j--) {
                if (height[j] >= i) {
                    r = j;
                    break;
                }
            }
            //在lr中找到的所有0都是水
            for (int j = l; j < r; j++) {
                if (height[j] < i) num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(trap1(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
