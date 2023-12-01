public class T0031 {
    public void nextPermutation(int[] nums) {
        int index = -1, temp = 0, n = nums.length;
        for(int i = n - 1; i >= 1; i--){
            if(nums[i] > nums[i-1]){
                index = i;
                break;
            }
        }
        if(index != -1){
            for(int i = n-1; i >= 0; i--){
                if(nums[i] > nums[index-1]){
                    temp = nums[i];
                    nums[i] = nums[index-1];
                    nums[index-1] = temp;
                    break;
                }
            }
            for(int i = index; i < (index + n) / 2; i++){
                temp = nums[i];
                nums[i] = nums[n+index-1-i];
                nums[n+index-1-i] = temp;
            }
        }else{
            for(int i = 0; i < n / 2; i++){
                temp = nums[i];
                nums[i] = nums[n-1-i];
                nums[n-1-i] = temp;
            }
        }
    }
}
