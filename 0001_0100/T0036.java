public class T0036 {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            if(!check_same(board, i, 0, 0, 1)) return false;
            if(!check_same(board, 0, i, 1, 0)) return false;
        }
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                if(!check_same(board, i, j, 1, 1)) return false;
            } 
        }
        return true;
    }
    //注意代码的复用。行和列很显然几乎是完全一致的，没必要复制一遍。
    public boolean check_same(char[][] board, int i, int j, int i0, int j0){
        //i0和j0指示方向
        boolean[] check = new boolean[10];
        int temp = 0;
        if(i0 == j0){
            for(int i1 = 0; i1 < 3; i1++){
                for(int j1 = 0; j1 < 3; j1++){
                    if(board[i+i1][j+j1] >= '1'){
                        temp = board[i+i1][j+j1] - '0';
                        if(check[temp] == true){
                            return false;
                        }else{
                            check[temp] = true;
                        }
                    }
                }
            }
        }else{
            for(int count = 0; count < 9; count++){
                if(board[i][j] >= '1'){
                    temp = board[i][j] - '0';
                    if(check[temp] == true){
                        return false;
                    }else{
                        check[temp] = true;
                    }
                }
                i += i0;
                j += j0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =   {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        T0036 test = new T0036();
        System.out.println(test.isValidSudoku(board));
    }
}
