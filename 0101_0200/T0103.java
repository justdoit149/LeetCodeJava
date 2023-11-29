import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

//deque双端队列。
//方案一：在上一个题正常遍历的基础上，将奇数层翻转（Collections.reverse(list)）。开销较大
//方案二：ans列表用LinkedList实现，根据层号决定添加在行首还是行尾。
//方案三：用双端队列：奇数层出队时，队尾出队首入；偶数层出队时，队首出队尾入。
//最好利用queue.size()获得元素个数后，通过计数实现一次出队一行然后入队下一行。
//方案四：用两个栈。奇数行和偶数行各用一个。
//但是实际上前两个是伪之字形遍历，遍历顺序还是正常的只是记录顺序改过来了。后两个方案才是真之字遍历。
//本题采用方案三。
public class T0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        num temp = null;
        Deque<num> queue = new LinkedList<>();
        queue.add(new num(root,0));
        while(!queue.isEmpty()){
            int len = queue.size();
            int level = queue.peek().level;//当前层层号
            ans.add(new LinkedList<>());
            for(int i = 0; i < len; i++){//一次处理一层。
                if(level % 2 == 0){
                    temp = queue.pollFirst();
                    if(temp.t.left != null){
                        queue.addLast(new num(temp.t.left, level+1));
                    }
                    if(temp.t.right != null){
                        queue.addLast(new num(temp.t.right, level+1));
                    }
                }else{
                    temp = queue.pollLast();
                    if(temp.t.right != null){//从右往左的话，子节点也是先右后左。
                        queue.addFirst(new num(temp.t.right, level+1));
                    }
                    if(temp.t.left != null){
                        queue.addFirst(new num(temp.t.left, level+1));
                    }
                }
                ans.get(level).add(temp.t.val);
            }
        }
        //每次出和入必须是在不同方向的，如在first出就得在last入。
        return ans;
    }
    
    private class num {//需要记录（层，值）
        TreeNode t;
        int level;
        num(TreeNode t, int level){
            this.t = t;
            this.level = level;
        }
    }
    
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }
}
