public class T0080 {
    //˼·����Ƿ����������ݷ�Χ���Ǳ�������int�����ǿ���ѡһ����Χ�������Ϊtag������Ƿ��Ƴ�
    //������������ͬ�ı���ǰ���������Ҳ�Ǻ���ǰ�������Ƚϣ��������ǴӺ���ǰ�����⸲�Ƕ�Ӱ��
    //Ȼ����˫ָ�����������������ǰ���ȱλ�á�����Ҫ��������
    public int removeDuplicates(int[] nums) {
        int tag = -100000, index = 2;
        for(int i = nums.length - 1; i >= 2; i--){
            if(nums[i] == nums[i-2]){
                nums[i] = tag;
            }
        }
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != tag){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
    // //���ߣ����۹ٷ����
    // //������������j��iһ����ij֮��һ����һ����
    // //�����ƱȽ������Ч������ȥ��Ԫ����ɵĸ������⣬��Ӱ�����������ȥ�ء���ֻ����һ�Ρ�
    // //���������չ��ǿ������k��ֻ��Ҫ�����е�2�ĳ�k�Ϳ�����
    // public int removeDuplicates(int[] nums) {
    //     int n = nums.length;
    //     if (n <= 2) {
    //         return n;
    //     }
    //     int slow = 2, fast = 2;
    //     while (fast < n) {
    //         if (nums[slow - 2] != nums[fast]) {
    //             nums[slow] = nums[fast];
    //             ++slow;
    //         }
    //         ++fast;
    //     }
    //     return slow;
    // }
}
