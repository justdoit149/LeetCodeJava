import java.util.ArrayList;
import java.util.List;

//?????????n^n??????????????????????????
//????????????????????dfs???????
public class T0051 {
    private char[][] board = new char[12][12];
    private List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        dfs(n,0);
        return ans;
    }
    private void dfs(int n, int line){
        if(line == n){
            List<String> temp = new ArrayList<>();
            StringBuilder str = new StringBuilder(n*n+1);//StringBuilder????????????
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    str.append(board[i][j]);
                }
                temp.add(str.substring(i*n, (i+1)*n));
            }
            ans.add(temp);
            return;
        }
        for(int j = 0; j < n; j++){
            if(check(n, line,j)){
                board[line][j] = 'Q';//dfs?????????????????
                dfs(n, line+1);
                board[line][j] = '.';
            }
        }
    }
    private boolean check(int n, int i0, int j0){
        int[][] v = {{-1,0},{-1,-1},{-1,1}};//??????“??”????
        for(int k = 0; k < v.length; k++){
            //x?y???????(i0,j0)???????????????
            for(int x=i0+v[k][0],y=j0+v[k][1]; x>=0 && y>=0 && y<n; x+=v[k][0],y+=v[k][1]){
                if(board[x][y] == 'Q'){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        T0051 test = new T0051();
        int n = 10;
        System.out.println(test.solveNQueens(n).size());
        System.out.println(test.solveNQueens(n).toString());
    }
}

