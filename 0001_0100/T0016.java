import java.util.Arrays;

public class T0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l,r,sum,ans=nums[0]+nums[1]+nums[2];
        for(int i = 0; i < nums.length-2; i++){
            l = i + 1;
            r = nums.length - 1;
            while(l<r){
                sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target-sum) < Math.abs(target-ans)){
                    ans = sum;
                }
                if(sum > target){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ans;
    }
}
