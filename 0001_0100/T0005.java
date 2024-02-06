public class T0005 {
    public String longestPalindrome(String s) {
        String ans = s.charAt(0) + "", temp;
        for(int i = 0; i < s.length() - 1; i++){
            temp = find(s,i,i).length()>find(s, i, i+1).length() ? find(s,i,i) : find(s, i, i+1);
            ans = temp.length()>ans.length() ? new String(temp) : ans;
        }
        return ans;
    }
    public String find(String s, int b, int e){
        while(b >= 0 && e < s.length() && s.charAt(b) == s.charAt(e)){
            b--;
            e++;
        }
        if(b == e - 1 && s.charAt(b) != s.charAt(e)){
            return new String();
        }else{
            return s.substring(b+1, e);
        }
    }
    public static void main(String[] args) {
        String s = "babad";
        T0005 test = new T0005();
        System.out.println(test.longestPalindrome(s));
    }
}
