public class T0081 {
    public boolean search(int[] nums, int target) {
        for (int i : nums) {
            if(i == target) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
