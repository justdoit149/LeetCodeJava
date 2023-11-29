import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//广度优先算法：按层遍历树。用一个队列，初始将根入队，不断将队首出队、并将其子节点入队，直到队列为空
//如果需要按照层数分类，需要记录层数：入队的元素的层数是出队元素（父节点）的层数+1。
public class T0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        num temp = null;
        Queue<num> queue = new LinkedList<>();//广度优先的队列，用LinkedList实现。
        queue.add(new num(root,0));
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.level >= ans.size()){
                ans.add(new ArrayList<>());
            }
            ans.get(temp.level).add(temp.t.val);
            if(temp.t.left != null){
                queue.add(new num(temp.t.left,temp.level+1));
            }
            if(temp.t.right != null){
                queue.add(new num(temp.t.right,temp.level+1));
            }
        }
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
        T0102 t = new T0102();
        t.levelOrder(t.new TreeNode(12));
    }
}
