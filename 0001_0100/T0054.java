import java.util.ArrayList;
import java.util.List;
//���Խ����󿴳����ɲ㣬�������������Ԫ�أ�������������Ԫ�أ�ֱ��������ڲ��Ԫ��
//���������ò������ݹ�
//�����ٿ�һ�������������ĳ��λ���Ƿ��ù���һ�������ù��Ļ��߽߱�ͻ�����
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
