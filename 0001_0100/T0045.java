public class T0045 {
    //贪心，思路一：i从nums.length-1到0，看i前面最远的能到i的位置。
    //复杂度O(n^2)
    //思路二是正向找，找当前步应该走到哪、那个位置能走到的距离最远,
    //比如当前位置是index = 3，nums[3] = 5，在4-8的位置为3,2,7,1,3，
    //这样nums[6] + 6 == 13是最大的，因此index更新到6
    //复杂度O(n)。
    public int jump(int[] nums) {
        int index = nums.length - 1;
        int ans = 0;
        while(index > 0){
            for(int i = 0; i < index; i++){
                if(i + nums[i] >= index){
                    index = i;
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {2};
        T0045 test = new T0045();
        System.out.println(test.jump(nums));
    }
}
