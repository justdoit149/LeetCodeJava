
public class T0014 {
    public String longestCommonPrefix(String[] strs) {
        char[] ans = new char[205];
        boolean check = true;
        int min_len = 10005, len = 0;
        for(int i = 0; i < strs.length; i++){
            min_len = Math.min(min_len, strs[i].length());
        }
        for(int i = 0; i < min_len; i++){
            char temp = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++){
                if(temp != strs[j].charAt(i)){
                    check = false;
                    break;
                }
            }
            if(check == false){
                break;
            }else{
                ans[i] = temp;
                len++;
            }
        }
        String ans0 = "";
        for(int i = 0; i < len; i++){
            ans0 = ans0 + ans[i] + "";
        }
        return ans0;
    }
}
