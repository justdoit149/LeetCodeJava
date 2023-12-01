public class T0063 {
    //�������dp
    //�����ϰ�����1����ʵ����0���ã������������ۣ�ֱ����ԭ�����·������
    //����ֻ��Ҫ����һ�飬���Ҷ���ռ���O(1)������ʵ��ʱ��Ϳռ����Ķ���С��
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
                //ע�����ﲻ��1����Ϊ�������������ϰ��
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
