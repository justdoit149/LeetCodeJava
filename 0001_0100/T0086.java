import java.util.LinkedList;
import java.util.Queue;
// import java.util.Stack;

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

//����һ������ֵ��¼������ֻ�ı�ֵ�����ı�����ṹ
//���������������������������а�С�ķ��ڵ�һ�����ķ��ڵڶ�������ϲ�������

public class T0086 {
    public ListNode partition(ListNode head, int x) {
        ListNode idx = head;
        Queue<Integer> less = new LinkedList<>();
        Queue<Integer> more = new LinkedList<>();
        while(idx != null){
            if(idx.val < x){
                less.add(idx.val);
            }else{
                more.add(idx.val);
            }
            idx = idx.next;
        }
        idx = head;
        
        while(!less.isEmpty()){
            idx.val = less.poll();
            idx = idx.next;
        }
        while(!more.isEmpty()){
            idx.val = more.poll();
            idx = idx.next;
        }
        return head;
    }
    public static void main(String[] args) {
        
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}