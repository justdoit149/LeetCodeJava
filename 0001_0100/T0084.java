import java.util.ArrayDeque;
import java.util.Deque;
//典型的单调栈应用
//无从下手时，一个很好的思路是：先想暴力怎么做，然后思考暴力里有哪些步骤是可以合并和优化的。
//本题暴力有两种思路，一个是枚举底，对每个底找这个范围内的最小值作为高，这是O(n^3)
//第二种是枚举高，分别以每一个作为高，然后在其左右分别找到第一个小于它的，就是底的两端，这是O(n^2)
//很显然第二种更靠谱也更好优化。（第一个难点：能想到是按高枚举而不是按底）

//然后以向左找边界为例，我们不关心中间是什么，只关心第一个比当前位置矮的位置的下标是什么，
//因此我们可以维护这样一个栈：它用来存储向某个方向的位置下标
//具体规则是：height[i]，我们看栈顶元素指向的高heights[stack.peek()]
//如果height[i]不大于它，那它不是边界，并且height[i]后面的元素也不会以它为边界
//因此它就用不到了，直接pop弹出它，直到遇到第一个符合的，那它指向的就是边界位置（或者栈空了，此时为-1）
//然后当前heights[i]是可能作为后续的边界的，就把i压入栈
//这样，栈里的下标指向的元素可以构成一个新的单调栈。
public class T0084 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = 0;
        //栈用deque即可
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] l = new int[n];
        int[] r = new int[n];
        for(int i = 0; i < n; i++){
            //peek是取栈顶但不弹出，pop是弹出，push是压入
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            l[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();//这个栈可以反复用，清空即可
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            r[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
            ans = Math.max(ans, (r[i] - l[i] - 1) * heights[i]);
        }
        return ans;
    }
}
