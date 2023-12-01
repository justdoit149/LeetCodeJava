/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class T0024 { 
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        //先添加表头，避免复杂讨论。实际发现不用加表尾，因为本身尾是null，可以放在等号右边
        ListNode begin = new ListNode(0, head);
        ListNode l = begin, temp1 = null, temp2 = null;
        //然后开始交换。一次遍历即可，不需要计数一共有多少个节点。
        while(l.next != null && l.next.next != null){
            temp1 = l.next;
            temp2 = l.next.next.next;
            l.next = l.next.next;
            l.next.next = temp1;
            l.next.next.next = temp2;
            l = l.next.next;//这个改变l，实现多次修改
        }
        return begin.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
