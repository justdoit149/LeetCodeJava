public class T0048 {
    //重点是边界条件的判断与处理
    public void rotate(int[][] matrix) {
        int n = matrix.length, temp = 0;
        for(int i = 0; i < (n+1)/2; i++){
            for(int j = 0; j < n/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
