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

public class T0002 {
    //基本的链表遍历操作
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode((l1.val+l2.val) % 10, null);
        ListNode start = ans;//！！！需要记录开始位置，要不然到最后遍历到底回不来了
        int carry = (l1.val+l2.val) / 10;
        while(l1.next != null && l2.next != null){
            ans.next =  new ListNode((l1.next.val+l2.next.val + carry) % 10, null);
            carry = (l1.next.val+l2.next.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            ans = ans.next;
        }
        if(l1.next == null && l2.next != null){
            while(l2.next != null){
                ans.next =  new ListNode((l2.next.val + carry) % 10, null);
                carry = (l2.next.val + carry) / 10;
                l2 = l2.next;
                ans = ans.next;
            }
        }else if(l2.next == null && l1.next != null){
            while(l1.next != null){
                ans.next =  new ListNode((l1.next.val + carry) % 10, null);
                carry = (l1.next.val + carry) / 10;
                l1 = l1.next;
                ans = ans.next;
            }
        }
        if(carry > 0){
            ans.next = new ListNode(carry, null);
        }
        ans = start;
        return ans;
    }
    public static void main(String[] args) {
        // T0002 test = new T0002();

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}