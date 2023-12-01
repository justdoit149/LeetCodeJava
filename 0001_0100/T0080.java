public class T0080 {
    //思路：标记法，由于数据范围不是遍历整个int，我们可以选一个范围外的数作为tag来标记是否移除
    //由于我是想相同的保留前两个，检查也是和它前面两个比较，因此最好是从后往前，避免覆盖而影响
    //然后再双指针遍历，将后面的填补到前面空缺位置。这样要遍历两遍
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
    // //作者：力扣官方题解
    // //由于数组有序，j和i一样那ij之间一定都一样。
    // //这个设计比较巧妙，有效避免了去除元素造成的覆盖问题，不影响后续继续的去重。且只遍历一次。
    // //并且这个扩展性强，保留k个只需要将所有的2改成k就可以了
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
