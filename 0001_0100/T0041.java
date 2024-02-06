public class T0041 {
    //重要！！！分析思路
    //题目要求时间O(n)，额外空间O(1)，也就是一定要利用原数组来想办法存储信息
    //类比桶计数，很容易想到在原来的位置打tag来表示有没有出现
    //这样遍历一遍并对出现过的数字x，若x在1-n范围内，就在相应的nums[x-1]位置打上标记
    //（因为数组下标是0到n-1）
    //这样第二遍再遍历就找第一个没打tag的就行了，都打了tag就返回n+1.
    //但是难点是打tag不能破坏原有数据，如nums[3] == 9那不能随便修改nums[9-1]，因为nums[9-1]里也存着数
    //我们可以考虑用负号来打tag，那首先应该让原来数组里就有的非正数变成一个较大的数（比如n+1）
    //（因为非正数我们不关心它是多少，没影响）
    public int firstMissingPositive(int[] nums) {
        int N = nums.length+1;
        //第一次，先将非正数变n+1
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){//注意0
                nums[i] = N;
            }
        }
        //第二次，遇见绝对值在1-n那就把对应下标的相应位置变成负的（它原来也可能是负的，因为可能出现多次）
        //因此不能简单加符号，应该是其绝对值加负号
        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i]) >= 1 && Math.abs(nums[i]) < N){
                int index = Math.abs(nums[i])-1;
                nums[index] = - Math.abs(nums[index]);
            }
        }
        //第三遍，找第一个大于0、也就是第一个没出现过的
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return N;
    }
}
