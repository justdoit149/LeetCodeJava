public class T0003 {
    //dp一个区间的最长子串不好操作，但是dp一个区间内结尾的最长子串是很简单的，且真正的最长一定在这其中。
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int ans = 1;
        dp[0] = 1;
        for(int i = 1; i < s.length(); i++){
            for(int j = i-1; j >= i - dp[i-1]; j--){
                if (s.charAt(i) != s.charAt(j)){
                    dp[i]++;
                }else{
                    break;
                }
            }
            dp[i]++;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        T0003 test = new T0003();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));

    }
}
