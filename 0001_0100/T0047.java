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
    //ansΪ����Ҫ���صĽ����left_numberΪʣ�����������Ϊ��ʱ�ݹ�������õ�һ�����У�Ȼ���ٽ�����һ��
    //already_number���Ѿ��γɵ����У���left_number��ʱ�����͵õ���һ�����У���������ans�С�
    
    }
    public void solve(List<List<Integer>> ans, 
                    ArrayList<Integer> left_number, 
                    ArrayList<Integer> already_number){
        if(left_number.size() == 0){
            ans.add(new ArrayList<>(already_number));
        }
        int[] same_temp = new int[left_number.size()];
        for(int i = 0; i < left_number.size(); i++){
            //ȥ�أ�ͬ������ظ��˾Ͳ��ÿ���
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
            //ע�⣺������Щ�б�����������Ͷ���Integer
            //��remove���������int��Ϊ�±꣬������Integer�����Ƴ����ֵ�������Լ���
            //�������ظ���ʱ���Ǳ������±�ģ����ҵĺ������Ƴ��Ĳ�һ����
            already_number.add(left_number.get(i));
            left_number.remove(i);
            solve(ans,left_number,already_number);
            left_number.add(i, already_number.get(already_number.size()-1));
            already_number.remove(already_number.size()-1);
        }
    }
    public static void main(String[] args) {
        
    }
}