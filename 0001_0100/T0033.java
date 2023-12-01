import java.util.Arrays;

public class T0033 {
    public int search(int[] nums, int target) {
        int mid = find_index(nums), ans;
        if(mid == -1){
            //�Դ���binarySearch����targetС��nums������ֵ�򷵻�-1������������-length-1
            //�����Ӧ�õĲ���λ����nums[i]��nums[i+1]֮�䣬�򷵻�-i-2;
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
    //���֣�mid�����Ҷˣ�������r���Ƚ���ȷ����תλ�ã����r+1==l��nums[r]>nums[l]����Ϊ�ֽ硣
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
