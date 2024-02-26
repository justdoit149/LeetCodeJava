import java.util.ArrayList;
import java.util.List;

public class T0114 {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        List<TreeNode> temp = new ArrayList<>();
        dfs(temp, root);
        int n = temp.size();
        for(int i = 0; i < n-1; i++){
            temp.get(i).left = null;
            temp.get(i).right = temp.get(i+1);
        }
        temp.get(n-1).left = null;
        temp.get(n-1).right = null;
    }
    public void dfs(List<TreeNode> temp, TreeNode root){
        if(root == null){
            return;
        }
        temp.add(root);
        dfs(temp, root.left);
        dfs(temp, root.right);
    }

    // // O(1)额外空间的官方写法
    // public void flatten(TreeNode root) {
    //     TreeNode curr = root;
    //     while (curr != null) {
    //         if (curr.left != null) {
    //             TreeNode next = curr.left;
    //             TreeNode predecessor = next;
    //             while (predecessor.right != null) {
    //                 predecessor = predecessor.right;
    //             }
    //             predecessor.right = curr.right;
    //             curr.left = null;
    //             curr.right = next;
    //         }
    //         curr = curr.right;
    //     }
    // }


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
