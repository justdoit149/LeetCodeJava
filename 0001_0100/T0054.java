import java.util.ArrayList;
import java.util.List;
//可以将矩阵看成若干层，首先输出最外层的元素，其次输出次外层的元素，直到输出最内层的元素
//这样可以用层数来递归
//或者再开一个矩阵用来标记某个位置是否用过，一旦遇到用过的或者边界就换方向。
public class T0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        solve(matrix, 0, m*n, ans, m, n);  
        return ans;
    }
    public void solve(int[][] matrix, int level, int count, List<Integer> ans, int m, int n){
        for(int j = level; count > 0 && j < n - level; j++, count--){
            ans.add(matrix[level][j]);         
        }
        for(int i = level + 1; count > 0 && i < m - level; count--, i++){
            ans.add(matrix[i][n-1-level]);
        }
        for(int j = n - 2 - level; count > 0 && j >= level; j--, count--){
            ans.add(matrix[m-1-level][j]);         
        }
        for(int i = m - 2 - level; count > 0 && i > level; count--, i--){
            ans.add(matrix[i][level]);
        }
        if(count == 0) return;
        solve(matrix, level+1, count, ans, m, n);       
    }
    public static void main(String[] args) {
        
    }
}
