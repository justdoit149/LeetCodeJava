import java.util.ArrayList;
import java.util.List;
//找出一个集合若干元素的全排列，重要！！
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
    //ans为最终要返回的结果，left_number为剩余的数，当它为空时递归结束、得到一种排列，然后再进行下一种
    //already_number是已经形成的排列，当left_number空时，它就得到了一个排列，将它加入ans中。
    public void solve(List<List<Integer>> ans, 
                    ArrayList<Integer> left_number, 
                    ArrayList<Integer> already_number){
        if(left_number.size() == 0){
            ans.add(new ArrayList<>(already_number));
        }
        for(int i = 0; i < left_number.size(); i++){
            //这五行是关键，将剩余数逐个压入暂存排列、然后再递归地去处理，最后处理完后将这个数放回去
            //这个递归的过程可以看成是一种深度优先
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

// //以下是力扣官方题解
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
//         // 所有数都填完了
//         if (first == n) {
//             res.add(new ArrayList<Integer>(output));
//         }
//         for (int i = first; i < n; i++) {
//             // 动态维护数组
//             Collections.swap(output, first, i);
//             // 继续递归填下一个数
//             backtrack(n, output, res, first + 1);
//             // 撤销操作
//             Collections.swap(output, first, i);
//         }
//     }
// }
