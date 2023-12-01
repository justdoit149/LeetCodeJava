import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        num temp = null;
        Deque<num> queue = new LinkedList<>();
        queue.add(new num(root,0));
        while(!queue.isEmpty()){
            int len = queue.size();
            int level = queue.peek().level;
            ans.add(0,new LinkedList<>());
            for(int i = 0; i < len; i++){
                temp = queue.pollFirst();
                ans.get(0).add(temp.t.val);
                if(temp.t.left != null){
                    queue.addLast(new num(temp.t.left, level+1));
                }
                if(temp.t.right != null){
                    queue.addLast(new num(temp.t.right, level+1));
                }
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
}
