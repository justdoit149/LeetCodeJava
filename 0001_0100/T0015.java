import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
//˼·����һ�������������ĺ�ҪΪ��һ�����෴��
//�ź������������������Ϊ-nums[i]�ģ������˫ָ�룬С�����ƶ���ߡ��������ƶ��ұ�
//���Ӷ���O(n^2)
//ע��ȥ�ء�����nums�Ѿ��ź�����nums[i]<=nums[l]<=nums[r]
//�����ȫ�������ö�ά���鴦��Ȼ��Զ�ά��������Ĭ���ȿ���һ���ٿ��ڶ����ٵ����У�Ȼ��ȥ��
//ȥ����֮���ٿ�����ArrayList�����̫�ܶ�����Ƚϸ��ӵ�ArrayList����

public class T0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        //List�Ǹ��ӿڣ�����ʵ������Arraylist����ʵ��������ӿڣ����������Ҫnew����ArrayList.
        //����ʱans��ΪList���ӿ�������Ӧ���������Ժͷ�������ͨ������
        //����ʱans��ΪArrayList����Ӧ�ķ����Ѿ�ʵ�֣�����ȷ���С�
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int l,r,sum;
        for(int i = 0; i < nums.length-2; i++){
            //ȥ��1���׸�һ���Ļ����ҵ��Ŀ϶��Ǻ�֮ǰ�ҹ����ظ���
            //������׸�����һ���ǿ϶������ظ��ģ�������ﱣ֤�����for����n�β�������ظ�
            //������[-3,-3,0,1,2,3]�����
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
                    //Array��ArrayList��������Arrays.asList�����������������д���������Ԫ��
                    //Ҳ�����Ƕ�������������������������ǻ����������͵����顣
                    List<Integer> temp = Arrays.asList(nums[i],nums[l],nums[r]);
                    //������ע�⣺����������==����������ֻ����.equals()�е�
                    if(ans.isEmpty() || !ans.get(ans.size()-1).equals(temp)){
                        //ȥ��2����iʱ��һ���ظ���ֻ����������
                        //�����Ѿ�nums�ź��������������ظ�һ�������ڵģ�ֻ��Ҫ���б�����
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
