public class T0074 {
    //��ά���飬���ֲ��ң����һά��
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1, mid = 0;
        while(l <= r){
            mid = (l + r) / 2;
            if(matrix[mid / n][mid % n] > target){
                r = mid - 1;
            }else if(matrix[mid / n][mid % n] < target){
                l = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
