public class T0079 {
    //用递归来实现深度优先搜索，且如果不匹配的话及时剪枝
    public boolean exist(char[][] board, String word) {
        char[][] board2 = new char[10][10];
        boolean ans = false;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board2[i+1][j+1] = board[i][j];
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                ans = (ans || find(board2, i, j, word, 0));
            }
        }
        return ans;

    }
    public boolean find(char[][] board, int r, int c, String word, int index){
        if(word.length() == index){
            return true;
        }else if(word.charAt(index) != board[r][c]){
            return false;
        }
        board[r][c] = '\0';//不能重复
        boolean ans = find(board, r+1, c, word, index+1) || find(board, r-1, c, word, index+1)
                    || find(board, r, c+1, word, index+1) || find(board, r, c-1, word, index+1);
        board[r][c] = word.charAt(index);//需要恢复，因为换一个分支可能再用它
        return ans;
    }
}
