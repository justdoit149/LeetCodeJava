public class T0075 {
    //两趟遍历的话，最显然的是直接计数然后重写，类似桶计数法，因为数据少而数组大
    //如果一趟遍历的话可以两个指针，一个l在前面用于交换0，一个r在后面用于交换2，
    //逐个for(int i = 0; i < n; i++)遍历，如果遇到0则向前交换，l++，然后i--(用于判断交换过来的数)
    //遇到2则向后交换，遇到1不变
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }
        for(int i = 0; i < count[0]; i++){
            nums[i] = 0;
        }
        for(int i = count[0]; i < count[0] + count[1]; i++){
            nums[i] = 1;
        }
        for(int i = count[0] + count[1]; i < nums.length; i++){
            nums[i] = 2;
        }
    }   
}
