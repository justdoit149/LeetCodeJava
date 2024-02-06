public class T0027 {
    //与0026几乎一样
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        T0027 t = new T0027();
        int[] nums = {1,1,3,3,5,2,5,3,4};
        System.out.println(t.removeElement(nums, 5));
    }
}
