import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class T0099 {
    int index;
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> temp = new ArrayList<>();
        inOrder(root, temp);
        Collections.sort(temp);
        index = 0;
        inOrderWrite(root, temp);
    }
    public void inOrder(TreeNode root, List<Integer> temp){
        if(root == null) return;
        inOrder(root.left, temp);
        temp.add(root.val);
        inOrder(root.right, temp);
    }
    public void inOrderWrite(TreeNode root, List<Integer> temp){
        if(root == null) return;
        inOrderWrite(root.left, temp);
        root.val = temp.get(index++);
        inOrderWrite(root.right, temp);
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