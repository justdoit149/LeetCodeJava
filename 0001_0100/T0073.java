public class T0073 {
    //�ؼ��������ֳɵ�matrix�������Ҫ����������еı�ǣ��Ӷ�ʵ��O(1)�Ķ���ռ临�Ӷ�
    //���ǿ����þ���ĵ�һ�к͵�һ�д��淽��һ�е�����������飬�ԴﵽO(1)�Ķ���ռ䡣
    //�������ᵼ��ԭ����ĵ�һ�к͵�һ�б��޸ģ��޷���¼�����Ƿ�ԭ������0��
    //���������Ҫ����ʹ��������Ǳ����ֱ��¼��һ�к͵�һ���Ƿ�ԭ������0��
    //���Ҵ���˳��Ҳ����Ҫ���������ý�����n-1��n-1���������ܶ���һ�к͵�һ�С�
    public void setZeroes(int[][] matrix) {
        //��ǵ�һ�С���һ���Ƿ���Ҫ����
        boolean r_zero = false, c_zero = false;
        //���������鿴��һ�к͵�һ���Ƿ�Ҫ����
        if(matrix[0][0] == 0){
            r_zero = true;
            c_zero = true;
        }
        for(int i = 1; i < matrix.length; i++){
            //ע������r_zero���ܱ�false�������޸ĵ��ղ�matrix[0][0]�жϵĽ��
            if(matrix[i][0] == 0){
                c_zero = true;
            }
        }
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                r_zero = true;
            }
        }
        //��ѯʣ��n-1��n-1�У��������0���õ�һ�����һ�н��б��
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //��ѯ��ɺ󣬾��ٱ���ʣ��n-1��n-1�У�������Ӧ�ĵ�һ�е�һ����Ӧλ��Ϊ0������
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //ʣ���matrix(n-1)��������ٶԵ�һ�к͵�һ�н�������
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
