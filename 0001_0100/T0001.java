import java.util.Arrays;
import java.util.Comparator;

//����֮�����ֲ��ң�������Ȼ����ֲ����ҵ�����Ҫ��ģ�ע�������Ҫ��¼ԭ�����±���ʲô
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
        //��ά���飬temp[i][0]��¼nums[i]��temp[i][1]��¼ԭ�����±�i
        Integer[][] temp = new Integer[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            temp[i][0] = nums[i];
            temp[i][1] = i;
        }
        //�������������Ҳ���ǰ���temp[i][0]��С��������
        //�����Զ�������Ķ������Ϊ�������ͣ����tempҪ�����Integer
        //��ά������Ԫ��Ϊһά�����һά���飬�Ƚ���<>��ΪԪ�ص�����
        //����Ҫʵ��compare��������������Ϊ���Ƚϵ�����Ԫ�أ�o1��ǰo2�ں�
        //�����������returnֵ<0�򲻶���>0�򽻻�o1��o2��Ҳ���Ǵ�С������ǰ���󣬴Ӵ�С�Ǻ��ǰ
        //ע��������������ô����
        //��������sort�Զ�ά����Ĭ���ǰ���nums[i][0]����������ʵ���һ��
        Arrays.sort(temp, new Comparator<Integer[]>(){
            public int compare(Integer[] o1, Integer[] o2){
                return o1[0] - o2[0];
            }
        });
        //����temp[i][0]�ź����Ȼ��������ж��ֲ����ҵ���Ϊtarget����
        for(int i = 0; i < nums.length; i++){
            int index = search(temp, target-temp[i][0]);
            if(index != -1){
                //����Ҫ�������Լ�������ҵ��������Լ���Ӧ�ÿ���ǰ��ͺ���
                //ע���ֹ����Խ�磬���Խ���&&�Ķ�·
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
