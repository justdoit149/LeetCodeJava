import java.util.ArrayList;
import java.util.List;

//�������ı����еݹ�͵������ַ������ݹ��д����ֻд��dfs���߼����ɣ���ʽ��ά����ջ
//�������������ֶ������ջģ�������

public class T0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        find(root, ans);
        return ans;
    }
    public void find(TreeNode node, List<Integer> ans){
        if(node == null){
            return;
        }
        find(node.left, ans);
        ans.add(node.val);
        find(node.right, ans);
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
        
    }
}
