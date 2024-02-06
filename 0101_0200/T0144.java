import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class T0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        // String s = "";
        // s.length();
        // int[] s0 = {0};
        // s0.length + 1;
        while(true){
            while(temp != null){
                ans.add(temp.val);
                stack.add(temp);
                temp = temp.left;
            }
            if(!stack.isEmpty()) {
                temp = stack.pop().right;
            }else{
                return ans;
            }
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
