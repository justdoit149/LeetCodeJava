public class T0011 {
    //思考：如果目前左指针在i，右指针在j，不妨左边小，由于短板效应，右边再大也不可能让高增加
    //而如果此时左指针不动，右指针左移的这些情况，高没增加但是底变小了，一定不是最大值
    //所以一开始i在左j在右，谁指向的高小谁就向内移动一步，这样一定不会漏掉最大值
    //这个算法只需要遍历一次数组，时间复杂度O(n)
    //这是典型的“双指针”类型，直接暴力枚举是n^2，相比暴力，每一次指针移动会排除掉O(n)种情况
    //例如左i右j，变成左i右j-1时，就排除掉了i到j、i+1到j、i+2到j……、j-1到j。
    //而暴力枚举是一定能找到的，因此只要保证排除掉的这些里没有待求的情况，则剩下的肯定有max值。
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1,max=0,s;
        while(l<r){
            s = (r-l)*Math.min(height[l],height[r]);
            if(s>max){
                max = s;
            }
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
