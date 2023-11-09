import java.util.List;
import java.util.ArrayList;
//DP。从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
public class T0095 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            //枚举：每个节点是根节点的情况，左边节点构成左子树、右边构成右子树
            //递归获取所有左、右子树，放在list里。然后后面各选一个枚举。
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
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
        T0095 t = new T0095();
        t.generateTrees(3);
    }
}
