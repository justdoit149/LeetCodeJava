import java.util.LinkedList;
import java.util.Queue;

public class T0116 {
    // 层序遍历实现
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int n;
        while(!queue.isEmpty()){
            n = queue.size();
            for(int i = 0; i < n; i++){
                Node temp = queue.poll();
                temp.next = (i == n-1 ? null : queue.peek());
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
        return root;
    }

    // 官方O(1)额外空间做法：仍是按层，但下一层利用上一层的.next。
    // public Node connect(Node root) {
    //     if (root == null) return root;
    //     Node leftmost = root; //记录一层内最左的节点    
    //     while (leftmost.left != null) {
    //         Node head = leftmost;
    //         while (head != null) {
    //             head.left.next = head.right;
    //             if (head.next != null) {
    //                 head.right.next = head.next.left;
    //             }
    //             head = head.next;
    //         }
    //         leftmost = leftmost.left;
    //     }
    //     return root;
    // }
    
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}    
        public Node(int _val) {val = _val;}
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
