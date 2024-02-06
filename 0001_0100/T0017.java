import java.util.ArrayList;
import java.util.List;

public class T0017 {
    String[] chars = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        return letterCombinations(digits, 0,new ArrayList<>());
    }
    public List<String> letterCombinations(String digits,int index,List<String> ans) {
        if(index == digits.length()){
            ans.add(sb.toString());
            return ans;
        }   
        int idx = digits.charAt(index) - '2';
        for(int i = 0; i < chars[idx].length(); i++){
            sb.append(chars[idx].charAt(i));
            letterCombinations(digits, index+1, ans);
            sb.deleteCharAt(index);
        }
        return ans;
    }
    public static void main(String[] args) {
        T0017 t = new T0017();
        System.out.println(t.letterCombinations("249").toString());
    }
    
}
