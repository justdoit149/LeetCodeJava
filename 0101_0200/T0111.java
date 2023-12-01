//找叶子的最小深度，不能在深度基础上把max改为min，必须得确保是叶子（如1,null,2的1不是叶子）
//两种方法：深度优先看左右子树的叶子最小深度，广度优先第一个叶子的深度
//广度优先更好，虽然都是O(n)，但广度优先一般早早就结束了（遇见的第一个叶子），深度优先每个都要遍历。

import java.util.LinkedList;
import java.util.Queue;

public class T0111 {
    // public int minDepth(TreeNode root) {
    //     if(root == null) return 0;
    //     if(root.left == null && root.right != null) return minDepth(root.right) + 1;
    //     if(root.left != null && root.right == null) return minDepth(root.left) + 1;
    //     return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    // }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while(!queue.isEmpty()){
            height++;
            int size = queue.size();
            TreeNode temp = null;
            for(int i = 0; i < size; i++){
                temp = queue.poll();
                if(temp.left == null && temp.right == null) return height;
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
        return -1;
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
