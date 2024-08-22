package 分类刷题.并查集.省份数量;

public class Solution {
    private int[] root = null;
    public int findCircleNum(int[][] isConnected) {
        int province_num = 0;
        int province[] = new int[isConnected.length];
        root = new int[isConnected.length];
        //初始化root数组，先让每个节点都以自己为根（每个节点自己独立）
        for (int i = 0; i < isConnected.length; i++) {
            root[i] = i;
        }
        //将这些节点根据二维数组，链接起来
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1){
                    union(i,j);
                }
            }
        }
        for (int i = 0; i < province.length; i++) {
            if (++province[find(i)] == 1){
                province_num++;
            }
        }
        return province_num;
    }

    /**
     * find方法：输入index，返回其父节点下标
     * 1. 如果该节点的根节点就是它自己，说明它就是这个union的根节点
     * 2. 如果不是，就继续递归往上找
     *
     * @param index
     * @return
     */
    public int find(int index){
        if (root[index] == index){
            return root[index];
        }else {
            return find(root[index]);
        }
    }

    /**
     * union方法：将x和y两个元素设置为同一个root节点（合并为同一个大家庭）
     * 1. 查询x和y的根节点
     * 2. 将x的根节点rootX改为y的根节点rootY（这样所有以rootX为根节点的节点，现在都变成以rootY为根了）
     *
     *
     * @param x
     * @param y
     */
    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            root[rootX] =rootY;
        }
    }

}
