//һ���ǳ���Ȼ�������׺��ӡ�ȴ�ֺ���Ҫ����ʵ�ǣ�
//n�����������һ�������ֵ��������Сֵ������ȥ��һ�������ֵ��������Сֵ������
//��С��ȵ�Ѱ���õ������˼��


public class T0085 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int ans = 0, m = matrix.length, n = matrix[0].length;
        //����ά�ȷֱ��¼ÿ��λ�����ϡ����������1�ĸ���������ǰλ�ã�
        int[][][] dp = new int[m][n][2];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                //ǰ��ά��������1���ȵ�dp���̷ǳ���Ȼ��ע��߽硣
                dp[i][j][0] = (i > 0 ? dp[i-1][j][0] + 1 : 1);
                dp[i][j][1] = (j > 0 ? dp[i][j-1][1] + 1 : 1);
                int min_width = dp[i][j][1];//��¼��С��ȣ�
                for(int i0 = i; i0 >= i - dp[i][j][0] + 1; i0--){//ֻ����һ�����򼴿�
                    //���ö�پ������
                    min_width = Math.min(dp[i0][j][1], min_width);
                    ans = Math.max(min_width * (i-i0+1), ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
