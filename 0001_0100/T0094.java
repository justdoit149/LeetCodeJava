import java.util.ArrayList;
import java.util.List;

//������������������ַ�������Ҫ���գ���
//ǰ���ַ�������ֻ����һ�飬ʱ��O(n)���ռ�Ҫά��ջ�����O(logn)���O(n)
//�����ַ�����Ҫ�������飬ʱ��O(2n)Ҳ��O(n)����������Ҫά��ջ������ռ�O(1)��
//ʵ��������Ҷ���д������е�ָ�루�洢nullҲҪռͬ���ռ䣩��Morris�㷨ֻ�����ǽ���Щ�ռ�����������

public class T0094 {
    // // ����һ���ݹ鷽������򵥡�ֻ��Ҫд���߼���ܣ�����������ʽ��ά������ջ
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

    // // ��������������������ʽ��ά������ջ��
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    // // ����˼·������ĳ����ʱ������ѹջȻ�����������������������ջ���鿴����Ȼ�������������
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode pointer = root;
    //     while(true){
    //         while(pointer != null){
    //             stack.push(pointer);
    //             pointer = pointer.left;
    //         }
    //         if(!stack.isEmpty()){//��ջ��������value��Ȼ���ٱ�����������
    //             pointer = stack.pop();
    //             ans.add(pointer.val);
    //             pointer = pointer.right;
    //         }else{//ջ���ǵȴ������ģ�ջ����˵��������
    //             return ans;
    //         }
    //     }   
    // }

    // ��������Morris���������Ҳ��һ�ֵ�������
    // ���赱ǰ�������Ľڵ�Ϊx����x����������һֱ.right�ҵ����ұߵĽڵ㣬Ҳ������x֮ǰһ�����ʵĽڵ�
    // ������ڵ��.rightָ��x��������һ���������Ҫ�ڶ����ٷ���x��������
    // ����η���ֻ���ж��������ҽڵ㣬������ָ��x������˵���������Ѿ������ʹ��ˣ��ͷ���x��x��������
    // ע����Ҫ���½��Ǹ����޸ĵĽڵ��.right�ÿգ���֤���ݲ����޸ġ�
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
                //��������������ҽڵ��ǿգ��������������
                if(pre.right == null){
                    pre.right = pointer;
                    pointer = pointer.left;
                }else{//�ǿգ�˵���������������ˣ���ָ�����������������
                    pre.right = null;
                    ans.add(pointer.val);
                    pointer = pointer.right;
                }
            }else{//���������Ϊ�գ�˵�����������ˣ��ͷ��ʵ�ǰ�ڵ����������
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
