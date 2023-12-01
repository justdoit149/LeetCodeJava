public class T0063 {
    //最基础的dp
    //题中障碍物是1，其实它是0更好，这样不用讨论，直接用原数组存路径数。
    //这样只需要遍历一遍，并且额外空间是O(1)，可以实现时间和空间消耗都较小。
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                obstacleGrid[i][0] = 0;
            }else{
                //注意这里不是1，因为可能它上面有障碍物。
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }
        }
        for(int i = 1; i < n; i++){
            if(obstacleGrid[0][i] == 1){
                obstacleGrid[0][i] = 0;
            }else{
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }else{
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
