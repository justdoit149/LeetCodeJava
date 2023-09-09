public class T0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = 0, n = 0;
        int[] nums = new int[nums1.length+nums2.length];
        int l = nums.length;
        for(int i = 0; i < l; i++){
            if(m == nums1.length){
                nums[i] = nums2[n];
                n++;
            }else if(n == nums2.length){
                nums[i] = nums1[m];
                m++;
            }else if(nums1[m] < nums2[n]){
                nums[i] = nums1[m];
                m++;
            }else{
                nums[i] = nums2[n];
                n++;
            }
        }
        return (nums[(l-1)/2]+nums[l-(l+1)/2]) * 1.0 / 2;
    }

    public static void main(String[] args) {
        
    }

}
