//数组双指针遍历例题：在排好序的、无重复的数组中找和为target的数对
import java.util.*;

public class TwoPointer {
    public List<List<Integer>> find(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int l = 0, r = nums.length - 1, sum = 0;
        while(l < r){
            sum = nums[l] + nums[r];
            if(sum > target){
                r--;
            }else if(sum < target){
                l++;
            }else{
                ans.add(Arrays.asList(nums[l],nums[r]));
                l++;
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoPointer test = new TwoPointer();
        int[] nums = {-9,-2,-1,3,5,6,10};
        int target = 4;
        List<List<Integer>> ans = test.find(nums,target);
        System.out.println(ans.toString());
    }
    
}
