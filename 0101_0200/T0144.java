import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class T0144 {
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     preOrder(ans,root);
    //     return ans;
    // }

    // public void preOrder(List<Integer> ans, TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     ans.add(root.val);
    //     preOrder(ans, root.left);
    //     preOrder(ans, root.right);
    // }

    // public List<Integer> preorderTraversal(TreeNode root){
    //     List<Integer> ans = new ArrayList<>();
    //     Stack<TreeNode> stack = new Stack<>();
    //     if(root == null) return ans;
    //     TreeNode node = root;
    //     while (!stack.isEmpty() || node != null) {
    //         while (node != null) {
    //             ans.add(node.val);
    //             stack.push(node);
    //             node = node.left;
    //         }
    //         node = stack.pop();
    //         node = node.right;
    //     }
    //     return ans;
    // }

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        TreeNode nowPointer = root;
        TreeNode prePointer = null;
        while(nowPointer != null){
            if(nowPointer.left == null){
                ans.add(nowPointer.val);
                prePointer = nowPointer;
                nowPointer = nowPointer.right;
            }else{
                prePointer = nowPointer.left;
                while(prePointer.right != null && prePointer.right != nowPointer){
                    prePointer = prePointer.right;
                }
                if(prePointer.right == null){
                    ans.add(nowPointer.val);
                    prePointer.right = nowPointer;
                    prePointer = nowPointer;
                    nowPointer = nowPointer.left;
                }else{
                    prePointer.right = null;
                    nowPointer = nowPointer.right;
                }
            }
        }
        return ans;
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
