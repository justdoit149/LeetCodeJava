public class T0075 {
    //���˱����Ļ�������Ȼ����ֱ�Ӽ���Ȼ����д������Ͱ����������Ϊ�����ٶ������
    //���һ�˱����Ļ���������ָ�룬һ��l��ǰ�����ڽ���0��һ��r�ں������ڽ���2��
    //���for(int i = 0; i < n; i++)�������������0����ǰ������l++��Ȼ��i--(�����жϽ�����������)
    //����2����󽻻�������1����
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }
        for(int i = 0; i < count[0]; i++){
            nums[i] = 0;
        }
        for(int i = count[0]; i < count[0] + count[1]; i++){
            nums[i] = 1;
        }
        for(int i = count[0] + count[1]; i < nums.length; i++){
            nums[i] = 2;
        }
    }   
}
