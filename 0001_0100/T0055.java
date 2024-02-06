//从后往前，找到第一个能到达当前位置的来更新r下标。因为假如远的、近的都能到，那远的一定也能到近的
//但是从前往后是不能这么找的，前面走到最近的不一定能走到远的。
//当然也可以每次选最大的步，即如果是从左往右找的话那从右往左遇到第一个能到的点来更新。
//但是这样时间复杂度更高，是O(n^2)级别

public class T0055 {
    public boolean canJump(int[] nums) {
        int r = nums.length - 1, l;
        while(r > 0){
            for(l = r - 1; l >= 0; l--){
                if(nums[l] + l >= r){
                    r = l;
                    break;
                }
            }
            if(l == -1) return false;
        }
        return true;
    }
}
