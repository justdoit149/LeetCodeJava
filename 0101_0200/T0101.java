//判断二叉树是否对称：即判断左右子树是否镜像对称，可以递归或迭代实现。
public class T0101{
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric2(root.left, root.right);
    }
    public boolean isSymmetric2(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null || root2 == null || root1.val != root2.val){
            return false;
        }else{
            return isSymmetric2(root1.left, root2.right) && isSymmetric2(root1.right, root2.left);
        }
    }
    // //力扣官方解答。迭代做法。
    // public boolean check(TreeNode u, TreeNode v) {
    //     Queue<TreeNode> q = new LinkedList<TreeNode>();
    //     q.offer(u);
    //     q.offer(v);
    //     while (!q.isEmpty()) {
    //         u = q.poll();
    //         v = q.poll();
    //         if (u == null && v == null) {
    //             continue;
    //         }
    //         if ((u == null || v == null) || (u.val != v.val)) {
    //             return false;
    //         }
    //         q.offer(u.left);
    //         q.offer(v.right);
    //         q.offer(u.right);
    //         q.offer(v.left);
    //     }
    //     return true;
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