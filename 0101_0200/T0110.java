//判断是否平衡，可以自顶向下递归或自底向上递归。
//但是自顶向下的缺点是计算左右子树的树高后，在进一步判断左右子树时还要继续计算树高，导致树高反复计算
//复杂度平均是O(nlogn)，最差是O(n^2)（因为在比较平衡时层数为O(logn)，接近链状时是O(n)）
//所以采用方案二：用返回值同时保留树高和是否平衡的信息：int返回值，-1为不平衡，n（n>=0）为平衡的树高
//并且自底向上，先向下递归到尽头后再看左右树高并求出本树树高（即先调用递归函数再计算，类似后序遍历）。
//这样复杂度就是O(n)。
public class T0110 {
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null) return true;
    //     if(Math.abs(height(root.left)-height(root.right)) > 1) return false;
    //     return isBalanced(root.left) && isBalanced(root.right);
    // }
    // public int height(TreeNode root){
    //     if(root == null) return 0;
    //     return Math.max(height(root.left), height(root.right)) + 1;
    // }
    public boolean isBalanced(TreeNode root) {
        //看上去简单但是如果提前不知道的话不容易朝这个方向想，所以记住！！
        return isBalanced_height(root) != -1;    
    }
    public int isBalanced_height(TreeNode root){
        if(root == null) return 0;
        int height_l = isBalanced_height(root.left);
        int height_r = isBalanced_height(root.right);
        if(height_l == -1 || height_r == -1 || Math.abs(height_l-height_r) > 1){
            return -1;
        }
        return Math.max(height_l, height_r) + 1;
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
    public static void main(String[] args) {
        
    }
}
