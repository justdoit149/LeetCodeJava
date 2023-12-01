import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//注意数据范围可能造成溢出，应该用高精度
public class T0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int l,r;
        long sum;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]){//去重
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j-1]){//去重
                    continue;
                }
                l = j + 1;
                r = nums.length - 1;
                while(l < r){
                    //转Long注意nums是int数组，计算结果也是int，对其中一个元素转long即可类型提升
                    //但是不能sum = (long)(i,j,l,r)这仍然是先计算再转换。
                    sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum > target){
                        r--;
                    }else if(sum < target){
                        l++;
                    }else{
                        if(l > j + 1 && nums[l] == nums[l-1]){//去重，这里l和r要动！
                            //只比l即可，因为前三个相同且和相同，第四个也一定相同。
                            l++;
                            r--;
                            continue;
                        }
                        ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
