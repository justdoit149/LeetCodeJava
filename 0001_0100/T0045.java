public class T0045 {
    //̰�ģ�˼·һ��i��nums.length-1��0����iǰ����Զ���ܵ�i��λ�á�
    //���Ӷ�O(n^2)
    //˼·���������ң��ҵ�ǰ��Ӧ���ߵ��ġ��Ǹ�λ�����ߵ��ľ�����Զ,
    //���統ǰλ����index = 3��nums[3] = 5����4-8��λ��Ϊ3,2,7,1,3��
    //����nums[6] + 6 == 13�����ģ����index���µ�6
    //���Ӷ�O(n)��
    public int jump(int[] nums) {
        int index = nums.length - 1;
        int ans = 0;
        while(index > 0){
            for(int i = 0; i < index; i++){
                if(i + nums[i] >= index){
                    index = i;
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {2};
        T0045 test = new T0045();
        System.out.println(test.jump(nums));
    }
}
