// 可以BFS也可以DFS
// 核心思想是对树进行一次遍历，在遍历时记录从根节点到当前节点的路径和，以防止重复计算。
public class T0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }else{
            int newTarget = targetSum-root.val;
            return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
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
