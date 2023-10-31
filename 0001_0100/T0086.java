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

//方法一：把数值记录下来，只改变值而不改变链表结构
//方法二：开两个链表，遍历过程中把小的放在第一个里，大的放在第二个里，最后合并起来。

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