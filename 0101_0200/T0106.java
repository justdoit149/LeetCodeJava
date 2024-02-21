public class T0106 {
    int n;
    int[] in_nums, post_nums;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in_nums = inorder;
        post_nums = postorder;
        n = inorder.length;
        return build(0, n-1, 0, n-1);
    }

    public TreeNode build(int post_l, int post_r, int in_l, int in_r){
        if(post_l > post_r){
            return null;
        }
        int mid = in_l;
        while(post_nums[post_r] != in_nums[mid]){
            mid++;
        }
        TreeNode ans = new TreeNode(in_nums[mid]);
        ans.left = build(post_l, post_l+mid-in_l-1, in_l, mid-1);
        ans.right = build(post_l+mid-in_l, post_r-1, mid+1, in_r);
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
