public class T0070 {
    public int climbStairs(int n) {
        int[] ans = new int[50];
        ans[1] = 1;
        ans[2] = 2;
        for(int i = 3; i <= n; i++){
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }
}
