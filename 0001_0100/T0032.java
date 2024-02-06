import java.util.*;

//题意是找最长的匹配的括号序列，嵌套的也是合法的。
//思路：用栈模拟一遍压入、弹出的不是括号，而是括号所在位置的下标。
//这样遍历一遍后，栈内剩余的就是无法匹配的位置，开一个数组，将所有无法匹配的括号的位置全部置1
//这样只要找0的最长长度即可。
public class T0032 {
    public int longestValidParentheses(String s) {
        int[] count = new int[s.length()];
        char c;
        int ans = 0, counter = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty() || s.charAt(stack.peek()) == ')'){
                    stack.push(i);
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            count[stack.peek()] = 1;
            stack.pop();
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] == 0){
                counter++;
                ans = Math.max(ans, counter);
            }else{
                counter = 0;
            }
        }
        return ans;
    }
}
