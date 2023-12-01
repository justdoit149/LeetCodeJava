import java.util.ArrayList;
import java.util.List;

//二叉树中序遍历，三种方法，都要掌握！！
//前两种方法都是只访问一遍，时间O(n)；空间要维护栈，最好O(logn)最差O(n)
//第三种方法需要访问两遍，时间O(2n)也是O(n)量级；不需要维护栈，额外空间O(1)。
//实际上树的叶子有大量空闲的指针（存储null也要占同样空间），Morris算法只不过是将这些空间利用起来了

public class T0094 {
    // // 方法一：递归方法，最简单。只需要写出逻辑框架，靠编译器隐式地维护函数栈
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     find(root, ans);
    //     return ans;
    // }
    // public void find(TreeNode node, List<Integer> ans){
    //     if(node == null){
    //         return;
    //     }
    //     find(node.left, ans);
    //     ans.add(node.val);
    //     find(node.right, ans);
    // }

    // // 方法二：迭代方法。显式地维护数据栈。
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    // // 迭代思路：遍历某个树时，把它压栈然后遍历其左子树，遍历完后出栈并查看根，然后遍历右子树。
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode pointer = root;
    //     while(true){
    //         while(pointer != null){
    //             stack.push(pointer);
    //             pointer = pointer.left;
    //         }
    //         if(!stack.isEmpty()){//出栈并访问其value，然后再遍历右子树。
    //             pointer = stack.pop();
    //             ans.add(pointer.val);
    //             pointer = pointer.right;
    //         }else{//栈里是等待遍历的，栈空了说明结束了
    //             return ans;
    //         }
    //     }   
    // }

    // 方法三：Morris中序遍历。也是一种迭代方法
    // 假设当前遍历到的节点为x，将x的左子树中一直.right找到最右边的节点，也就是在x之前一个访问的节点
    // 将这个节点的.right指向x，这样第一遍遍历后，需要第二遍再访问x的左子树
    // 但这次访问只进行对其找最右节点，发现能指向x，这样说明左子树已经被访问过了，就访问x和x的右子树
    // 注意需要重新将那个被修改的节点的.right置空，保证数据不被修改。
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        TreeNode pointer = root;
        TreeNode pre = null;
        while(pointer != null){
            if(pointer.left != null){
                pre = pointer.left;
                while(pre.right != null && pre.right != pointer){
                    pre = pre.right;
                }
                //如果左子树的最右节点是空，则访问左子树。
                if(pre.right == null){
                    pre.right = pointer;
                    pointer = pointer.left;
                }else{//非空，说明左子树被访问了，则恢复，并访问右子树。
                    pre.right = null;
                    ans.add(pointer.val);
                    pointer = pointer.right;
                }
            }else{//如果左子树为空，说明迭代到底了，就访问当前节点和右子树。
                ans.add(pointer.val);
                pointer = pointer.right;
            }
        }
        return ans;
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
}
