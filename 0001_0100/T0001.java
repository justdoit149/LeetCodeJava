import java.util.Arrays;
import java.util.Comparator;

//方法之：二分查找，先排序然后二分查找找到符合要求的，注意排序后要记录原来的下标是什么
public class T0001 {
    public int search(Integer[][] nums,int x){
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid][0] > x){
                r = mid - 1;
            }else if(nums[mid][0] < x){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        //二维数组，temp[i][0]记录nums[i]，temp[i][1]记录原来的下标i
        Integer[][] temp = new Integer[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            temp[i][0] = nums[i];
            temp[i][1] = i;
        }
        //对数组进行排序，也就是按照temp[i][0]从小到大排序
        //这里自定义排序的对象必须为引用类型，因此temp要定义成Integer
        //二维数组是元素为一维数组的一维数组，比较器<>里为元素的类型
        //里面要实现compare函数，两个参数为待比较的两个元素，o1在前o2在后
        //这个函数是若return值<0则不动，>0则交换o1和o2，也就是从小到大是前减后，从大到小是后减前
        //注意这里括号是怎么样的
        //不过由于sort对二维数组默认是按照nums[i][0]排序，这里其实多此一举
        Arrays.sort(temp, new Comparator<Integer[]>(){
            public int compare(Integer[] o1, Integer[] o2){
                return o1[0] - o2[0];
            }
        });
        //按照temp[i][0]排好序后，然后逐个进行二分查找找到和为target的项
        for(int i = 0; i < nums.length; i++){
            int index = search(temp, target-temp[i][0]);
            if(index != -1){
                //题中要求不能找自己，如果找到的是它自己那应该看看前面和后面
                //注意防止数组越界，可以借助&&的短路
                if(index != i){
                    ans[0] = temp[i][1];
                    ans[1] = temp[index][1];
                    return ans;
                }else{
                    if(index > 0 && temp[index-1][0] == temp[index][0]){
                        ans[0] = temp[i][1];
                        ans[1] = temp[index-1][1];
                        return ans;
                    }else if(index < nums.length-1 && temp[index+1][0] == temp[index][0]){
                        ans[0] = temp[i][1];
                        ans[1] = temp[index+1][1];
                        return ans;
                    }
                }
            }   
        }
        return ans;
    }

    public static void main(String[] args) {
        T0001 t = new T0001();
        int[] nums = {3,3};
        int target = 6;
        int[] ans = t.twoSum(nums, target);
        System.out.printf("%d,%d",ans[0],ans[1]);
    }
}
