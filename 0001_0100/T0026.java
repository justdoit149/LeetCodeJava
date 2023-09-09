import java.util.ArrayList;

public class T0026 {
    // 这里试图开一个数组抄过来再抄回去
    // 其实可以滚动式，初始k=1，在原数组里循环i。
    // 一旦nums[i-1]和nums[i]不相等则nums[k] = nums[i]然后k++
    public int removeDuplicates(int[] nums) {
        int k=0;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != temp.get(k)){
                temp.add(nums[i]);
                k++;
            }
        }
        for(int i = 0; i < temp.size(); i++){
            nums[i] = temp.get(i);
        }
        return temp.size();
    }

    public static void main(String[] args) {
        T0026 t = new T0026();
        int[] nums = {1,1,3,3,3,4};
        System.out.println(t.removeDuplicates(nums));
    }
}
