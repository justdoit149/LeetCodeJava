import java.util.ArrayList;
import java.util.List;
//�ҳ�һ����������Ԫ�ص�ȫ���У���Ҫ����
public class T0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> left_number = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            left_number.add((Integer)nums[i]);
        }
        ArrayList<Integer> already_number = new ArrayList<>();
        solve(ans,left_number,already_number);
        return ans;
    }
    //ansΪ����Ҫ���صĽ����left_numberΪʣ�����������Ϊ��ʱ�ݹ�������õ�һ�����У�Ȼ���ٽ�����һ��
    //already_number���Ѿ��γɵ����У���left_number��ʱ�����͵õ���һ�����У���������ans�С�
    public void solve(List<List<Integer>> ans, 
                    ArrayList<Integer> left_number, 
                    ArrayList<Integer> already_number){
        if(left_number.size() == 0){
            ans.add(new ArrayList<>(already_number));
        }
        for(int i = 0; i < left_number.size(); i++){
            //�������ǹؼ�����ʣ�������ѹ���ݴ����С�Ȼ���ٵݹ��ȥ������������������Ż�ȥ
            //����ݹ�Ĺ��̿��Կ�����һ���������
            already_number.add(left_number.get(i));
            left_number.remove(left_number.get(i));
            solve(ans,left_number,already_number);
            left_number.add(i, already_number.get(already_number.size()-1));
            already_number.remove(left_number.get(i));
        }
    }
    public static void main(String[] args) {
        T0046 test = new T0046();
        int[] nums = {1,2};
        List<List<Integer>> ans = test.permute(nums);
        System.out.println(ans.get(0));
    }
}

// //���������۹ٷ����
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();

//         List<Integer> output = new ArrayList<Integer>();
//         for (int num : nums) {
//             output.add(num);
//         }

//         int n = nums.length;
//         backtrack(n, output, res, 0);
//         return res;
//     }

//     public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
//         // ��������������
//         if (first == n) {
//             res.add(new ArrayList<Integer>(output));
//         }
//         for (int i = first; i < n; i++) {
//             // ��̬ά������
//             Collections.swap(output, first, i);
//             // �����ݹ�����һ����
//             backtrack(n, output, res, first + 1);
//             // ��������
//             Collections.swap(output, first, i);
//         }
//     }
// }
