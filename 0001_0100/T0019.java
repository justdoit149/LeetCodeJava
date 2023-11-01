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
//����ָ���������Ӧ�ã����ҵ�����k��Ԫ�ء�
public class T0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head, r = head, ll = null;
        for(; n > 0; n--){
            r = r.next;
        }
        while(r != null){
            ll = l;//����ܽ����ѭ��˵��l != head���������ѭ��˵��l == head�ò���ll��
            l = l.next;
            r = r.next;
        }
        if(l == head){
            head = l.next;
        }else{//l��β��ʱ��l.next == null��Ҳ������else
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
