

public class Solution {
    public static void main(String[] args) {
        double num[][] = new double[][]{{1,4,0,1,3,5,4,1},{0,0,1,1,1,1,2,3}};
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print( Math.pow((Math.pow((num[i][0]-num[j][0]),2)+Math.pow((num[i][1]-num[j][1]),2) ), 0.5));
            }
            System.out.println();
        }
    }
}
