import java.util.*;

//�����������ƥ����������У�Ƕ�׵�Ҳ�ǺϷ��ġ�
//˼·����ջģ��һ��ѹ�롢�����Ĳ������ţ�������������λ�õ��±ꡣ
//��������һ���ջ��ʣ��ľ����޷�ƥ���λ�ã���һ�����飬�������޷�ƥ������ŵ�λ��ȫ����1
//����ֻҪ��0������ȼ��ɡ�
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
    public static void main(String[] args) {
        
    }
}
