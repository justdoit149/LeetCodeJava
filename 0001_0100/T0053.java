public class T0053 {
    //��ǰλ����ǰ������ֶκͣ�һ����ֻ�����Լ�����һ���Ǵ�ǰ���Ԫ��
    //�赱ǰ��index����index-1λ����ǰ������ֶκ��Ǵ�l��index-1����indexλ����ǰҲһ����l��index
    //�����롰��󡱻�ì�ܡ����dp����Ϊnums[i] = Math.max(nums[i-1]+nums[i], nums[i]);
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            //ֱ�����������浱ǰλ����ǰ������ֶκ͡�
            nums[i] = Math.max(nums[i-1]+nums[i], nums[i]);
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
