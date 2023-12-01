import java.util.ArrayDeque;
import java.util.Deque;
//���͵ĵ���ջӦ��
//�޴�����ʱ��һ���ܺõ�˼·�ǣ����뱩����ô����Ȼ��˼������������Щ�����ǿ��Ժϲ����Ż��ġ�
//���Ⱪ��������˼·��һ����ö�ٵף���ÿ�����������Χ�ڵ���Сֵ��Ϊ�ߣ�����O(n^3)
//�ڶ�����ö�ٸߣ��ֱ���ÿһ����Ϊ�ߣ�Ȼ���������ҷֱ��ҵ���һ��С�����ģ����ǵ׵����ˣ�����O(n^2)
//����Ȼ�ڶ��ָ�����Ҳ�����Ż�������һ���ѵ㣺���뵽�ǰ���ö�ٶ����ǰ��ף�

//Ȼ���������ұ߽�Ϊ�������ǲ������м���ʲô��ֻ���ĵ�һ���ȵ�ǰλ�ð���λ�õ��±���ʲô��
//������ǿ���ά������һ��ջ���������洢��ĳ�������λ���±�
//��������ǣ�height[i]�����ǿ�ջ��Ԫ��ָ��ĸ�heights[stack.peek()]
//���height[i]�����������������Ǳ߽磬����height[i]�����Ԫ��Ҳ��������Ϊ�߽�
//��������ò����ˣ�ֱ��pop��������ֱ��������һ�����ϵģ�����ָ��ľ��Ǳ߽�λ�ã�����ջ���ˣ���ʱΪ-1��
//Ȼ��ǰheights[i]�ǿ�����Ϊ�����ı߽�ģ��Ͱ�iѹ��ջ
//������ջ����±�ָ���Ԫ�ؿ��Թ���һ���µĵ���ջ��
public class T0084 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = 0;
        //ջ��deque����
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] l = new int[n];
        int[] r = new int[n];
        for(int i = 0; i < n; i++){
            //peek��ȡջ������������pop�ǵ�����push��ѹ��
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            l[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();//���ջ���Է����ã���ռ���
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
