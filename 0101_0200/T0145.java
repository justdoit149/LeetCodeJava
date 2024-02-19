import java.util.ArrayList;
import java.util.List;
// import java.util.Stack;



public class T0145 {
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     postOrder(ans, root);
    //     return ans;
    // }

    // public void postOrder(List<Integer> ans, TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     postOrder(ans, root.left);
    //     postOrder(ans, root.right);
    //     ans.add(root.val);
    // }

    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode node = root, prenode = null;
    //     if(root == null) {
    //         return ans;
    //     }
    //     while(node != null || !stack.isEmpty()){
    //         while(node != null){
    //             stack.push(node);
    //             node = node.left;
    //         }
    //         node = stack.pop();
    //         if(node.right == null || node.right == prenode){
    //             ans.add(node.val);
    //             prenode = node;
    //             node = null;
    //         }else{
    //             stack.push(node);
    //             node = node.right;
    //         }
    //     }
    //     return ans;
    // }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root, temp_node = null;
        if(root == null){
            return ans;
        }
        while(node != null){
            temp_node = node.left;
            if(temp_node != null){
                while(temp_node.right != null && temp_node.right != node){
                    temp_node = temp_node.right;
                }
                if(temp_node.right == null){
                    temp_node.right = node;
                    node = node.left;
                    continue;
                }else{
                    temp_node.right = null;
                    addPath(ans, node.left);
                }
            }
            node = node.right;
        }
        addPath(ans, root);
        return ans;
    }

    // 倒序输出从当前节点的左子节点到该前驱节点这条路径上的所有节点。
    public void addPath(List<Integer> ans, TreeNode node) {
        int count = 0;
        while (node != null) {
            count++;
            ans.add(node.val);
            node = node.right;
        }
        int left = ans.size() - count, right = ans.size() - 1;
        while (left < right) {
            int temp = ans.get(left);
            ans.set(left, ans.get(right));
            ans.set(right, temp);
            left++;
            right--;
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
