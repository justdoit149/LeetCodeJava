import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//ע�����ݷ�Χ������������Ӧ���ø߾���
public class T0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int l,r;
        long sum;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]){//ȥ��
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j-1]){//ȥ��
                    continue;
                }
                l = j + 1;
                r = nums.length - 1;
                while(l < r){
                    //תLongע��nums��int���飬������Ҳ��int��������һ��Ԫ��תlong������������
                    //���ǲ���sum = (long)(i,j,l,r)����Ȼ���ȼ�����ת����
                    sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum > target){
                        r--;
                    }else if(sum < target){
                        l++;
                    }else{
                        if(l > j + 1 && nums[l] == nums[l-1]){//ȥ�أ�����l��rҪ����
                            //ֻ��l���ɣ���Ϊǰ������ͬ�Һ���ͬ�����ĸ�Ҳһ����ͬ��
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
