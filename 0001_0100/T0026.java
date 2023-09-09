import java.util.ArrayList;

public class T0026 {
    // ������ͼ��һ�����鳭�����ٳ���ȥ
    // ��ʵ���Թ���ʽ����ʼk=1����ԭ������ѭ��i��
    // һ��nums[i-1]��nums[i]�������nums[k] = nums[i]Ȼ��k++
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
