import java.util.Arrays;

public class T0033 {
    public int search(int[] nums, int target) {
        int mid = find_index(nums), ans;
        if(mid == -1){
            //自带的binarySearch，若target小于nums里所有值则返回-1，大于所有则-length-1
            //如果其应该的插入位置在nums[i]与nums[i+1]之间，则返回-i-2;
            ans = Arrays.binarySearch(nums, 0, nums.length, target);
            if(ans >= 0){
                return ans;
            }
            return -1;
        }
        ans = Arrays.binarySearch(nums, 0, mid, target);
        if(ans >= 0){
            return ans;
        }else{
            ans = Arrays.binarySearch(nums, mid, nums.length, target);
            if(ans >= 0){
                return ans;
            }else{
                return -1;
            }
        }

    }
    //二分，mid和最右端（不宜用r）比较来确定翻转位置，最后r+1==l且nums[r]>nums[l]，即为分界。
    public int find_index(int[] nums){
        int l = 0, r = nums.length-1,mid;
        while(l<=r){
            mid = (l+r)/2;
            if(nums[mid] > nums[nums.length-1]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        if(r >= 0 && nums[r] > nums[l]){
            return l;
        }
        return -1;
    }
}
