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
        //����ӱ�ͷ�����⸴�����ۡ�ʵ�ʷ��ֲ��üӱ�β����Ϊ����β��null�����Է��ڵȺ��ұ�
        ListNode begin = new ListNode(0, head);
        ListNode l = begin, temp1 = null, temp2 = null;
        //Ȼ��ʼ������һ�α������ɣ�����Ҫ����һ���ж��ٸ��ڵ㡣
        while(l.next != null && l.next.next != null){
            temp1 = l.next;
            temp2 = l.next.next.next;
            l.next = l.next.next;
            l.next.next = temp1;
            l.next.next.next = temp2;
            l = l.next.next;//����ı�l��ʵ�ֶ���޸�
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
