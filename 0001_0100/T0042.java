public class T0042 {
    // //方法一：直接法（以下是我第一遍做写的代码）
    // //首先我们的思路是思考什么样的情况能装水，很容易想到它应该在两个比较高的东西之间
    // //我们可以设一个l和r指向能装水的区间。经过思考我们发现这个区间的左端点为一个极大值
    // //然后r = l+1然后不断r++直到找到某个height[r] >= height[l]，这样就在它们两个之间装水
    // //水量取决于端点较短的减去当前位置的，然后相加。之后让l = r继续，直到到最右端
    // //如果向右找不到大于等于当前高度的，那就取最高的然后计算他们之间的装水量，然后用它更新l。
    // //这种做法比较容易想到，但代码写起来相对繁琐且细节较多，需要讨论各种边界条件
    // public int trap(int[] height) {
    //     int ans = 0;
    //     int l = 0, r = 0, R = height.length-1, max_temp = 0, max_temp_index = 0;
    //     if(height.length < 3){
    //         return 0;
    //     }
    //     while(l<R){
    //         if(l > 0 && height[l] >= height[l-1] && height[l] >= height[l+1]){
    //             break;
    //         }else if(l == 0 && height[l] >= height[l+1]){
    //             break;
    //         }
    //         l++;
    //     }
    //     while(l<R){         
    //         r = l+1;
    //         max_temp = 0;
    //         while(r<=R){
    //             if(height[r] >= height[l]){
    //                 max_temp_index = r;
    //                 max_temp = height[r];
    //                 break;       
    //             }else if(height[r] >= max_temp){
    //                 max_temp_index = r;
    //                 max_temp = height[r];
    //             }
    //             r++;
    //         }
    //         for(int i = l+1; i <= max_temp_index-1; i++){
    //             if(Math.min(height[l], height[max_temp_index]) > height[i]){
    //                 ans += Math.min(height[l], height[max_temp_index]) - height[i];
    //             }
    //         }
    //         l = max_temp_index;
    //     }
    //     return ans;
    // }

    //方法二：动态规划做法（推荐）（以下是我提交完看到自己时间太慢，稍加思考后想到的做法）
    //先只考虑某一个位置index的装水量，取决于它左边最高值height[i]和右面最高值height[j]
    //然后装水量就是min(height[i],height[j]) - height[index]，当然如果它小于0那就是0。
    //那这个最高值怎么找呢?很显然，位置i的左边最高值leftMax[i] = max(leftMax[i-1],height[i-1])
    //右边就是rightMax[i] = max(rightMax[i+1],height[i+1])。
    //这样我们就可以动态规划了，只需要从前往后和从后往前各自分别遍历这两个数组，然后求和就行啦。
    public int trap(int[] height){
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int ans = 0, temp = 0;
        for(int i = 1; i < leftMax.length; i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        for(int i = rightMax.length-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }
        for(int i = 1; i < height.length-1; i++){
            temp = Math.min(leftMax[i], rightMax[i]);
            if(temp > height[i]){
                ans += temp - height[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        T0042 test = new T0042();
        int[] nums = {8,2,8,9,0,1,7,7,9};
        int ans = test.trap(nums);
        System.out.println(ans);
    }
}
