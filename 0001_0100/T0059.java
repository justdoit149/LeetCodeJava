public class T0059 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        //用来表示四个方向的向量
        int[][] vector = {{0,1},{1,0},{0,-1},{-1,0}};
        //i,j指示当前位置，f用来选择方向
        int f = 0, i = 0, j = 0;
        for(int count = 1; count <= n * n; count++){
            ans[i][j] = count;
            i += vector[f][0];
            j += vector[f][1];
            //如果到达了边界或者到达了已经填过的格子，那就撤销步骤回去，然后换方向再前进一步
            if(i < 0 || i >= n || j < 0 || j >= n || ans[i][j] > 0){
                i -= vector[f][0];
                j -= vector[f][1];
                f = (f + 1) % 4;//取模来表示方向的循环
                i += vector[f][0];
                j += vector[f][1];
            }
        }
        return ans;
    }
}
