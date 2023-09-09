public class test {
    public int search(int[] nums, int x){
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == x){
                return mid;
            }else if(nums[mid] > x){
                r = mid - 1;
            }else{
                l = mid + 1;
            }   
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,2,4,5,8,89,929,1111,23444};
        test t = new test();
        System.out.println(t.search(nums, 4)); 
    }

    
}
