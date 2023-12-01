import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
//思路：定一动二，“二”的和要为“一”的相反数
//排好序的数组里找两个和为-nums[i]的，经典的双指针，小于则移动左边、大于则移动右边
//复杂度是O(n^2)
//注意去重。由于nums已经排好序，有nums[i]<=nums[l]<=nums[r]
//因此完全可以先用二维数组处理，然后对二维数组排序（默认先看第一列再看第二列再第三列）然后去重
//去完重之后再拷贝进ArrayList里。（不太能对这个比较复杂的ArrayList排序）

public class T0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        //List是个接口，不能实例化，Arraylist等类实现了这个接口，因此这里需要new的是ArrayList.
        //编译时ans视为List，接口里有相应声明的属性和方法，能通过编译
        //运行时ans视为ArrayList，相应的方法已经实现，能正确运行。
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int l,r,sum;
        for(int i = 0; i < nums.length-2; i++){
            //去重1：首个一样的话，找到的肯定是和之前找过的重复的
            //而如果首个都不一样那肯定不是重复的，因此这里保证了外层for进行n次不会出现重复
            //处理如[-3,-3,0,1,2,3]的情况
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            l = i + 1;
            r = nums.length-1;
            while(l<r){
                sum = nums[l] + nums[r] + nums[i];
                if(sum < 0){
                    l++;
                }else if(sum > 0){
                    r--;
                }else{
                    //Array到ArrayList，可以用Arrays.asList，其参数可以是完整写出这个数组元素
                    //也可以是对象型数组的数组名，但不能是基本数据类型的数组。
                    List<Integer> temp = Arrays.asList(nums[i],nums[l],nums[r]);
                    //！！！注意：基本类型用==，引用类型只能用.equals()判等
                    if(ans.isEmpty() || !ans.get(ans.size()-1).equals(temp)){
                        //去重2：定i时第一个重复，只看后两个。
                        //由于已经nums排好序，这样产生的重复一定是相邻的，只需要看列表顶即可
                        ans.add(temp);
                    }
                    l++;
                    r--;
                }
            }
        }
        
        return ans;
    }
}
