import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums = {-122,-12,-1,0,12,13,111,1333};
        System.out.println(Arrays.binarySearch(nums, -1));
        System.out.println(Arrays.binarySearch(nums, -2));
        System.out.println(Arrays.binarySearch(nums, -11111));
        System.out.println(Arrays.binarySearch(nums, 111111));
    }

    
}
