public class T0003 {
    //dpһ���������Ӵ����ò���������dpһ�������ڽ�β����Ӵ��Ǻܼ򵥵ģ����������һ���������С�
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
