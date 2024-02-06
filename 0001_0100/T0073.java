public class T0073 {
    //关键是利用现成的matrix矩阵进行要清零的行与列的标记，从而实现O(1)的额外空间复杂度
    //我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到O(1)的额外空间。
    //但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含0。
    //因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含0。
    //而且处理顺序也很重要，比如必须得将右下n-1行n-1列清零后才能动第一行和第一列。
    public void setZeroes(int[][] matrix) {
        //标记第一行、第一列是否需要清理
        boolean r_zero = false, c_zero = false;
        //接下来三块看第一行和第一列是否要清理
        if(matrix[0][0] == 0){
            r_zero = true;
            c_zero = true;
        }
        for(int i = 1; i < matrix.length; i++){
            //注意这里r_zero不能标false，避免修改掉刚才matrix[0][0]判断的结果
            if(matrix[i][0] == 0){
                c_zero = true;
            }
        }
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                r_zero = true;
            }
        }
        //查询剩余n-1行n-1列，如果遇到0则用第一行与第一列进行标记
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //查询完成后，就再遍历剩余n-1行n-1列，如果其对应的第一行第一列相应位置为0则清零
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //剩余的matrix(n-1)都清零后，再对第一行和第一列进行清零
        if(c_zero == true){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        if(r_zero == true){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }    
    }
}
