//典型DP，根据根节点DP。n个节点可以看成一个为根、剩下n-1个节点组成左树和右树。
//方法二：这个数列实际上是卡特兰数。递推公式为C[n+1] = C[n] * 2(2n+1)/(n+2);
public class T0096 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        
    }
}
