import java.util.ArrayList;
import java.util.List;

//在112的基础上，用一个栈式数组来记录当前正在处理的路径。
public class T0113 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();//temp实际上是个栈，用来维护当前路径
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        hasPathSum(root, targetSum);
        return ans;
    }
    public void hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return;
        temp.add(root.val);//当前节点压栈
        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                //找到一条路径后，就把temp里的路径添加到ans里即可，注意需要创建新数组。
                ans.add(new ArrayList<>(temp));
            }
        }else{
            hasPathSum(root.left, targetSum-root.val);
            hasPathSum(root.right, targetSum-root.val);
        }
        temp.remove(temp.size()-1);//当前节点出栈。
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
