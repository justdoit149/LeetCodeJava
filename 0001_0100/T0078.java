import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//找子集：i个元素的集合的所有子集 = 前i-1个的所有子集 + 前i-1个的每个子集都加上最后一个
public class T0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        ans.add(Arrays.asList(nums[0]));
        int n = 0;
        List<Integer> temp;
        for(int i = 1; i < nums.length; i++){
            n = ans.size();
            for(int j = 0; j < n; j++){
                //get出来的不能直接去修改操作，应该new一个新的再操作
                temp = new ArrayList<>(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        T0078 test = new T0078();
        int[] nums = {11,45,14};
        System.out.println(test.subsets(nums).toString());
    }
}
