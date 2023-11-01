import java.util.ArrayList;
import java.util.List;

//二叉树的遍历有递归和迭代两种方法，递归好写，就只写出dfs的逻辑即可，隐式地维护了栈
//而迭代做法是手动把这个栈模拟出来。

public class T0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        find(root, ans);
        return ans;
    }
    public void find(TreeNode node, List<Integer> ans){
        if(node == null){
            return;
        }
        find(node.left, ans);
        ans.add(node.val);
        find(node.right, ans);
    }
    class TreeNode {
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
