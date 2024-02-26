//对于链表，不知道整体的长度，找中间值、倒数第k个等，可以用快慢指针。

public class T0109 {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    public TreeNode build(ListNode l, ListNode r){
        if(l == r){
            return null;
        }
        ListNode mid = Mid(l, r);
        return new TreeNode(mid.val, build(l, mid), build(mid.next, r));
    }

    public ListNode Mid(ListNode l, ListNode r){
        ListNode fast = l;
        ListNode slow = l;
        while(fast != r && fast.next != r){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
