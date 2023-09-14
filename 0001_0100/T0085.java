//一个非常显然但很容易忽视、却又很重要的事实是：
//n个数，再添加一个，最大值不减，最小值不增；去掉一个，最大值不增，最小值不减。
//最小宽度的寻找用到了这个思想


public class T0085 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int ans = 0, m = matrix.length, n = matrix[0].length;
        //两个维度分别记录每个位置向上、向左的连续1的个数（含当前位置）
        int[][][] dp = new int[m][n][2];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                //前两维计算连续1长度的dp方程非常显然，注意边界。
                dp[i][j][0] = (i > 0 ? dp[i-1][j][0] + 1 : 1);
                dp[i][j][1] = (j > 0 ? dp[i][j-1][1] + 1 : 1);
                int min_width = dp[i][j][1];//记录最小宽度，
                for(int i0 = i; i0 >= i - dp[i][j][0] + 1; i0--){//只需沿一个方向即可
                    //逐个枚举矩形面积
                    min_width = Math.min(dp[i0][j][1], min_width);
                    ans = Math.max(min_width * (i-i0+1), ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
