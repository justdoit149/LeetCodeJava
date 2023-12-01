public class T0098 {
    //不能只看左右节点，必须看左右子树的最大/最小。反例是3——1,4——null,null,2,5(按层).
    //虽然如果不是二叉搜索树的话，这两个函数找到的不一定是最大/最小值，但递归下去总能出现不满足的。
    //所以这个写法虽然看上去不太合理，但实际上是正确的。
    //另一种更简单的方法是，用一个线性表记录中序遍历的结果，然后看它是否有序。
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && findMax(root.left) >= root.val){
            return false;
        }else if(root.right != null && findMin(root.right) <= root.val){
            return false;
        }else{
            return isValidBST(root.left) && isValidBST(root.right);
        }
    }
    
    public int findMin(TreeNode root){
        if(root == null){
            throw new ArithmeticException();
        }
        if(root.left == null){
            return root.val;
        }else{
            return findMin(root.left);
        }
    }
    public int findMax(TreeNode root){
        if(root == null){
            throw new ArithmeticException();
        }
        if(root.right == null){
            return root.val;
        }else{
            return findMax(root.right);
        }
    }
    
    // （官方）也可以上下界限制。注意由于数据可能是INT的MAX和MIN，因此上下界需要用LONG。
    // public boolean isValidBST(TreeNode root) {
    //     return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    // }

    // public boolean isValidBST(TreeNode node, long lower, long upper) {
    //     if (node == null) {
    //         return true;
    //     }
    //     if (node.val <= lower || node.val >= upper) {
    //         return false;
    //     }
    //     return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
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
