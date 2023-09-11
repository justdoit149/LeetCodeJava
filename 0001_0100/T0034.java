public class T0034 {
    //注意数据范围,length能是0.
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums.length == 0){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        ans[0] = bSearch_l(nums, target);
        ans[1] = bSearch_r(nums, target);
        return ans;
    }

    public int bSearch_l(int[] nums, int target){
        int l = 0, r = nums.length-1,mid=0;
        while(l<=r){
            mid = (l+r) / 2;
            if(nums[mid] >= target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        if(r >= 0 && nums[r] == target){
            return r;
        }else if(l < nums.length && nums[l] == target){
            return l;
        }else{
            return -1;
        }
    }
    public int bSearch_r(int[] nums, int target){
        int l = 0, r = nums.length-1,mid=0;
        while(l<=r){
            mid = (l+r) / 2;
            if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        if(l < nums.length && nums[l] == target){
            return l;
        }else if(r >= 0 && nums[r] == target){
            return r;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        
    }
}
