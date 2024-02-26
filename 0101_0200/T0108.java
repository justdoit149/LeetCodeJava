

public class T0108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int l, int r) {
        if(l > r){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode ans = new TreeNode(nums[mid]);
        ans.left = build(nums, l, mid-1);
        ans.right = build(nums, mid+1, r);
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
