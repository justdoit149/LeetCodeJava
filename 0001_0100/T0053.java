public class T0053 {
    //当前位置向前的最大字段和，一种是只带它自己，另一种是带前面的元素
    //设当前在index，若index-1位置向前的最大字段和是从l到index-1，那index位置向前也一定是l到index
    //否则与“最大”会矛盾。因此dp方程为nums[i] = Math.max(nums[i-1]+nums[i], nums[i]);
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            //直接用这个数组存当前位置向前的最大字段和。
            nums[i] = Math.max(nums[i-1]+nums[i], nums[i]);
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
