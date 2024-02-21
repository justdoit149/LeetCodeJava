// 在中序遍历中对根节点进行定位时，可以先扫描一遍、用哈希表来快速定位根节点。
// 此后每次就只需要O(1)的时间对根节点进行定位了。
// 同样是有递归和迭代两种写法（但迭代的写法有点难懂）

public class T0105 {
    int n;
    int[] pre_nums, in_nums;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre_nums = preorder;
        in_nums = inorder;
        n = preorder.length;
        return build(0, n-1, 0, n-1);
    }

    public TreeNode build(int pre_l, int pre_r, int in_l, int in_r){
        if(pre_l > pre_r){
            return null;
        }
        int mid = in_l;
        while(pre_nums[pre_l] != in_nums[mid]){
            mid++;
        }
        TreeNode ans = new TreeNode(in_nums[mid]);
        ans.left = build(pre_l+1, pre_l+mid-in_l, in_l, mid-1);
        ans.right = build(pre_l+mid-in_l+1, pre_r, mid+1, in_r);
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
