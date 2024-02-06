public class T0088 {
    //类似0026，同样是滚动处理，不过从前往后会覆盖，因此可以从后往前merge，这样不用开新数组。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for(int i = m+n+1; i >= 0; i--){
            if(m<0){
                nums1[i] = nums2[n];
                n--;
            }else if(n<0){
                nums1[i] = nums1[m];
                m--;
            }else{
                if(nums1[m] < nums2[n]){
                    nums1[i] = nums2[n];
                    n--;
                }else{
                    nums1[i] = nums1[m];
                    m--;
                }
            }
        }
    }

    public static void main(String[] args) {
        T0088 t = new T0088();
        int[] nums1 = {1,2,5,5,76,0,0,0,0,0,0}, nums2 = {-1,3,4,5,5,6};
        t.merge(nums1, 5, nums2, 6);
        for (int i : nums1) {
            System.out.print(i+" ");
        }
    }
}
