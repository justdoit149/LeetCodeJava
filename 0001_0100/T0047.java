import java.util.*;

class T0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> left_number = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            left_number.add((Integer)nums[i]);
        }
        ArrayList<Integer> already_number = new ArrayList<>();
        solve(ans,left_number,already_number);
        return ans;
    //ans为最终要返回的结果，left_number为剩余的数，当它为空时递归结束、得到一种排列，然后再进行下一种
    //already_number是已经形成的排列，当left_number空时，它就得到了一个排列，将它加入ans中。
    
    }
    public void solve(List<List<Integer>> ans, 
                    ArrayList<Integer> left_number, 
                    ArrayList<Integer> already_number){
        if(left_number.size() == 0){
            ans.add(new ArrayList<>(already_number));
        }
        int[] same_temp = new int[left_number.size()];
        for(int i = 0; i < left_number.size(); i++){
            //去重：同层如果重复了就不用看了
            same_temp[i] = left_number.get(i);
            boolean check_same = false;
            for(int j = 0; j < i; j++){
                if(same_temp[i] == same_temp[j]){
                    check_same = true;
                }
            }
            if(check_same == true){
                continue;
            }
            //注意：这里这些列表里的数据类型都是Integer
            //而remove如果参数是int视为下标，参数是Integer视作移除这个值，它会自己找
            //所以有重复的时候是必须用下标的，它找的和你想移除的不一样。
            already_number.add(left_number.get(i));
            left_number.remove(i);
            solve(ans,left_number,already_number);
            left_number.add(i, already_number.get(already_number.size()-1));
            already_number.remove(already_number.size()-1);
        }
    }
}