public class T0059 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        //������ʾ�ĸ����������
        int[][] vector = {{0,1},{1,0},{0,-1},{-1,0}};
        //i,jָʾ��ǰλ�ã�f����ѡ����
        int f = 0, i = 0, j = 0;
        for(int count = 1; count <= n * n; count++){
            ans[i][j] = count;
            i += vector[f][0];
            j += vector[f][1];
            //��������˱߽���ߵ������Ѿ�����ĸ��ӣ��Ǿͳ��������ȥ��Ȼ�󻻷�����ǰ��һ��
            if(i < 0 || i >= n || j < 0 || j >= n || ans[i][j] > 0){
                i -= vector[f][0];
                j -= vector[f][1];
                f = (f + 1) % 4;//ȡģ����ʾ�����ѭ��
                i += vector[f][0];
                j += vector[f][1];
            }
        }
        return ans;
    }
}
