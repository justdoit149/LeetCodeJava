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
//快慢指针遍历链表应用：查找倒数第k个元素。
public class T0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head, r = head, ll = null;
        for(; n > 0; n--){
            r = r.next;
        }
        while(r != null){
            ll = l;//如果能进这个循环说明l != head，不进这个循环说明l == head用不上ll了
            l = l.next;
            r = r.next;
        }
        if(l == head){
            head = l.next;
        }else{//l是尾的时候l.next == null，也适用于else
            ll.next = l.next;
        }
        return head;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        
    }
}
